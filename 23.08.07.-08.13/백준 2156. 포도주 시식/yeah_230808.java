//dp문제 엄청 어렵다 이해가 안감
//문제를 단순화하여 점화식을 생각해보는 연습이 필요
//https://www.acmicpc.net/status?user_id=k133117&problem_id=2156&from_mine=1
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		int[] dp=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
			if(i==0)
			{
				dp[i]=arr[i];
			}
			else if(i==1)
			{
				dp[i]=arr[0]+arr[1];
			}
			else if(i==2)
			{
				dp[i]=Math.max(dp[0]+arr[i], Math.max(dp[i-1],arr[1]+arr[2]));
			}
			else
			{
				dp[i]=Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]));
			}
		}
		System.out.println(dp[N-1]);
	}
}
