import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] input; // 숫자 배열
	static int[] nums; // 저장 배열
	static int n;
	static int m;
	
	public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		nums = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combi(0,0);
		System.out.println(sb);
		
	}
	
	public static void combi(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(nums[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for (int j=start; j<n; j++) {
			nums[cnt] = input[j];
			combi(cnt+1, j);
		}
	}
}
