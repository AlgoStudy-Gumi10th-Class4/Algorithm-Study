import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 캐슬 디펜스
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/17135
 */

/**
 * 결과: 133396KB / 948ms
 */
public class Juyong_230819 {

    static int N, M, D;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력
        String[] NMD = br.readLine().split(" ");
        N = Integer.parseInt(NMD[0]);
        M = Integer.parseInt(NMD[1]);
        D = Integer.parseInt(NMD[2]);

        // 맵 입력
        // N + 1행은 성벽. 궁수 위치 가능
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 궁수 배치 (y좌표)
        List<int[]> archersList = new LinkedList<>();
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    archersList.add(new int[] {i, j, k});
                }
            }
        }

        // 게임 시작
        // 궁수가 활을 쏠 수 있는 범위는 D=3일 때 다음과 같음
        // . . o . .
        // . o o o .
        // o o o o o
        // - - a - -
        int maxElimination = 0;

        // 궁수 좌표가 될 수 있는 순열 리스트 중 하나씩 체크
        for (int[] archers : archersList) {
            int thisElimination = 0;

            // 각 궁수 좌표 {i, j}를 기준으로
            for (int i = N; i > 0; i--) {
                for (int j : archers) {
                    // 지금 궁수에서 가장 가까운 적 찾기
                    List<int[]> enemies = new LinkedList<>();

                    Queue<int[]> q = new ArrayDeque<>();
                    boolean[][] visited = new boolean[N][M];

                    int[] dx = {0, -1, 0};
                    int[] dy = {-1, 0, 1};

                    q.add(new int[] {i - 1, j});
                    visited[i - 1][j] = true;

                    while (!q.isEmpty()) {
                        int[] u = q.poll();
                        // 다른 궁수가 이미 쏜 적도 쏠 수 있으니 1 이상
                        if (map[u[0]][u[1]] >= 1) {
                            int dist = Math.abs(i - u[0]) + Math.abs(j - u[1]);
                            if (dist <= D) {
                                enemies.add(new int[] {u[0], u[1], dist});
                            }
                        }

                        for (int d = 0; d < dx.length; d++) {
                            int nx = u[0] + dx[d];
                            int ny = u[1] + dy[d];
                            if (nx < 0 || ny < 0 || ny >= M) continue;
                            if (visited[nx][ny]) continue;

                            q.add(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }

                    if (!enemies.isEmpty()) {
                        // 적 정렬 - 가까운 순 > 왼쪽 순
                        enemies.sort((a, b) -> {
                            return a[2] == b[2] ? a[1] - b[1] : a[2] - b[2];
                        });

                        // 여러 궁수가 같은 적 공격 가능하므로 제거 않고 공격 횟수만 카운트.
                        int[] enemy = enemies.get(0);
                        map[enemy[0]][enemy[1]] += 1;
                    }
                }

                // 공격 다 하고 나서
                for (int n = 0; n < N; n++) {
                    for (int m = 0; m < M; m++) {
                        // 한 번 이상 공격 당한 적 제거
                        if (map[n][m] > 1) map[n][m] = -1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != -1) continue;
                    // 제거 된 적 카운트
                    thisElimination += 1;
                    // 원상복구
                    map[i][j] = 1;
                }
            }
            maxElimination = Math.max(maxElimination, thisElimination);
        }
        System.out.println(maxElimination);
    }
}
