// 기타 레슨 (실버1) https://noj.am/2343
//
// 결과
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2343&from_mine=1
// 
// 기억할 점
//

// 시도 1 : 틀림
// 
// 접근 방법
// N개의 숫자를 M개의 배열에 나누어 넣기
// N개의 숫자 배열을 자를 때 순서 보장 필요
// M개 배열은 모두 크기가 같아야 하고, 이 크기가 최소가 되려면
// 각 M배열에 들어가는 숫자 합이 가장 크면 되지 않을까


import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JY_230726 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int[] lectures = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

            // lecture 배열 M등분
            int[] indexes = new int[M];
            int[] lectures_sum = new int[M];

            int q = N / M;
            for (int i = 0; i < M; i++) {
                indexes[i] = q * i;
                for (int j = q * i; j < q * (i + 1); j++) {
                    lectures_sum[i] += lectures[j];
                }
            }

            int cnt = 0;
            int max_size = Integer.MAX_VALUE;
            while (cnt <= N / 2 + 1) {
                // System.out.println(Arrays.toString(indexes));
                // System.out.println(Arrays.toString(lectures_sum));

                int[] deltas = new int[M - 1];
                int max_delta_idx = 0;
                for (int i = 0; i < M - 1; i++) {
                    deltas[i] = Math.abs(lectures_sum[i+1] - lectures_sum[i]);
                    if (deltas[i] >= deltas[max_delta_idx]) {
                        max_delta_idx = i;
                    }
                }
                // System.out.println(Arrays.toString(deltas));
                // System.out.println(max_delta_idx);

                int g1_idx = max_delta_idx, g2_idx = max_delta_idx + 1;

                if (lectures_sum[g1_idx] > lectures_sum[g2_idx]) {
                    lectures_sum[g1_idx] -= lectures[indexes[g2_idx]];
                    lectures_sum[g2_idx] += lectures[indexes[g2_idx]];
                    indexes[g2_idx] -= 1;
                } else {
                    lectures_sum[g2_idx] -= lectures[indexes[g2_idx]];
                    lectures_sum[g1_idx] += lectures[indexes[g2_idx]];
                    indexes[g2_idx] += 1;
                }

                int current_max = lectures_sum[0];
                for (int i = 1; i < M; i++) {
                    current_max = Math.max(current_max, lectures_sum[i]);
                }
                max_size = Math.min(max_size, current_max);
                cnt += 1;
            }

            System.out.println(max_size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
