import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식 (실버1)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/2156
 */

/**
 * 시도 2 DP...
 *
 * <p>
 * 점화식 세우는거 막혀서 예현 성규 코드 참고
 * </p>
 * 결과: 14992KB / 144ms
 */
class Juyong_230811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        int N = Integer.parseInt(br.readLine());
        int[] w = new int[10001];
        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[10001];
        d[1] = w[1];
        d[2] = w[1] + w[2];

        if (N <= 2) {
            System.out.println(d[N]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            // 이번이 세 번째라 안 마시는 경우;
            int a = d[i - 1];

            // 한 칸 띄우고 마시는 경우 (연속 1)
            int b = d[i - 2] + w[i];

            // 세 칸 전 마셨고, 한 칸 띄우고 -1번째와 이번 것 마시는 경우 (연속 2)
            int c = d[i - 3] + w[i - 1] + w[i];

            d[i] = Math.max(a, Math.max(b, c));
        }
        System.out.println(d[N]);
    }
}

/**
 * <p>
 * 시도 1 시간 초과..?
 *
 * </p>
 * <p>
 * <p>
 * 결과: KB / ms
 */
//class Nojam2156 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 문제 입력
//        int N = Integer.parseInt(br.readLine());
//        int[] wine = new int[N];
//        for (int i = 0; i < N; i++) {
//            wine[i] = Integer.parseInt(br.readLine());
//        }
//
//        System.out.println(drink(wine, N, 0, 0, 0));
//    }
//
//    static int drink(int[] wine, int N, int idx, int total, int streak) {
//        // 종료조건 끝까지 탐색한 경우
//        if (idx == N) return total;
//
//        // 이번 잔 안 마시면 streak 초기화
//        int maxDrink = drink(wine, N, idx + 1, total, 0);
//        // 마시는 경우. 3잔 연속 마실 수 없음
//        if (streak == 2) return maxDrink;
//        return Math.max(maxDrink, drink(wine, N, idx + 1, total + wine[idx], streak + 1));
//    }
//}
