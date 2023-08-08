/* DFS 문제 풀어보기
* BFS 문제로 풀려고 했는데 재귀함수를 사용해서 DFS 문제가 되었다.
* 큐를 사용해서 나중에 다시 풀어보기! (다음주 쯤)
* 
* 재귀함수 종료 조건, 반환값에 대한 이해 향상 필요. ***
* 반복문에서 i와 j.. 제대로 쓰기
 * */
package algo_study.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926_Silver1 {

	static int n; //세로
	static int m; //가로
	static int[][] canvas; //도화지
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1}; //동서북남
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		canvas = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j =0; j < m; j++) {
				canvas[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int cnt = 0; // 그림의 개수
		int totalMax = 0;
		for (int i=0; i < n; i++) {
			for (int j =0; j < m; j++) {
				int size = search(i,j);
				if (size > 0) cnt++;
				totalMax = Math.max(totalMax, size);
				
			}
		}
		System.out.println(cnt);
		System.out.println(totalMax);
	}


	private static int search(int i, int j) {
		// 종료 조건
		// 맵을 벗어나면 종료
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return 0;
		}
		// 이미 방문한 곳이면 종료
		if (visited[i][j]) return 0;
		// 맵이 0이면 그림X 종료
		if (canvas[i][j] == 0) return 0;
		
		visited[i][j] = true;
		int res = 1;
		for (int a = 0; a < 4; a++) {
			res += search(i+dx[a], j+dy[a]);
		}
		
		return res;
	}


}
