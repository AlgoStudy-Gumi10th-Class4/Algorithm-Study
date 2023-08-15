import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01타일 (실버3)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/1904
 */

/**
 * 시도 2
 * <p>
 * 1. 제발 나머지 구하라고 하면 매 칸 입력할 때마다 나머지 구하자.<br>
 * 2. 꼭 N 범위 1부터 들어오면 early exit 시키거나 배열 크기 확인하자.<br>
 * 같은 실수를 계속하네. 잘 좀 하자.
 * </p>
 * 결과: 18072KB / 140ms
 */
public class Juyong_230815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 아래에서 초기화할 때 dp[2] 값을 사용하는데 N이 1부터 들어오므로
        // N + 1 크기만큼 만들면 dp[0], dp[1]까지만 만들어져서 인덱스 에러남.
        // dp[1] 초가화 한 후 if (N == 1) System.out.println(dp[1]); return; 이렇게 early exit 할 수도 있지만
        // 그냥 dp[2]까지 만들어줘도 4바이트밖에 더 안 쓰니까 이렇게 함.
        int[] dp = new int[N + 2];

        dp[1] = 1; // 1만 만들 수 있음
        dp[2] = 2; // 00, 11 가능
        // dp[3] = dp[3 - 2] 뒤에 00 붙인 100, dp[3-1] 뒤에 1 붙인 001, 111
        // dp[4] = dp[4 - 1] 뒤에 1 붙인 1001, 0011, 1111, dp[4 - 2] 뒤에 00 붙인 0000, 1100.
        // dp[5] = 10011, 00111, 11111, 00001, 11001, 10000, 00100, 11100

        // 이진 수열을 만들라고 했으니 dp[2] 를 두 개 붙여 0000, 0011, 1100, 1111을 만들 수 있겠지만
        // 이렇게 하면 1001 을 만들 수 없음
        for (int i = 3; i <= N; i++) {
            // dp[i]에서 i가 짝수면 dp[i-2]에 00을 붙이거나 dp[i - 1] 뒤에 1을 붙일 수 있고
            // dp[i - 2]에 11을 붙이는 방법은 i가 홀 수일 때 이미 1을 붙이기 때문에 중복됨.
            // i가 홀수면 dp[i - 2]에 00을 붙이거나, dp[i - 1] 뒤에 1을 붙임
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        // 15746으로 나눈 나머지 출력
        System.out.println(dp[N] % 15746);
    }
}
