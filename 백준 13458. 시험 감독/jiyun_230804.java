// 230804 BOJ_13458_Bronze5_시험감독
//
// 시도1 : 입력이 1일 때를 고려하지 않음
// 시도2 : long으로 사용해야함을 몰랐음
// 시도3 : 변수명 헷갈려서 조건 잘못줌.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BOJ_13458_Bronze2 {
	
	static int N; // 시험장 개수
	static long[] students;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		students = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long B = Long.parseLong(st.nextToken()); // 총감독관의 감시 가능 응시자 수 *** 총감독은 오직 한 명
		long C = Long.parseLong(st.nextToken()); // 부감독관의 감시 가능 응시자 수
		
		long need = N;
		for (long s : students) {
			s = s - B; 
			if (s <= 0) continue;
			need += s / C;
			if (s % C != 0) need++;
		}
		
		System.out.println(need);
		
	}
	
}
