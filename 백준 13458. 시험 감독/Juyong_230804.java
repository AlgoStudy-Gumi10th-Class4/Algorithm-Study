import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 시험 감독 (브론즈2)
 * 
 * 결과: 110732KB / 504ms
 * 
 * @author cheesecat47@gmail.com
 * @see https://noj.am/13458
 */
public class Juyong_230804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		String[] BC = br.readLine().split(" ");
		int B = Integer.parseInt(BC[0]);
		int C = Integer.parseInt(BC[1]);

		long count = 0;
		for (int a : A) {
			count += 1;
			if (a > B) {
				a -= B;
				count += a / C;
				count += a % C > 0 ? 1 : 0;
			}
		}

		System.out.println(count);
	}
}
