//시간복잡도가 좋은 편은 아니다.
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);

			int[] arr=new int[N];
			//pq 사용으로 자동 최대값 생성
			PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->(o2-o1));
			tmp = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(tmp[i]);
				pq.add(arr[i]);
			}
			int idx=0;
			int cnt=0;
			//현 상태에서 최대값을 찾을 때까지 배열을 반복해서 돌기
			while(!pq.isEmpty())
			{
				int max=pq.peek();
				if(arr[idx]==max)
				{
					arr[idx]=0;
					cnt++;
					pq.poll();
					if(idx==M)
					{
						break;
					}
				}
				idx++;
				if(idx==N)
				{
					idx=0;
				}
			}
			System.out.println(cnt);
		}
	}

}
