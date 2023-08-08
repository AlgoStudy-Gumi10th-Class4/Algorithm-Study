/* 자바 기초 코드 연습용 문제 풀기
 * 
 * 2023.08.07.
 * BOJ_2752_Bronze4_세수정렬
 * */
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class BOJ_JavaBasic {
	
	static int[] A = new int[3];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i =0; i < 3; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		System.out.println(Arrays.toString(A).replace("[", "").replace("]", "").replace(",", ""));
		
		
	}

}
