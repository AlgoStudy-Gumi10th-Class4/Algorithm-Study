import java.io.*;
import java.util.*;

public class Algo3 {
	static int[][] arr;
	static int[] updown = { 2, 3, 0, 1 };
	static int[] leftRight = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		// BufferedReader로 빠른 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//종이 크기 2^k
		int k = Integer.parseInt(br.readLine());
		//접기 명령 배열
		String[] ops = br.readLine().split(" ");

		// 구멍 위치
		int h = Integer.parseInt(br.readLine());
		//다 접고 난 후 가장 작은 정사각형
		arr = new int[1][1];
		//해당 정사각형에 난 구멍 표시
		arr[0][0] = h;

		//접은순서 반대로 펴주기
		for (int i = ops.length-1; i>=0; i--) {
			//해당 접기 명령과 매칭되는 문자열 찾기
			switch (ops[i]) {
			//아래로 접기
			case "D":
				//아래로 접기 펴기
				openDown();
				break;
			//위로 접기
			case "U":
				//위로 접기 펴기
				openUp();
				break;
			//오른쪽 접기
			case "R":
				//오른쪽 접기 펴기
				openRight();
				break;
			//왼쪽 접기
			case "L":
				//왼쪽 접기 펴기
				openLeft();
				break;
			}
		}
		//결과 배열 행렬 출력
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				//배열의 각 원소 출력
				System.out.print(arr[i][j]+" ");
			}
			//행 구분 줄바꿈
			System.out.println();
		}
	}
	//아래로 접기 열기
	static void openDown() {
		//위아래로 접으면 행이 두배가 됨
		int[][] narr = new int[arr.length * 2][arr[0].length];
		//기존 배열은 아래에 두고 중간을 기점으로 데칼코마니 붙여넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int cur = arr[i][j];
				//붙여넣으면서 구멍 위치가 바뀌는 것은 위아래끼리 같으므로 updown 배열로 미리 선언된 값 넣기
				narr[arr.length - 1 - i][j] = updown[cur];
				narr[arr.length + i][j] = cur;
			}
		}
		//기존 색종이 배열에 종이를 편 새로운 배열 넣기
		arr=narr;
	}
	static void openUp() {
		//위아래로 접으면 행이 두배가 됨
		int[][] narr = new int[arr.length * 2][arr[0].length];
		//기존 배열은 위에 두고 중간을 기점으로 데칼코마니 붙여넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int cur = arr[i][j];
				narr[i][j] = cur;
				//붙여넣으면서 구멍 위치가 바뀌는 것은 위아래끼리 같으므로 updown 배열로 미리 선언된 값 넣기
				narr[(arr.length*2)-1-i][j] = updown[cur];
			}
		}
		//기존 색종이 배열에 종이를 편 새로운 배열 넣기
		arr=narr;
	}
	static void openRight() {
		//좌우로 접으면 열이 두배가 됨
		int[][] narr = new int[arr.length][arr[0].length*2];
		//기존 배열은 오른쪽에 두고 중간을 기점으로 데칼코마니 붙여넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int cur = arr[i][j];
				//붙여넣으면서 구멍 위치가 바뀌는 것은 좌우끼리 같으므로 leftright 배열로 미리 선언된 값 넣기
				narr[i][arr[0].length-1-j] = leftRight[cur];
				narr[i][arr[0].length+j] = cur;
			}
		}
		//기존 색종이 배열에 종이를 편 새로운 배열 넣기
		arr=narr;
	}
	static void openLeft() {
		//좌우로 접으면 열이 두배가 됨
		int[][] narr = new int[arr.length][arr[0].length*2];
		//기존 배열은 왼쪽에 두고 중간을 기점으로 데칼코마니 붙여넣기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int cur = arr[i][j];
				//붙여넣으면서 구멍 위치가 바뀌는 것은 좌우끼리 같으므로 leftright 배열로 미리 선언된 값 넣기
				narr[i][j] = cur;
				narr[i][(arr[0].length*2)-1-j] = leftRight[cur];
			}
		}
		//기존 색종이 배열에 종이를 편 새로운 배열 넣기
		arr=narr;
	}
}
