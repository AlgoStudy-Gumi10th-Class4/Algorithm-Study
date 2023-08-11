/* BOJ_1966_Silver3_프린터 큐
 * 시도 1 : M번째 프린터를 찾기 위해 큐에 배열로 0,1로 구분하여 저장 시도 -> 실패
 * 시도 2 : 성규 코드 참고 -> 배열에 0,1로 구분하지 않고 idx 자체를 저장, 우선순위 체크 배열 추가 -> 통과
 * */
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1966_Silver3 {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 인쇄 순서 궁금한 문서의 큐에서의 위치
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			int[] pchk = new int[10]; //우선순위 체크 배열
			st = new StringTokenizer(br.readLine());
			for (int i=0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				q.offer(new int[] {tmp,i});
				pchk[tmp]++;
			}
			
			
			int cnt = 0;
			L: while (!q.isEmpty()) {
				int[] pp = q.poll();
				for (int i= pp[0]+1; i < 10; i++) { // ***숫자 클수록 우선순위 높음
					if (pchk[i] > 0) {
						q.offer(pp);
						continue L;
					}
				}
				if (pp[1] == M) {
					cnt++;
					sb.append(cnt).append("\n");
					break;
				}
				pchk[pp[0]]--;
				cnt++;
			}
			
		}
		System.out.println(sb);
	}

}
