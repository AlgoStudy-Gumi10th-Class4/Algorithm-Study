package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sugar {
	static int res; // 설탕 봉지
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // kg
			
		while (N >= 3) {
			if (N % 5 == 0) {
				res += N / 5;
				N = 0;
				break;
			}else {
				N -= 3;
				res += 1;
			}
		}
		
		if (N > 0) {
			res = -1;
		}
		
		System.out.println(res);
	}
}
