/* BOJ_2003_Silver4_수들의 합 2
시도 1 : 누적합 사용 -> 통과
*/
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 모법답안
import java.util.*;

public class SWEA_2992 {

	static int[] nums;
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i <N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0; // 수열의 합
		int cnt = 0; // M이 되는 경우
		
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = i; j < N; j++) { // 수열의 합 구하기
				sum += nums[j];
				if (sum >= M) { // M보다 크거나 커진 경우 멈춤
					if (sum == M) {
						cnt++;
					}
					sum = 0; // 다음으로 넘어가기 전 초기화
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
