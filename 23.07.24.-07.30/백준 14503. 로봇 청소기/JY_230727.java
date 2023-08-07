// 로봇 청소기 (골드5) https://noj.am/14503
//
// 결과: 14620KB / 136ms
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=14503&from_mine=1
//
// 기억할 점
//

// 시도 1
//
// 접근 방법
// 구현 문제니까 조건 잘 보고 착실히 구현
//
// 실수한 부분
// 1. move 변수 종료 조건을 하나 누락했었나 봄. 무한 재귀 걸렸음.
// 2. visited 배열에 방문한 경우를 1로 체크했는데 벽이랑 중복돼서 잘못 카운트 됨.


import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JY_230727 {
    static int N;
    static int M;
    static int[][] room;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean isInRoom(int x, int y) {
        // 맵 밖인 경우
        if (x < 0 || y < 0 || x >= N || y >= M) return false;
        // 맵 안이지만 벽인 경우
        if (room[x][y] == 1) return false;
        return true;
    }

    static void move(int x, int y, int d) {
        // 현재 칸이 맵 밖인 경우 반환
        if (!isInRoom(x, y)) return;

        // 현재 칸이 아직 청소되지 않은 경우 (room[x][y] == 0) 현재 칸 청소
        // visited가 0이면 방문 안 한 경우, 1은 벽, 2는 방문한 경우
        visited[x][y] = 2;

        // 주변 4칸 중
        int yet_cleaned = 1;
        for (int i = 0; i < 4; i++) {
            yet_cleaned *= visited[x + dx[i]][y + dy[i]];
        }
        if (yet_cleaned != 0) {
            // 청소되지 않은 빈 칸이 없는 경우 
            if (isInRoom(x - dx[d], y - dy[d])) {
                // 후진 가능하면 후진해서 1번으로
                move(x - dx[d], y - dy[d], d);
            } else {
                // 후진 불가면 종료
                return;
            }
        } else {
            // 청소되지 않은 빈 칸이 있는 경우
            // 반시계 방향으로 90도 회전
            d = d == 0 ? 3 : d - 1;
            // 이 방향으로 한 칸 앞이 (방 안이고) 청소되지 않은 빈 칸인 경우 한 칸 전진
            if (isInRoom(x + dx[d], y + dy[d]) && visited[x + dx[d]][y + dy[d]] == 0) {
                x += dx[d];
                y += dy[d];
            }
            move(x, y, d);
        }
        return;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 초기화
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);

            String[] RCD = br.readLine().split(" ");
            int r = Integer.parseInt(RCD[0]);
            int c = Integer.parseInt(RCD[1]);
            int d = Integer.parseInt(RCD[2]);

            room = new int[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                visited[i] = room[i].clone();
            }

            move(r, c, d);

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] != 2) continue;
                    cnt += 1;
                }
            }
            System.out.println(cnt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
