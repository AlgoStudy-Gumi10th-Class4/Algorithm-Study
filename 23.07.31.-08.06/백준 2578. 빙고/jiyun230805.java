/* BOJ_2578_Silver4_빙고
* 어디서부터 잘못되었는가.. 
* 1. 우선 visited에서 방향을 튼 것 - visited가 더 복잡할 것이라 생각함.
* 2. 사회자 숫자 1차원 배열로 받은 것 - 2차원 배열로 받을 필요가 없으니 1차원 배열로 받겠다고 대충 생각함.
* 
* 도움 : 코딩거북이
* - search() 함수에서 빙고 갯수 잘못 카운트 되는 것
* - for문에 이름 붙여서 continue 하는 것
* 
*/
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2578_Silver4 {

	static int[][] input = new int[5][5]; // 철수의 빙고판
	static int[] nums = new int[25]; // 사회자의 숫자

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 철수의 빙고판 입력받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자 숫자 입력받기
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				nums[idx++] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(nums));

		// 숫자 -> 빙고판 행과 열 반복문
		idx = 0;
		int bcnt = 0;
		while (true) {
			L: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (input[i][j] == nums[idx]) {
						idx++;
						input[i][j] = 0; // 숫자 찾으면 -> 0으로 변경
						bcnt = search();
						if (bcnt >= 3) {
							System.out.println(idx);
							return;
						}
						continue;
					}
				}
			}
		}
	}

	static int search() {
		int b = 0;
		

		
		// 행 탐색 i 증가하면서
		R: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (input[i][j] != 0) {
					continue R;
				}

			}
			b += 1;
		}
		// 열 탐색 j 증가하면서
		C: for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				if (input[i][j] != 0) {
					continue C;
				}
			}
			b += 1;
		}
		// 대각선 탐색 1) i == j 2) i == 0 , j == 4 -> i+1, j-1
		for (int i = 0; i < 5; i++) {
			if (input[i][i] != 0) {
				break;
			}
			if (i == 4)
				b += 1;

		}
		// 대각선 2 탐색
		for (int i = 0; i < 5; i++) {
			if (input[4 - i][i] != 0) {
				break;
			}
			if (i == 4)
				b += 1;
		}

		return b;
	}

}
