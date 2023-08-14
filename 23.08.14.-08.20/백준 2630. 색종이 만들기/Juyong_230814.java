import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 색종이 만들기 (실버2)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/2630
 */

/**
 * 결과: 16448KB / 188ms
 */
public class Juyong_230814 {

    static int cntWhite, cntBlue;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][];
        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dividePaper(N, 0, 0);

        System.out.printf("%d\n%d", cntWhite, cntBlue);
    }

    static void dividePaper(int n, int x, int y) {
        if (n == 1) {
            cntWhite += paper[x][y] == 0 ? 1 : 0;
            cntBlue += paper[x][y] == 1 ? 1 : 0;
            return;
        }

        int thisWhite = 0;
        int thisBlue = 0;
        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                int p = paper[i][j];
                thisWhite += p == 0 ? 1 : 0;
                thisBlue += p == 1 ? 1 : 0;
                if (thisBlue != 0 && thisWhite != 0) {
                    break loop;
                }
            }
        }

        int nn = n * n;
        if (nn == thisWhite) {
            cntWhite += 1;
        } else if (nn == thisBlue) {
            cntBlue += 1;
        } else {
            int n2 = n / 2;
            dividePaper(n2, x, y);
            dividePaper(n2, x, y + n2);
            dividePaper(n2, x + n2, y);
            dividePaper(n2, x + n2, y + n2);
        }
    }
}
