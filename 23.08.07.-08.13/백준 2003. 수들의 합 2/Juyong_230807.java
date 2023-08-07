import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수들의 합 2 (실버4)
 * 
 * <p>
 * 시도 1
 * 투포인터 누적합
 * </p>
 * 
 * 결과: 15392KB / 164ms
 * 
 * @author cheesecat47@gmail.com
 * @see https://noj.am/2003
 */
public class Juyong_230807 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		long s = 0;
		int answer = 0;

		int left = 0;
		int right = 0;
		while (left < N && right < N) {
			if (s < M && right < N) {
				s += A[right];
				right += 1;
			}
			if (s == M) {
				answer += 1;
			}
			while (s >= M) {					
				s -= A[left];
				left += 1;
				if (s == M) {
					answer += 1;
				}
			}
		}

		System.out.println(answer);
	}
}
