// 설탕 배달 (실버4) https://noj.am/2839
// 현재 무게 w를 만들 수 이는 설탕 봉지 최소 개수는
// min(w-3 무게 봉지 수 + 1, w-5 봉지 수 + 1)

import java.util.Arrays;
import java.util.Scanner;

public class Nojam2839_230724 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		// 초기화
		int[] bags = new int[5001];
		Arrays.fill(bags, 9999);
		bags[3] = bags[5] = 1;
		
		for (int i = 6; i <= N; i++) {
			bags[i] = Math.min(bags[i-3] + 1, bags[i-5] + 1);
		}
		System.out.println(bags[N] >= 9999 ? -1 : bags[N]);
	}
}

