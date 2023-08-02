import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 하노이 탑 이동 순서 (실버1)
 * 
 * @author cheesecat47@gmail.com
 * @see https://noj.am/11729
 */

/**
 * 1시간 정도 고민하다가 하노이 탑은 이미 정해진 방법이 있으니 보고 익히는게 나을 것으로 판단
 * 
 * 결과: 331728KB / 2380ms
 * 
 * @see https://ko.khanacademy.org/computing/computer-science/algorithms/towers-of-hanoi/a/towers-of-hanoi
 * @see https://brunch.co.kr/@younggiseo/139
 */
public class Juyong_230802 {

    static void hanoi(int k, int from, int to, int tmp, int cnt, StringBuilder sb) {
        if (k == 1) {
            sb.append(String.format("%d %d\n", from, to));
            return;
        }
        hanoi(k - 1, from, tmp, to, cnt + 1, sb);
        sb.append(String.format("%d %d\n", from, to));
        hanoi(k - 1, tmp, to, from, cnt + 1, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        System.out.println((int) (Math.pow(2, K) - 1));

        StringBuilder sb = new StringBuilder();
        hanoi(K, 1, 3, 2, 1, sb);
        System.out.println(sb.toString());
    }
}
