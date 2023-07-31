// 별 찍기 - 10 (골드5) https://noj.am/2447
//
// 접근 방법
// 3의 배수 정사각형 형태로 들어온다고 했으니
// 1 2 3
// 4 5 6
// 7 8 9 처럼 생각하고, 5는 빈칸으로 체크.
// 그리고 현재 N이 1보다 크다면 N/3으로 재귀, 1이면 빈칸 혹은 별 출력
//
// 결과: 50356KB / 456ms
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2447&from_mine=1

import java.util.Scanner;

public class Juyong_230731 {
	static char[][] board;

	static void print(int x, int y, int n, boolean isBlank) {
		if (n == 1) {
			board[x][y] = isBlank ? ' ' : '*';
			return;
		}

		int nn = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// 중간은 빈칸으로 만들고 나머지는 내 위에서 blank로 설정됐는지 확인
				boolean nextBlank = i == 1 && j == 1 ? true : isBlank;
				print(x + nn * i, y + nn * j, nn, nextBlank);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		board = new char[N][N];
		print(0, 0, N, false);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
