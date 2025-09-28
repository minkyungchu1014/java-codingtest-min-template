import java.util.*;

public class Main {
    public static void main(String[] args){
        int[][] graph = {{0,1,9},{0,2,3},{1,0,5},{2,1,1}};
        int start = 0, n = 3;

        Solution solution = new Solution();
        int[] result = solution.solution(graph, start, n);

        System.out.print(Arrays.toString(result));

//        for (int i = 0; i < result.length; i++) {
//            if (i > 0) System.out.print(" ");
//            System.out.print(result[i]);
//        }
//        System.out.println();
    }
}
