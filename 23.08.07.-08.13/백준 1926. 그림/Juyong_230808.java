import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그림 (실버1)
 * 
 * <p>
 * 시도 1 단순 구현
 * </p>
 * 
 * 결과: 57668KB / 584ms
 * 
 * @author cheesecat47@gmail.com
 * @see https://noj.am/1926
 */
public class Juyong_230808 {
	static int n, m;
	static int[][] arr, visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int move(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return 0;
		if (arr[x][y] == 0)
			return 0;
		if (visited[x][y] > 0)
			return 0;

		visited[x][y] = 1;

		int size = arr[x][y];
		for (int i = 0; i < 4; i++) {
			size += move(x + dx[i], y + dy[i]);
		}

		return size;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 문제 입력
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		arr = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new int[m];
			visited[i] = new int[m];
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 탐색
		int count = 0;
		int maxSize = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int t = move(i, j);
				count += t > 0 ? 1 : 0;
				maxSize = maxSize < t ? t : maxSize;
			}
		}

		System.out.println(count);
		System.out.println(maxSize);
	}
}
