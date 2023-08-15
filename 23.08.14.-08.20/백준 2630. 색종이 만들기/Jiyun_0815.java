package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class BOJ_2630_Silver2 {
	
	static int white = 0; // 하얀색 색종이의 개수
	static int blue = 0; // 파란색 색종이의 개수
	static int[][] map; // 주어지는 전체 종이 상태를 담을 배열
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이
		map = new int[N][N]; // 종이 상태 담을 배열을 한 변의 길이로 초기화
		
		for(int i=0; i<N; i++) { //배열 board에 색을 담는다. (하양 = 0, 파랑 = 1)
			st = new StringTokenizer(br.readLine());
			
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void divide(int r, int c, int size) {
		if(colorChk(r,c,size)) {
			if (map[r][c] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		} else { // 종이 색상 일치 X
			int newSize = size/2;
			divide(r,c,newSize); //2
			divide(r,c+newSize,newSize); //1
			divide(r+newSize,c,newSize); //3
			divide(r+newSize,c+newSize,newSize); //4 
		}
		
	}
	
	
	public static boolean colorChk(int r, int c, int size) {
		int color = map[r][c]; //일치하는지 확인할 색상
		for (int i=r; i < r+size; i++) {
			for (int j=c; j < c+size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
