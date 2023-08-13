/* 조합 배우고 스타트와 링크 풀기 -> 통과
* 시도 1 : 팀 N/2로 조합 구하고 팀 표시 배열 구하는 방식 생각했으나 코드 구현 실패
* 시도 2 : 정현님한테 visited로 0과 1로 팀 구분하는 아이디어 획득 -> score 함수 구현 -> 성공
* 
* 주의할 점
* - visited 초기화 부분 제대로 알고 확인하기
* - 재귀 코드 아직 미숙
*/
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_Silver2 {
	
	static int N; //사람 수
	static int[][] map;
	static int[] team; // 팀 조합
	static int[] visited; 
	static int smin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		team = new int[N/2];
		visited = new int[N];
		
		for (int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0);
		System.out.println(smin);
		
	}
	
	static void find(int cnt, int start) { // 팀 조합 구하기
		if (cnt == N/2) {
			score();
			return;
		}
		for (int i=start; i<N; i++) {
			team[cnt] = i+1;
			visited[i] = 1;
			find(cnt+1, i+1);
			visited[i] = 0;
		}
	}
	
	static void score() { // 점수 구하기
		int start = 0;
		int link = 0;
		for (int i=0; i<N; i++) {
			for (int j = i; j < N; j++) {
				if (visited[i] + visited[j] > 1) {
					start += map[i][j];
					start += map[j][i];
				} else if(visited[i] + visited[j] == 0){
					link += map[i][j];
					link += map[j][i];
				}
			}
		}
		int a = Math.abs(start-link); 
		smin = Math.min(smin, a);
		return;
	}


}
