import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 숨바꼭질
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/1697
 */

public class Juyong_230818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {N, 0});

        int answer = 0;
        while (!q.isEmpty()) {
            int[] u = q.poll();

            if (u[0] == K) {
                answer = u[1];
                break;
            }

            for (int v : new int[] {u[0] - 1, u[0] + 1, u[0] * 2}) {
                // available v
                if (v < 0 || v > 100000)
                    continue;
                if (visited.get(v) != null)
                    continue;

                q.offer(new int[] {v, u[1] + 1});
                visited.put(v, true);
            }
        }
        System.out.println(answer);
    }
}
