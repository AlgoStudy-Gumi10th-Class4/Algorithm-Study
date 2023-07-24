import java.io.*;
import java.util.*;
class Main {
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int[] arr;
	static int[] op;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		String[] tmp=br.readLine().split(" ");
		
		arr=new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		
		tmp=br.readLine().split(" ");
		op=new int[4];
		for(int i=0;i<4;i++)
		{
			op[i]=Integer.parseInt(tmp[i]);
		}
		
		dfs(0,N,arr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	static void dfs(int crt,int N,int sum)
	{
		if(crt==N-1)
		{
			
			if(max<sum)
			{
				max=sum;
			}
			if(min>sum)
			{
				min=sum;
			}
			return;
		}
		if(op[0]>0)
		{
			op[0]--;
			dfs(crt+1,N,sum+arr[crt+1]);
			op[0]++;
		}
		if(op[1]>0)
		{
			op[1]--;
			dfs(crt+1,N,sum-arr[crt+1]);
			op[1]++;
		}
		if(op[2]>0)
		{
			op[2]--;
			dfs(crt+1,N,sum*arr[crt+1]);
			op[2]++;
		}
		if(op[3]>0)
		{
			op[3]--;
			dfs(crt+1,N,sum/arr[crt+1]);
			op[3]++;
		}
	}
}
