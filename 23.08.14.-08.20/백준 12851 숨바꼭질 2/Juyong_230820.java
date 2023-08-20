import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 숨바꼭질 2
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/12851
 */

/**
 * 시도 1
 * 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초인지, 같은 시간이 나오는 방법 수가 몇 개인지 
 * bfs로 1초씩 더하면서 K위치를 찾았을 때 시간을 기록하고, 그 시간과
 * 같은 시간이 나오는 너비 탐색 중 위치 확인하여 카운트
 * 
 * 방문 처리하는 위치를 항상 q에 넣은 뒤에 해야되는거 아님. 로직 확인 잘하자
 */
public class Juyong_230820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        Queue<int[]> q = new ArrayDeque<>(100001);
        boolean[] visited = new boolean[100001];

        // 수빈이 위치에서 시작 {위치, 시간(초)}
        q.add(new int[] {N, 0});
        visited[N] = true;

        int t = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] u = q.poll();

            // 동생을 찾았을 때
            if (u[0] == K) {
                // 처음 찾았다면 시간 기록
                if (t == 0) t = u[1];
                // 최단시간과 같을 때만 카운트
                cnt += u[1] == t ? 1 : 0;
            }

            // 만약 이번에 방문한 시간이 t보다 크다면
            // bfs이므로 최단 시간 t에 방문 가능한 노드는 다 방문한 셈.
            if (t != 0 && u[1] > t) break;

            // 여기서 방문 처리. K에 갈 수 있는 방법 수를 구하는 문제이므로 같은 칸에 여러 번 갈 수 있어야 됨
            visited[u[0]] = true;

            for (int v : new int[] {u[0] - 1, u[0] + 1, u[0] * 2}) {
                if (v < 0 || v > 100000) continue;
                if (visited[v]) continue;
                q.add(new int[] {v, u[1] + 1});
            }
        }

        System.out.println(t + "\n" + cnt);
    }
}
