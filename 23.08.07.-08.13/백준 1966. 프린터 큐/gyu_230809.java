import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		for(int tc=0;tc<t;tc++) {
			String[] st = bf.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int m = Integer.parseInt(st[1]);
			Queue<int []> queue = new LinkedList<int []>();
			int[] check = new int[10];
			st = bf.readLine().split(" ");
			for(int i=0;i<n;i++) {
				int temp = Integer.parseInt(st[i]);
				queue.add(new int[] {temp,i});
				check[temp]++;
			}
			
			int cnt = 1;
			wh:while(!queue.isEmpty()) {
				int[] info = queue.poll();
				for(int i=info[0] + 1;i<=9;i++) {
					if (check[i] > 0) {
						queue.add(info);
						continue wh;
					}
				}
				
				if (info[1] == m) {
					bw.write(String.valueOf(cnt) + "\n");
					break;
				}
				check[info[0]]--;
				cnt++;
			}
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
}
