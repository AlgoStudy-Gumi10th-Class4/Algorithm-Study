import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[] visit;
	static int[][] gs;
	static int[] current = new int[2];
	static int[] rock = new int[2];
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		while(t-- > 0) {
			m = Integer.parseInt(bf.readLine());
			gs = new int[m][2];
			visit = new boolean[m];
			String[] sp = bf.readLine().split(" ");
			current[0] = Integer.parseInt(sp[0]);
			current[1] = Integer.parseInt(sp[1]);
			for(int i=0;i<m;i++) {
				sp = bf.readLine().split(" ");
				gs[i][0] = Integer.parseInt(sp[0]);
				gs[i][1] = Integer.parseInt(sp[1]);
			}
			sp = bf.readLine().split(" ");
			rock[0] = Integer.parseInt(sp[0]);
			rock[1] = Integer.parseInt(sp[1]);
			if (go())
				bw.write("happy\n");
			else
				bw.write("sad\n");
		}
		bf.close();
		bw.flush();
		bw.close();
	}
	static boolean go() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(current);
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			current[0] = temp[0];
			current[1] = temp[1];
			int d = Math.abs(current[0] - rock[0]) + Math.abs(current[1] - rock[1]);
			if (d <= 1000)
				return true;
			for(int i=0;i<m;i++) {
				if (!visit[i]) {
					int g = Math.abs(current[0] - gs[i][0]) + Math.abs(current[1] - gs[i][1]);
					if (g <= 1000) {
						q.add(gs[i]);
						visit[i] = true;
					}
				}
			}
		}
		return false;
	}
}
