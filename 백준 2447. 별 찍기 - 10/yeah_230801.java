// 옛날에 풀었는데 다시 품
// 한번에 풀긴했는데 전에 푼걸 다시보니 전에 푼게 더 잘품
// 현재 코드 315204kb	1716ms
/*
//옛날코드
//20472kb	408ms
import java.io.*;
import java.util.*;

class Main {
	static boolean[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr=new boolean[N][N];
		
		func(0,0,N);
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j])
				{
					bw.write(" ");
				}
				else
				{
					bw.write("*");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int x,int y,int n)
	{
		if(n==3)
		{
			arr[x+1][y+1]=true;
		}
		else
		{
			int part=n/3;
			for(int a=0;a<3;a++)
			{
				for(int b=0;b<3;b++)
				{
					if(a!=1||b!=1)
					{
						func(x+a*part,y+b*part,part);
					}
					else
					{
						for(int i=0;i<part;i++)
						{
							for(int j=0;j<part;j++)
							{
								arr[x+part+i][y+part+j]=true;
							}
						}
					}
				}
			}
		}
		
	}
}
*/
import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		String[] arr=new String[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=new String();
		}
		star(N,arr,0);
		for(String ar:arr)
			System.out.println(ar);
	}
	static void star(int n,String[] arr,int y)
	{
		if(n==1)
		{
			arr[y]+="*";
			return;
		}
		for(int i=0;i<3;i++)
		{
			star(n/3,arr,y);
		}
		
		star(n/3,arr,y+n/3);
		for(int i=0;i<n/3;i++)
		{
			for(int j=0;j<n/3;j++)
			{
				arr[y+n/3+i]+=" ";
			}
		}
		star(n/3,arr,y+n/3);
		
		for(int i=0;i<3;i++)
		{
			star(n/3,arr,y+n*2/3);
		}
		
	}
	
	
	
}
