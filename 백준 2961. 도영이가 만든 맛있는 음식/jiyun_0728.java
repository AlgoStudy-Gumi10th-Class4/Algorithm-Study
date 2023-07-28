package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {
	static int s[]; // 신맛
	static int b[]; // 쓴맛
	static int N; 
	static int min = 10000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		b = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		find(0, 1, 0);
		System.out.println(min);
	
	}
	public static void find (int cnt, int sumS, int sumB) {
		int middle = (sumS > sumB) ? sumS-sumB : sumB - sumS;
		
		if (sumS!=1 && min > middle) min = middle; // sumS != 1 : 재료 최소 1개 이상
		
		if (cnt == N) return;
		find(cnt+1, sumS*s[cnt], sumB+b[cnt]);
		find(cnt+1, sumS, sumB);
		
	}
}
