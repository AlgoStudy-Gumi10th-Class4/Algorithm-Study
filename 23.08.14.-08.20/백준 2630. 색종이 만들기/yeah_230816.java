import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static int blue=0,white=0,N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		board=new int[N][N];
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		dfs(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	static void dfs(int y,int x,int size)
	{
		int state=board[y][x];
		boolean flag=true;
		outer:for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(board[y+i][x+j]!=state)
				{
					flag=false;
					break outer;
				}
			}
		}
		
		if(flag)//다 같은 색
		{
			//System.out.println(y+" "+x+" "+size);
			if(state==1)
			{
				blue++;
			}
			else
			{
				white++;
			}
		}
		else
		{
			dfs(y,x,size/2);
			dfs(y,x+size/2,size/2);
			dfs(y+size/2,x,size/2);
			dfs(y+size/2,x+size/2,size/2);
		}
	}
}

