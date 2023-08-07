// 스타트와 링크 (실버2) https://noj.am/14889
//
// 접근 방법
// 짝수 N명의 사람을 2개 팀으로 나누는데 두 팀의 능력치 차이가 최소인 경우 반환
//
// 결과 https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=14889&from_mine=1
// 시도 2: 24120KB / 484ms
// 시도 3 로직 최적화: 20456KB / 332ms
//
// 기억할 점
// 1차 시도 때 팀원 수가 안 맞을 때를 체크하는 코드를 놓쳤음.

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Juyong_230728 {
    static int N;
    static int[][] S;
    static int MIN_STAT_DIFF = Integer.MAX_VALUE;

    static void calcStats(int[] team, int idx, int cnt) {
        if (idx == N) {
            // 팀원 수 안 맞으면 반환
            if ((cnt << 1) - N != 0) return;

            // 팀 배정 끝났으면 1팀 2팀 스탯 차이 계산
            int[] ts = {0, 0};
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (team[i] - team[j] != 0) continue;
                    ts[team[i]] += S[i][j] + S[j][i];
                }
            }
            MIN_STAT_DIFF = Math.min(MIN_STAT_DIFF, Math.abs(ts[0] - ts[1]));
            return;
        }

        team[idx] = 0;
        calcStats(team, idx + 1, cnt);
        team[idx] = 1;
        calcStats(team, idx + 1, cnt + 1);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            for (int i = 0; i < N; i++) {
                S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (Exception e) {}

        calcStats(new int[N], 0, 0);
        System.out.println(MIN_STAT_DIFF);
    }
}
