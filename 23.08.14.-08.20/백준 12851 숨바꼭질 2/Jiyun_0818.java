/* 백준 12851 숨바꼭질 2 골드4
2023.08.18.
시도 1 : 큐에 int 배열로 route(depth) 함께 저장해서 진행 (depth는 1초에 이동한 것으로 시간을 대신하는 것으로 설정)
***** 찬혁쓰(aka. 코딩 거북이) 도움 받은 뒤
시도 2 : route 배열을 따로 만들어서 해당 위치를 거쳐갈 때의 시간(depth)을 저장, 
        경우의 수는 depth(시간)가 같은 경우에 해당 위치까지 가는 경우의 수를 고려하는 것이므로 그 전에 위치까지의 경우의 수 + 이동 위치의 경우의 수
        depth(시간)가 같다는 조건이 매우 중요!!! *****************************************************************************************************
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K; // 수빈이 위치, 동생 위치
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static int[] route = new int[100001]; // 경로 저장 배열
	static int[] caseCnt = new int[100001]; // 경우의 수 저장 배열
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N, 0);
	}

	static int[] dx = {-1, 1, 0};
	
	static void bfs(int x, int depth) {
		q.offer(x); // 현재위치, depth
		route[x] = depth;
		caseCnt[x] = 1; // 처음 시작하는 경우의 수 1
		while (!q.isEmpty()) {
			int loc = q.poll();
			if (loc == K) {
				System.out.println(route[loc]);
				System.out.println(caseCnt[loc]);
				break;
			}

			dx[2] = loc; // 이동 경우의 수 2*x는 dx[2]를 자기 자신으로 하고 자기 자신 + 자기 자신 을 하면 2배이므로.
			for(int d = 0; d < 3; d++) {
				int nloc = loc + dx[d];
				
				if (nloc >= 0 && nloc <= 100000) { // 이동 범위 유효할 경우에
					if (route[nloc] == 0) { // 아직 방문하지 않은 곳인 경우에
						q.offer(nloc); // 큐에 넣고
						route[nloc] = route[loc] + 1; // depth 추가
					} 
					if (route[nloc] == route[loc] + 1) { // depth가 같은 경우에 해당 위치까지의 경우의 수 합산***************************************
						caseCnt[nloc] += caseCnt[loc];
					}
				}
			}
		}

	}

}
