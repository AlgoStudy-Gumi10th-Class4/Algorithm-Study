package algorithm;

import java.io.*;
import java.util.*;

public class DFSBFS {
    static int[] arr, operators;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
        N = Integer.parseInt(br.readLine()); // 수 N 개
        arr = new int[N]; //수열
        operators = new int[4]; // 연산자 N-1
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 수열
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {// 연산자
        	operators[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
 
    static void dfs(int d, int value) { // d: depth
    	if (d == N) { //depth가 N이 되면 최대값 판별 후 return
    		max = Math.max(max, value);
    		min = Math.min(min, value);
    		return;
    	}
    	for (int i = 0; i < 4; i++) { // operator 배열 탐색
    		if (operators[i] > 0) { // +,-,*,/ 중 하나 -> 해당 연산자가 1개 이상 있는 경우에
    			operators[i]--; // 연산자 사용 -> 개수차감
    			
    			switch (i) {
    			case 0: // 연산자 +
    				dfs(d+1, value + arr[d]); // depth 증가, value 값 덧셈
    				break;
    			case 1: // 연산자 -
    				dfs(d+1, value - arr[d]); // depth 증가, value 값 뺄셈
    				break;
    			case 2: // 연산자 *
    				dfs(d+1, value * arr[d]); // depth 증가, value 값 곱셈
    				break;
    			case 3: // 연산자 /
    				dfs(d+1, value / arr[d]); // depth 증가, value 값 나눗셈
    				break;
    			}
    			operators[i]++; // 다음 dfs 에서 연산자를 사용할 수 있도록 원상복구
    		}
    	}
    	
    }

}
