import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 연결 요소의 개수 (실버2)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/11724
 */

/**
 * M이 0인 경우 핸들링.
 * 그래프 키 없는 경우
 */
public class Nojam11724 {
    static int N, M, cnt;
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        // 그래프 입력
        graph = new HashMap<>(N);

        for (int i = 0; i < M; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph.putIfAbsent(u, new ArrayList<>(N));
            graph.putIfAbsent(v, new ArrayList<>(N));

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 연결성 체크
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            cnt += 1;
            if (graph.get(i) != null) bfs(i);
        }

        System.out.println(cnt);
    }

    static void bfs(int u) {
        Queue<Integer> q = new ArrayDeque<>(N);
        q.offer(u);
        visited[u] = true;

        // 큐가 비어있지 않고, 다 방문하지 않았다면 반복 계속
        while (!q.isEmpty()) {
            u = q.poll();
            
            for (int v : graph.get(u)) {
                if (visited[v]) continue;
                q.offer(v);
                visited[v] = true;
            }
        }
    }
}
