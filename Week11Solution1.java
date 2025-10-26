import java.util.Arrays;

/**
 * Week 11 - Solution 1
 *
 * 11주차 : 동적 계획법 문제 풀이
 * 문제 72 정수 삼각형
 *
 * @author 추민경
 * @version 1.0
 */
public class Week11Solution1 {

    public static int solution(int[][] arr) {
        int n = arr.length;
        int [][] dp = new int[n][n];

        for(int i = 0 ; i < n; i++){
            dp[n-1][i] = arr[n-1][i]; // 배열 맨 마지막 줄 초기화 아래서부터 -> 위로
        }

        for (int i = n-2 ; i >=0 ; i--){ // 아래서부터 위로
            for(int j = 0 ; j <= i ; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }
        return dp[0][0];
    }

    public static int main(String[] args) {
        int[][] array = parse2D(args[0]);
        System.out.println(solution(array));
        return solution(array);


    }

    private static int[][] parse2D(String s) {
        s = s.replaceAll("\\[\\[", "").replaceAll("]]", "");
        String[] rows = s.split("\\],\\[");
        int[][] result = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(",");
            result[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                result[i][j] = Integer.parseInt(nums[j].trim());
            }
        }
        return result;
    }
}
