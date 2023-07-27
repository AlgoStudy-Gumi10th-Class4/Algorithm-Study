package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


/* N*M 크기 
 * 이동 가능 방향 동,서,남,북 / 현재 바라보고 있는 방향 d
 * dx = [1,-1,0,0]
 * dy = [0,0,-1,1]
 * 1. 현재 칸 청소 X -> 칸 청소 
 * 2. 청소되지 않은 빈 칸이 없다 = 모두 청소 완 => 후진 가능 -> 후진 -> 1번 / 후진 불가 -> 종료
 * 3. 현재 칸의 동서남북 칸 청소 X => 동1 -> 북0 / 북0 -> 서3 / 서3 -> 남2 / 남2 -> 동1
 * 		회전 후 앞쪽 칸이 청소 x -> 한 칸 전진
 * */
public class Main {
	static int[][] room; // 방의 크기
	static int d; // 청소기가 바라보는 방향 ( 0-북,1-동,2-남,3-서)
	static int r,c; // 청소기 좌표(r,c)
	static int N, M;
	static int res; // 청소한 칸
	//동1 -> 북0 / 북0 -> 서3 / 서3 -> 남2 / 남2 -> 동1
	static int [] dx = {0,-1,0,1};// 북 서 남 동
	static int [] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 방의 크기 N*M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		// 처음 시작 좌표 (r,c) 방향 d
		r = Integer.parseInt(st.nextToken()); //i
		c = Integer.parseInt(st.nextToken()); //j
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; i < M; j++) {
				st = new StringTokenizer(br.readLine());
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		room[r][c] = 2;
		res+=1;
		find(r, c);
//		clean(r,c);	???
		System.out.println(res);
	}
	public static void clean(int r, int c) {
		// 1 : 벽  0: 더러움
		if(r >= 0 && r <= N-1 && c >= 0 && c <= M-1) {
			if(room[r][c] != 1){ // 벽 X
				if (find(r,c) == 0) { //청소 X 칸 있음
					d -= 1;//회전
					if(d == -1) d = 3;
					
					//빈칸? 전진
					if (room[r][c] == 0) {
						room[r][c] = 2;
						res += 1;
						find(r, c);
					}
				}else { // 청소 X 칸 없음
					if(backable(d)==true){ // 후진가능
						clean(r,c);
					}else {
						System.out.println(res);
					}
				}
			}
		}
		System.out.println(res);
	}
	public static int find(int r, int c) { // 주변 칸 청소 X 칸 유무 찾기
		int dirty = -1; // -1 없음 0 있음
		for (int x : dx) {
			for (int y: dy) {
				if (room[r+x][c+y] == 0) { //청소 X 칸 있음
					dirty = 0;
					r = r+x;
					y = c+y;
					break;
				}
			}
		}
		return dirty;
	}
	public static boolean backable(int d) { // 후진 가능 여부
		//방향 =	( 0-북,1-동,2-남,3-서)
		//후진 =  (0,-1)(-1,0)(0,1)(1,0)
		switch (d) {
		case 0: // 바라보는 방향: 북
			if (room[r][c-1] != 1) {
				c -= 1;
				return true;
			}
		case 1: // 바라보는 방향: 동
			if (room[r-1][c] != 1) {
				r -= 1;
				return true;
			}
		case 2: // 바라보는 방향: 남
			if (room[r][c+1] != 1) {
				c += 1;
				return true;
			}
		case 3: // 바라보는 방향: 서
			if (room[r+1][c] != 1) {
				r += 1;
				return true;
			}
		default:
			break;
		}
		return false;
	}
}
