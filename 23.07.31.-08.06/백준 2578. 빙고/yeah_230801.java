// 생각보다 어려움
// 더 효율적으로 짜려고 열심히 생각해봤으나 전체적인 소스코드가 깔끔하지 못해 개선 필요
// 근데 N이 5로 정해져있어서 크게 신경쓰지 않아도 되긴함
// 14120kb 124ms
import java.util.*;
import java.io.*;
public class Main {
	static int[][] board=new int[5][5];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++)
		{
			String[] tmp=br.readLine().split(" ");
			for(int j=0;j<5;j++)
			{
				board[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		boolean[] diag=new boolean[2];
		int res=0;
		for(int i=0;i<5;i++)
		{
			String[] tmp=br.readLine().split(" ");
			for(int j=0;j<5;j++)
			{
				int n=Integer.parseInt(tmp[j]);
				res+=check(n,true);
				if(res>=3) {
					System.out.println(i*5+j+1);
					return;
				}
			}
		}
		
	}
	static int check(int n,boolean line)
	{
		int res=0;
		int i=0,j=0;
		recur:for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				if(board[i][j]==n)
				{
					board[i][j]=-1;
					break recur;
				}
			}
		}
		if(line)
		{
			boolean flagY=true;
			boolean flagX=true;
			for(int k=0;k<5;k++)
			{
				if(flagY&&board[i][k]!=-1)
				{
					flagY=false;
				}
				if(flagX&&board[k][j]!=-1)
				{
					flagX=false;
				}
			}
			if(flagX)
				res++;
			if(flagY)
				res++;
			if(i==j)
			{
				int k;
				for(k=0;k<5;k++)
				{
					if(board[k][k]!=-1)
					{
						break;
					}
				}
				if(k==5)
				{
					res++;
				}
			}
			if(i==4-j)
			{
				int k;
				for(k=0;k<5;k++)
				{
					if(board[k][4-k]!=-1)
					{
						break;
					}
				}
				if(k==5)
				{
					res++;
				}
			}
		}
		return res;
	}
	
	
}
