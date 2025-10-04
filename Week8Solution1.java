import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Week8Solution1 {
    private static int result;
    private static int[][] Dungeons;
    private static boolean[] visited;


    private static void dfs(int k, int count) {
        //던전 갯수 만큼 탐험
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                //재귀함수 호출하면서 max 값 갱신
                dfs(k - Dungeons[i][1], count + 1);
                result = Math.max(result, count + 1);
                visited[i] = false;
            }
        }
    }
    /**
     * @param k(현재 피로도)
     * @param dungeons(던전별 최소 필요 피로도, 소모 피로도)
     * @return result(탐험할 수 있는 최대 던전 수)
     */
    public static int solution(int k, int[][] dungeons) {
        result = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];

        dfs(k, 0);
        return result;
    }

}


