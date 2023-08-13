/* 블로그 참고
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static int[] wines; //포두주 잔의 양
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수
		wines = new int[n];
		
		for (int i = 0; i < n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		// 규칙2. 연속으로 놓여 있는 3잔 x -> 3씩 나눠서 생각
		int[] dp = new int[n];
		dp[0] = wines[0];
		
		for (int i = 1; i < n; i++) {
			if (i==1) {
				dp[1] = wines[0] + wines[1];
				continue;
			}
			if (i==2) {
				dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1]+wines[2]));
				continue;
			}
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i-1]+wines[i]));
		}
		System.out.println(dp[n-1]);
	}

}
