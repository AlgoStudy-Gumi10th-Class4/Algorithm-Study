// 출력이 많으므로 bw 사용하지 않으면 시간초과
// - 시간복잡도 분석
// f(n) = f(n-1)+1+f(n-1) = 2f(n-1)+1
// f(n) = 2(2f(n-2)+1)+1 = 4*f(n-2)+2+1
// f(n) = (2^n-1)*f(1)+...+2+1 => 2씩 곱해지는 등비수열
// f(n)= 1(초항)*(2^n-1)/(2-1)
// i.e. O(2^n)
import java.util.*;
import java.io.*;
public class Main {
	
	static ArrayList<int[]> list=new ArrayList();
	static Stack<Integer>[] st=new Stack[3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<3;i++)
		{
			st[i]=new Stack();
		}
		for(int i=N;i>0;i--)
		{
			st[0].add(i);
		}
		func(N,0,2,1);
		
		bw.write(list.size()+"\n");
		for(int[] arr:list)
		{
			bw.write((arr[0]+1)+" "+(arr[1]+1)+"\n");
		}
		bw.flush();
		bw.close();
	}
	static void func(int n,int from,int to,int temp)
	{
		if(n==1)
		{
			st[to].add(st[from].pop());
			list.add(new int[] {from,to});
			//stPrint();
			return;
		}

		func(n-1,from,temp,to);
//		System.out.println("1 : "+from+" "+temp);
//		stPrint();
		func(1,from,to,temp);
//		System.out.print("2 : "+from+" "+to);
//		stPrint();		
		func(n-1,temp,to,from);
//		System.out.print("3 : "+temp+" "+to);
//		stPrint();
	}
	static void stPrint()
	{
		System.out.print(st[0].toString()+" ");
		System.out.print(st[1].toString()+" ");
		System.out.print(st[2].toString()+" ");
		System.out.println();
	}
}
