//upper bound 문제
//long 타입으로 선언하는 게 포인트
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		
		int[] arr=new int[N];
		tmp=br.readLine().split(" ");
		int max=0;
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
			if(max<arr[i])
				max=arr[i];
		}
		
		int l=1;
		int r=max+1;
		
		while(l<r)
		{
			int m=l+(r-l)/2;
			long sum=0;
			for(int i=0;i<N;i++)
			{
				if(arr[i]>m)
					sum+=arr[i]-m;
			}
			//System.out.println(sum+" "+l+" "+r+" "+m);
			if(sum>=M)
			{
				l=m+1;
			}else
			{
				r=m;
			}
		}
		System.out.println(l-1);
	}
}
