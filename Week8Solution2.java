import java.util.Arrays;

class Week8Solution2 {
    private static int max;
    private static int[] answer;
    private static int[] apeach;

    //dfs로 모든 경우 탐색
    private static void dfs(int n, int idx, int[] ryan) {
        //n이 0이되면 점수차이 계산(화살을 다 썼을 경우)
        if (n == 0) {
            calculate(ryan);
//            System.out.print(Arrays.toString(ryan) + " : " + getScore(ryan) + "\n");
            return;
        }

        //마지막 10점 과녁에 다다르면 남은 화살을 모두 꽂음
        //평가 누락 방지
        if (idx == 10) {
            ryan[10] += n;
            calculate(ryan);
            ryan[10] -= n;
            return;
        }

        for (int i = idx; i <= 10; i++) {
            if (n >= apeach[i]+1) {
                ryan[i] = apeach[i] + 1;
                dfs(n - ryan[i], i+1, ryan);
                ryan[i] = 0;
            }
        }

//        저자님 풀이!
//        for (int i = 0; i <= 10; i++) {
//            int cnt = Math.min(n, apeach[i]+1);
//            ryan[i] = cnt;
//            dfs(n - cnt, i+1, ryan);
//            ryan[i] = 0;
//            }
//        }
    }

    //apeach와 ryan의 점수 차이 계산
    private static int getScore(int[] ryan) {
        int score = 0;
        for(int i = 0; i <= 10; i++) {
            if(ryan[i] + apeach[i] == 0) continue;
            score += ryan[i] > apeach[i] ? (10 - i) :-(10 - i);
        }
        return score;
    }

    private static void calculate(int[] ryan) {
        int score = getScore(ryan);
        if (score > max) {
            max = score;
            answer = ryan.clone();
        }
        //점수차이가 같을 때, 낮은 점수를 더 많이 맞힌 경우로 갱신
        else if (max > 0 && score == max) {
            for (int i = 10; i >= 0; i--) {
                if(ryan[i] == answer[i]) continue;
                if (ryan[i] > answer[i]) {
                    answer = ryan.clone();
                    break;
                }
            }
        }
    }

    /**
     * @param n
     * @param info
     * @return
     */
    public static int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        dfs(n, 0, new int[11]);

        return max == 0 ? new int[] { -1 } : answer;
    }

}


