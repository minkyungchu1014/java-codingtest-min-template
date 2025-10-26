/**
 * Week 10 - Solution 1
 *
 * 10주차 : 시뮬레이션 문제 풀이
 * 문제 59 배열 회전하기
 *
 * @author 추민경
 * @version 1.0
 */
public class Week10Solution1 {
    private static int[][] arr;
    private static int n;
    private static int[][] rotated;

    private static void rotate(int k) {
        k = ((k % 4) + 4) % 4; // 음수 회전도 처리하기 위해 4를 더함
        int[][] rotated = new int[n][n];
        while (k-- > 0) {
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[j][(n - 1) - i] = arr[i][j];
                    System.out.println("rotated[" + j + "][" + ((n - 1) - i) + "] = arr[" + i + "][" + j + "]");
                }
            }
        }
    }

    public static int[][] solution(int[][] array, int k) {
        arr = array;
        n = array.length;
        rotate(k);
        return rotated;
    }

    public static void main(String[] args) {
        // 예: "[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]" 1
        if (args.length < 2) {
            System.err.println("Usage: Week10Solution1 \"[[1,2,...]]\" k");
            return;
        }

        int[][] array = parse2D(args[0]);
        int k = Integer.parseInt(args[1]);
        int[][] result = solution(array, k);

        // 결과 출력 (null 방지)
        if (result != null) {
            for (int[] row : result) {
                System.out.println(java.util.Arrays.toString(row));
            }
        }
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
