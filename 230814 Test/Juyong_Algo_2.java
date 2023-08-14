import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juyong_Algo_2 {

	public static void main(String[] args) throws IOException {
		// 입력을 받기 위한 BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 위한 StringBuilder 선언
		StringBuilder sb = new StringBuilder();

		// 게임 테스트 횟수 입력
		int T = Integer.parseInt(br.readLine());
		// T번 반복
		for (int t = 1; t <= T; t++) {
			// 공간 크기의 한 변 입력
			int N = Integer.parseInt(br.readLine());
			// 공간 선언
			String[][] board = new String[N][N];
			// 공백으로 구분된 N*N 공간의 값 입력
			for (int i = 0; i < N; i++) {
				// S, W, A, B, C 문자열로 이루어져 있으므로 공백으로 나누어 바로 사용
				board[i] = br.readLine().split(" ");
			}

			// 총 이동 칸 수를 셀 변수.
			int count = 0;
			// 공간의 행 탐색
			for (int i = 0; i < N; i++) {
				// 공간의 열 탐색
				for (int j = 0; j < N; j++) {
					// 이번 칸이 벽이나 빈칸이면 넘어가고
					if (board[i][j].equals("W") || board[i][j].equals("S"))
						continue;
					// 로봇일 때만 칸 세면 됨
					// 방문 체크 할 배열
					boolean[][] visited = new boolean[N][N];
					// 현재 칸은 방문 수에서 제외
					visited[i][j] = true;

					// 로봇의 x축 진행 방향
					int[] dxl = null;
					// 로봇의 y축 진행 방향
					int[] dyl = null;
					// 로봇의 진행 방향은 로봇마다 다름
					switch (board[i][j]) {
					case "A":
						// A 로봇은 오른쪽으로만 갈 수 있음
						dxl = new int[] { 0 };
						dyl = new int[] { 1 };
						break;
					case "B":
						// B 로봇은 상하로만 갈 수 있음
						dxl = new int[] { 1, -1 };
						dyl = new int[] { 0, 0 };
						break;
					case "C":
						// C 로봇은 대각으로만 갈 수 있음
						// 좌상(-1, -1), 우상(-1, 1), 좌하(1, -1), 우하(1, 1)
						dxl = new int[] { -1, -1, 1, 1 };
						dyl = new int[] { -1, 1, -1, 1 };
						break;
					}

					// 진행 가능한 방향 수만큼 반복
					for (int d = 0; d < dxl.length; d++) {
						// 공간 한 변 크기, 공간 배열, 방문 체크 배열, 현재 로봇, 현재 x좌표, 현재 y좌표, x진행 방향, y진행 방향
						// 다음 x좌표
						int nx = i + dxl[d];
						// 다음 y좌표
						int ny = j + dyl[d];
						count += move(N, board, visited, board[i][j], nx, ny, dxl[d], dyl[d]);
					}
				}
			}

			// 이번 게임 테스트 결과 출력 스트링 sb에 추가
			sb.append(String.format("#%d %d\n", t, count));
		}
		// 전체 결과 출력
		System.out.println(sb);
	}

	static int move(int N, String[][] board, boolean[][] visited, String thisRobot, int x, int y, int dx, int dy) {
		// 현재 방문한 칸이 맵 밖이면 반환
		if (x < 0 || x >= N || y < 0 || y >= N)
			return 0;
		// 벽이면 반환
		if (board[x][y].equals("W"))
			return 0;
		// 이미 방문한 칸이면 반환
		if (visited[x][y])
			return 0;
		// 다른 로봇의 초기 위치면 반환
		switch (thisRobot) {
		case "A":
			// 이번 로봇이 A면 현재 방문 칸이 B나 C인지 체크
			if ("BC".contains(board[x][y]))
				return 0;
		case "B":
			// 이번 로봇이 B면 현재 방문 칸이 A나 C인지 체크
			if ("BC".contains(board[x][y]))
				return 0;
		case "C":
			// 이번 로봇이 C면 현재 방문 칸이 A나 B인지 체크
			if ("AC".contains(board[x][y]))
				return 0;
		}

		// 방문 체크
		visited[x][y] = true;

		// 현재 로봇의 방문 칸수 카운트
		int count = 1;

		// 다음 x 좌표
		int nx = x + dx;
		// 다음 y 좌표
		int ny = y + dy;
		// 재귀적으로 갈 수 있을 때까지 반복하고, 카운트에 더하기
		count += move(N, board, visited, thisRobot, nx, ny, dx, dy);

		// 현재 칸에서 진행 방향으로 갈 수 있는 칸 수
		return count;
	}

}
