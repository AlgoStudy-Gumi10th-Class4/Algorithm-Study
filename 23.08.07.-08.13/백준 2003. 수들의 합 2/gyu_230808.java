import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = bf.readLine();
		String[] sp = s.split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		arr = new int[n];
		cnt = 0;
		s = bf.readLine();
		sp = s.split(" ");
		for(int j=0;j<sp.length;j++)
			arr[j] = Integer.parseInt(sp[j]);
		for(int i=0;i<n;i++)
			check(i,0);
		bw.write(String.valueOf(cnt));
		bf.close();
		bw.flush();
		bw.close();
	}
	
	static void check(int index, int sum) {
		if (sum == m) {
			cnt++;
			return ;
		}
		if (index == n)	return;
		check(index + 1, sum + arr[index]);
	}
}