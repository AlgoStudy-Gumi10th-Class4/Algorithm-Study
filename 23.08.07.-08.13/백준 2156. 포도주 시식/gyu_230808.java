import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int n;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = bf.readLine();
		n = Integer.parseInt(s);
		arr = new int[n+1];
		int[] dp = new int[n + 1];
		for(int j=1;j<=n;j++)
			arr[j] = Integer.parseInt(bf.readLine());
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(n != 1)
			dp[2] = dp[1] + arr[2];
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], Math.max(dp[i-1], dp[i-3] + arr[i-1] + arr[i]));
		}
		
		
		bw.write(String.valueOf(dp[n]));
		bf.close();
		bw.flush();
		bw.close();
	}
}
