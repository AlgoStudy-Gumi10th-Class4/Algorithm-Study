import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 도영이가 만든 맛있는 음식 (실버2)
 * <p>
 * 전에 풀었는데 비트마스크로 다시 풀어보기
 * 시간초과. 비트마스크로 부분집합 만들고 부분 집합이 다 만들어졌을 때 매 번 새로 계산해서 그런 것 같다.
 * 이전 구현처럼 재귀 호출할 때마다 직전까지 선택한 재료를 계산한 값을 전달해줘야 속도가 빠르고
 * 근데 그렇게 구현한다면 비트마스크를 쓸 이유가 없지 않나..?
 * </p>
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/2961
 */
class Juyong_230813 {
    static int[] bitter, sour;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        int N = Integer.parseInt(br.readLine());
        bitter = new int[N];
        sour = new int[N];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            bitter[i] = Integer.parseInt(tmp[0]);
            sour[i] = Integer.parseInt(tmp[1]);
        }

        calc(N, 0, 0);

        System.out.println(minDiff);
    }

    static void calc(int N, int cnt, int flag) {
        if (cnt == N) {
            int b = 1;
            int s = 0;
            boolean used = false;
            for (int i = 0; i < N; i++) {
                if ((flag & (1 << i)) == 0) continue;
                used = true;
                b *= bitter[i];
                s += sour[i];
            }
            if (used) {
                minDiff = Math.min(minDiff, Math.abs(b - s));
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;
            calc(N, cnt + 1, flag);
            calc(N, cnt + 1, flag | 1 << i);
        }
    }
}
