package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_Jiyun {

	static String[][] map; // 공간 배열
	static int N;
	static int cnt; // 이동 칸 수
	// 벽을 만나면 이동 X
	// 다른 로봇이 있던 초기 위치 이동 X
	// 같은 타입 로봇 여러대 가능

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) { // 테스트 케이스 시작
			cnt = 0;
			N = Integer.parseInt(br.readLine()); // 공간 크기
			map = new String[N][N]; // N*N의 크기

			for (int i = 0; i < N; i++) { // 공간의 값 입력 S-공백 W-벽 A,B,C-로봇
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < N; i++) { // 공간에서 로봇 찾아서 이동 거리 체크
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("A") || map[i][j].equals("B") || map[i][j].equals("C")) { // 로봇 찾으면
						find(i, j); // 이동 거리 수 체크하기
					} else {
						continue;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");

		}
		System.out.println(sb);
	}

	static void find(int x, int y) { // 로봇의 초기 위치 가져옴
		String robot = map[x][y]; 
		switch (robot) {
		case "A": // 로봇이 A일 때
			map[x][y] = "W"; // 로봇의 초기 위치 이동 못하므로 벽으로 변경
			int my = y + 1; // A는 오른쪽으로만 한칸씩 이동
			while (true) {
				if (!valid(x, my)) { // 이동 불가하면 종료
					break;
				} else {
					my++; // 오른쪽으로 한칸씩 이동
					cnt++; // 이동 칸 수 증가
				}
			}
			break;
		case "B": // 로봇이 B일 때
			map[x][y] = "W"; // 로봇의 초기 위치 이동 못하므로 벽으로 변경
			int ux = x; // 좌표 이동이 있으므로 임시 좌표 등록
			while (true) { 
				if (!valid(ux+1, y)) { // B로봇 상 방향으로 이동할 때
					ux = x; // 멈추기 전에 초기 좌표로 초기화
					break;
				} else {
					ux++; // 방향 좌표 증가
					cnt++; // 이동 칸 수 증가
				}
			}
			while (true) {
				if (!valid(ux-1, y)) { // B로봇 하 방향으로 이동할 때
					ux = x;
					break;
				} else {
					ux--; // 방향 좌표 감소 (아래 방향 이동이므로)
					cnt++; // 이동 칸 수 증가
				}
			}
			break;
		case "C":
			map[x][y] = "W"; // 로봇의 초기 위치 이동 못하므로 벽으로 변경
			int[] dx = { -1, -1, 1, 1 }; // 왼상, 오상, 왼하, 오하
			int[] dy = { -1, 1, -1, 1 }; // 왼상, 오상, 왼하, 오하
			
			int tx = x; // 좌표 이동이 있으므로 임시 좌표 등록
			int ty = y;
			while (true) {
				if (!valid(tx + dx[0], ty + dy[0])) { // 왼상 방향으로 이동할 때
					tx = x; // 멈추기 전에 초기 좌표로 초기화
					ty = y;
					break;
				} else {
					tx = tx + dx[0]; // 계속 왼상 방향으로 좌표 이동시켜줌
					ty = ty + dy[0];
					cnt++; // 이동 칸 수 증가
				}
			}
			while (true) {
				if (!valid(tx + dx[1], ty + dy[1])) { // 오상 방향으로 이동할 때
					tx = x; // 멈추기 전에 초기 좌표로 초기화
					ty = y;
					break;
				} else {
					tx = tx + dx[1]; // 계속 왼상 방향으로 좌표 이동시켜줌
					ty = ty + dy[1]; // 계속 왼상 방향으로 좌표 이동시켜줌
					cnt++; // 이동 칸 수 증가
				}
			}
			while (true) {
				if (!valid(tx + dx[2], ty + dy[2])) { // 왼하 방향으로 이동할 때
					tx = x; // 멈추기 전에 초기 좌표로 초기화
					ty = y;
					break;
				} else {
					tx = tx + dx[2]; // 계속 왼상 방향으로 좌표 이동시켜줌
					ty = ty + dy[2]; // 계속 왼상 방향으로 좌표 이동시켜줌
					cnt++; // 이동 칸 수 증가
				}
			}
			while (true) {
				if (!valid(tx + dx[3], ty + dy[3])) { // 오하 방향으로 이동할 때
					tx = x; // 멈추기 전에 초기 좌표로 초기화
					ty = y;
					break;
				} else {
					tx = tx + dx[3]; // 계속 왼상 방향으로 좌표 이동시켜줌
					ty = ty + dy[3]; // 계속 왼상 방향으로 좌표 이동시켜줌
					cnt++; // 이동 칸 수 증가
				}
			}
			break;
		default:
			break;
		}

	}

	static boolean valid(int r, int c) { // 로봇 이동 가능 여부 확인
		if (r < 0 || r >= N || c < 0 || c >= N || map[r][c].equals("W") 
				|| map[r][c].equals("A") || map[r][c].equals("B") || map[r][c].equals("C")) { // 1. map 범위 벗어나거나 2. 벽인 경우
			return false;
		}
		return true;
	}

}
