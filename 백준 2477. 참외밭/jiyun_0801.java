// ArrayIndexOutOfBounds 런타임 에러 -> 38,47 라인 수정 -> 시간초과

import java.util.Scanner;

public class BOJ_2477 {
	static int K;
	static int[] directions = new int[6]; 
	static int[] len = new int[6];
	static int[] four = new int[5]; // 동 1, 서 2, 남 3, 북 4
	static int width; // 큰 사각 가로
	static int widthS; // 작은 사각 세로
	static int heigth;
	static int heigthS;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		
		for (int i = 0; i < 6; i++) {
			directions[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 6; i++) { // four 배열에 방향 count
			four[directions[i]] += 1; // 카운트해서 1인 방향의 길이가 가장 긴 길이 -> 큰 사각형에서 작은 사각형 빼는 방식
		}
		
		System.out.println(Arrays.toString(directions));
		
		for (int i = 1; i < 5; i++) {
			if (four[i] == 1) { // 1이면 i가 direction의 요소
				for (int j = 0; j < 6; j++) {
					if (i == 3 || i ==4) {
						if (directions[j] == i) {
							width = len[j];
							if (j+2 >= 6) {
								j = j-4;
							}
							j = j +2;
							widthS = len[j];
						}
					}
					if (directions[j] == i) {
						heigth = len[j];
						if (j-2 < 0) {
							j = j+4;
						}
						j = j-2;
						heigthS = len[j];
					}
				}
			}
		}
		
		widthS = widthS * heigthS;
		width = (width * heigth) - widthS;
		System.out.println(width*7);
		sc.close();
	}

}
