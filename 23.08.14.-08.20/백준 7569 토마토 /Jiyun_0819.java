/* 토마토 7576번과 동일한 로직 2차원에서 3차원으로의 변경
 * 6방 탐색에 대한 경험
 * */

package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_7569_Gold5 {
	
	static int N, M, H;
	static int[][][] box; // 토마토 상자
	static int[][][] depth; // 하루 익은 일수
	static int[] dx = {1,-1,0,0,0,0}; //행 상하좌우 위아래
	static int[] dy = {0,0,-1,1,0,0}; //열
	static int[] dz = {0,0,0,0,1,-1}; 
	static int ans;
	
	public static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로칸 = 열
		N = Integer.parseInt(st.nextToken()); // 세로칸 = 행
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];
		depth = new int[N][M][H];
		
		for(int k = 0; k < H; k++) { //H번 반복
			for (int i =0; i<N; i++) { // 토마토 정보 1 - 익음 0 - 안익음 -1 - 없음
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) { //익은 토마토가 있는 경우 큐에 넣기
						q.offer(new int[] {i,j,k});
					}
				}
			}
		}
// 입력 끝 ----------------------------------------------------------------

		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int z = current[2];
			
			for (int d=0; d<6; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];
				
				if (!isValid(nx,ny,nz) || box[nx][ny][nz] != 0) { // 가려는 곳이 박스 범위 밖이거나 0이 아니면
					continue; // 다음 탐색으로 넘어가기
				} 
				q.offer(new int[] {nx,ny,nz}); // 유효한 범위라면 큐에 추가
				box[nx][ny][nz] = 1; // 토마토 익히기
				depth[nx][ny][nz] = depth[x][y][z] +1; //익은 날짜 체크
				ans = depth[nx][ny][nz];
			}
		}
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i< N; i++) {
				for (int j=0; j<M; j++) {
					if (box[i][j][k] == 0) ans = -1;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static boolean isValid(int x, int y, int z) {
		// 박스 범위 밖일 때
		if (x < 0 || x >= N || y < 0 || y >= M || z < 0 || z >= H) {
			return false;
		}
		return true;
	}

}
