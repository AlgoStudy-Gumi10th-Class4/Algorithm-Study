// 블로그 참조 -> 이분탐색, 코드 참조
// 나중에 다시 풀어보기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] lessonList;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessonList = new int[N];
        
        int left = 0;
        int right = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	lessonList[i] = Integer.parseInt(st.nextToken());
            right += lessonList[i];
            left = Math.max(left, lessonList[i]);
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = getCount(N, lessonList, mid);

            if(count > M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);
        
	}
	private static int getCount(int n, int[] lessonList, int mid) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + lessonList[i] > mid) {
                sum = 0;
                count++;
            }
            sum += lessonList[i];
        }

        if(sum != 0) count++;
        return count;
    }
}
