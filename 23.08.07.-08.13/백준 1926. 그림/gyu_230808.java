import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int count = 0;
	static int area = 0;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			sp = bf.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(sp[j]);
			}
		}
				
		find();
		bw.write(String.valueOf(count) + "\n" + String.valueOf(area));
		bf.close();
		bw.flush();
		bw.close();
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void find() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if (map[i][j] == 1 && visit[i][j] == false)
				{
					count++;
					visit[i][j] = true;
					int size = check(i,j);
					area = Math.max(area, size);
				}
			}
		}
	}
	static int check(int i,int j) {
		int size = 1;
		for(int x=0;x<4;x++) {
			int ti = i + dx[x];
			int tj = j + dy[x];
			if (ti >= 0 && ti < n && tj >= 0 && tj < m && map[ti][tj] == 1 && visit[ti][tj] == false)
			{
				
				visit[ti][tj] = true;
				size += check(ti,tj);
			}
		}
		return size;
	}
	
}
