import java.util.*;

public class Main {
    public static void main(String[] args){
//        int[][] dungeons = {{80,20},{50,40},{30,10}};
//        int k = 80;
//
//        Week8Solution1 solution = new Week8Solution1();
//        int result = solution.solution(k, dungeons);

        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        Week8Solution2 solution = new Week8Solution2();
        int[] result = solution.solution(n, info);
        System.out.print(Arrays.toString(result));

    }
}
