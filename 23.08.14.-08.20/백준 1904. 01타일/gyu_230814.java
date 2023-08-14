import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int[] dp = new int[n + 1];
		if (n > 0) {				// 입력 값에 따라 조건을 넣어줘야 오류 없이 돌아간다.
			dp[1] = 1;
			if(n > 1)
				dp[2] = 2;
		}	
		for(int i=3;i<=n;i++)			// 한번 직접 해보니 i-1, i-2를 더하면 i값이 나온다.
			dp[i] = (dp[i-2] + dp[i-1]) % 15746;
		bw.write(String.valueOf(dp[n]));
		bf.close();
		bw.flush();
		bw.close();
	}
}
