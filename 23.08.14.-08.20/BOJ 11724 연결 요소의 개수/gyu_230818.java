import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int n;
	static int m;
	static int cnt = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i=0;i<=n;i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			sp = bf.readLine().split(" ");
			list[Integer.parseInt(sp[0])].add(Integer.parseInt(sp[1]));
			list[Integer.parseInt(sp[1])].add(Integer.parseInt(sp[0]));
		}
		for(int i=1;i<=n;i++) {
			if (!visit[i]) {
				cnt++;
				check(i);
			}
		}
		bw.write(String.valueOf(cnt));
		bf.close();
		bw.flush();
		bw.close();
	}
	static void check(int index) {
		visit[index] = true;
		for(int i=0;i<list[index].size();i++) {
			if (!visit[list[index].get(i)]) {
				check(list[index].get(i));
			}
		}
	}
}
