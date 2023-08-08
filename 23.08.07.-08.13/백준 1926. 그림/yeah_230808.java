import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[][] paper;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		paper=new int[N][M];
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			
			for(int j=0;j<M;j++)
			{
				paper[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		int max=0;
		int cnt=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(paper[i][j]==1)
				{
					int res=draw(i,j);
					//System.out.println(i+" "+j);
					cnt++;
					if(max<res)
					{
						max=res;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	static int draw(int y,int x)
	{
		int[] dy= {-1,0,1,0};
		int[] dx= {0,-1,0,1};
		Queue<int[]> q=new LinkedList<int[]>();
		paper[y][x]=0;
		q.add(new int[] {y,x});
		int size=0;
		while(!q.isEmpty())
		{
			int[] cur=q.poll();
			size++;
			
			for(int i=0;i<4;i++)
			{
				int ty=cur[0]+dy[i];
				int tx=cur[1]+dx[i];
				
				if(ty>=0&&ty<N&&tx>=0&&tx<M&&paper[ty][tx]==1)
				{
					paper[ty][tx]=0;
					q.add(new int[] {ty,tx});
				}
			}
		}
		return size;
	}
}
