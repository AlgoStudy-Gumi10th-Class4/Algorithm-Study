import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IOIOI (실버1)
 *
 * <p>
 * 시도 1
 * 문자열 길이가 100만까지 가므로 O(N)에 처리해야 될 것 같다.
 * 투포인터?
 * </p>
 *
 * 결과: 14200KB / 124ms / 50점
 *
 * @see https://noj.am/5525
 */
public class Juyong_230805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] P = {N, N + 1}; // O가 N개, I가 N+1개
        int Plen = 2 * N + 1;
        int[] countIO = {0, 0};
        int answer = 0;

        int left = 0;
        int right = 0;
        // 처음 위치로 이동
        // O이면 지나가고 처음으로 I가 나온 곳을 left로 설정
        while (S.charAt(left) == 'O') {
            left++;
        }
        right = left;

        boolean b = false;
        while (right < M) {
            b = S.charAt(right) == 'O';

            // 문자열 내 I,O 개수 세는데
            // 현재 righ가 직전 것과 같다면 (II, OO 같은 경우)
            if (right > 0 && S.charAt(right - 1) == S.charAt(right)) {
                // countIO 초기화
                // left = right;
                countIO = new int[] {0, 0};
                left = right;
                countIO[0] += b ? 1 : 0;
                countIO[1] += b ? 0 : 1;
                right += 1;
                continue;
            }

            // 이번 칸 카운트
            countIO[0] += b ? 1 : 0;
            countIO[1] += b ? 0 : 1;

            // 현재 부분 문자열 길이가 패턴 길이와 같지 않다면 카운트 후 right 증가
            if (right + 1 < left + N) {
                right += 1;
                continue;
            }

            // 패턴 길이와 같아지면
            if (right - left + 1 == Plen) {
                // countIO 확인하고
                if (countIO[0] == P[0] && countIO[1] == P[1]) {
                    answer += 1;
                }

                // 다음 칸 진행을 위해 left 한 칸 당김
                countIO[0] -= b ? 1 : 0;
                countIO[1] -= b ? 0 : 1;
                left += 1;
            }
            right += 1;
        }

        System.out.println(answer);
    }
}
