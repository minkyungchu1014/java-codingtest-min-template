import java.util.Arrays;

/**
 * Week 10 - Solution 1
 *
 * 10주차 : 시뮬레이션 문제 풀이
 * 문제 59 이진 변환 반복하기
 *
 * @author 추민경
 * @version 1.0
 */
public class Week10Solution2 {
    private static int[][] arr;
    private static int n;
    private static int[][] rotated;

    public static int[] solution(String str) {
        int resultCnt = 0;
        int zeroCnt = 0;

        //1이 될때까지 반복
        while (!str.equals("1")) {
            //반복 횟수 카운트
            resultCnt += 1;
            //1을 없애 0의 개수 카운트
            int Cnt = str.replace("1", "").length();
            zeroCnt += Cnt;
            str = Integer.toBinaryString(str.length() - Cnt);
        }
        return new int[]{resultCnt, zeroCnt};
    }

    public static int[] main(String[] args) {
        // 예: "01110"
        if (args.length < 1) {
            return null;
        }
        System.out.println(Arrays.toString(solution(args[0])));
        return solution(args[0]);
    }
}
