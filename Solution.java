import java.util.*;

class Solution {
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    /**
     *  다익스트라 알고리즘
     *  1) 시작노드에서 각 노드까지 거리 초기화
     *  2) 현재 가장 적은 비용으로 갈 수 있는 노드 선택(각 노드는 한 번씩만 선택)
     *  3) 2에서 선택된 노드와 인접한 노드들의 거리 갱신
     * @param graph(노드의 연결정보와 가중치) ex) [[1,3,2],[2,3,4]] => 1번노드에서 3번노드로 가는 가중치 2, 2번노드에서 3번노드로 가는 가중치 4
     * @param start(출발노드)
     * @param n(노드의 개수)
     * @return 시작노드부터 모든 노드까지의 최단 거리를 순서대로 저장한 배열
     */

    //1) 인접리스트를 저장할 ArrayList 배열 초기화
    //반드시 for문을 통해서 각 배열의 인덱스마다 ArrayList 객체를 생성해서 할당해야함.
    public static int[] solution(int[][] graph, int start, int n) {
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

    //2) graph정보(int[][] graph)를 인접리스트(ArrayList<Node>[] adjList)에 저장
    // ex. [[0,1,9],[0,2,3]] start=0 n=3 => adjList[0] = [(1,9),(2,3)], adjList[1] = [], adjList[2] = []
    for (int[] edge : graph) {
        adjList[edge[0]].add(new Node(edge[1], edge[2]));
    }
    System.out.print(adjList.toString());

    //3) 모든 노드의 거리 값을 무한대로 초기화
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    //4) 시작노드의 거리는 0으로 초기화
    dist[start] = 0;

    //5) 우선순위 큐를 생성하고 시작 노드를 삽입
    //Integer.compare() 하는 이유? PriorityQueue는 기본적으로 오름차순 정렬이므로, 비용이 낮은 노드가 우선적으로 처리되도록 하기 위함
    //일반 큐 (ArrayDeque, LinkedList): 그냥 System.out.println(q) 또는 q.toString()
    //우선순위큐(PriorityQueue): 정렬해서 출력하거나 복사본을 poll해가며 출력
    PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
        //6) 현재 가장 거리가 짧은 노드를 가져옴
        Node now = pq.poll();

        //7) 현재 노드의 거리가 이미 기록된 거리보다 크면 무시
        System.out.print("현재 노드 거리와 이미 기록된 거리 비교 :"+ dist[now.dest] + " < " + now.cost + "\n");
        if (dist[now.dest] < now.cost) continue;

        //8) 현재 노드와 인접한 노드들을 확인
        for (Node next : adjList[now.dest]) {

            //9) 새로운 거리가 더 짧으면 갱신하고 우선순위 큐에 삽입
            if (dist[next.dest] > now.cost + next.cost) {
                dist[next.dest] = now.cost + next.cost;
                pq.add(new Node(next.dest, dist[next.dest]));
            }
        }
    }

    return dist;

}
}


