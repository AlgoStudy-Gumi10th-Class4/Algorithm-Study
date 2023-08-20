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
	static int n;
	static int m;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		bw.write(String.valueOf(bfs()) + "\n");
		bw.write(String.valueOf(cnt));
		bf.close();
		bw.flush();
		bw.close();
	}
	// queue를 사용하는 bfs...
	static int bfs() {
		int[] visit = new int[100001];
		Queue<Integer> q = new LinkedList<>();			// 숫자들을 저장할 queue
		q.add(n);										// 처음 n 값을 q에 넣어준다.
		int min=Integer.MAX_VALUE;
		int time = 0;
		while (!q.isEmpty()) {							// q가 비어있을때까지 반복한다.
			int qlen = q.size();
			int next;
			for(int i=0;i<qlen;i++) {					// 현재 시간에 가지고 있는 q크기만큼 반복한다.
				int temp = q.poll();
				if (temp == m) {						// 같다면 카운트해준다.
					cnt++;
					min = time;							// 최소 시간을 같이 넣어준다.
				}
				for(int j=0;j<3;j++) {					// 마찬가지로 곱하고 더하고 빼기가 3가지 이므로 3번 반복
					if (j==0)	next = temp * 2;
					else if (j==1)	next = temp + 1;
					else		next = temp - 1;
					// 범위안에 있으면서 만약 다음 숫자가 0이거나 현재 시간보다 작으면 q에 넣어준다. 
					// 다음 숫자를 방문한 적이 있는데 현재 시간보다 작다면 굳이 방문을 할 필요가 없기 때문인다.
					if(next >= 0 && next <= 100000 && (visit[next] == 0 || visit[next] >= time)) {
						q.add(next);
						visit[next] = time;
					}
				}
			}
			time++;
			if (min < time)
				break;
		}
		return min;
	}
}
