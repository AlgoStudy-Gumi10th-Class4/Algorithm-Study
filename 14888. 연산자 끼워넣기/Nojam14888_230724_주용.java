// 연산자 끼워넣기 (실버1) https://noj.am/14888

import java.util.Scanner;

public class Nojam14888_230724 {
	static int N;
	static int MAX_VAL = Integer.MIN_VALUE;
	static int MIN_VAL = Integer.MAX_VALUE;
	static int[] numbers;

	static int[] copyOps(int[] ops, int i) {
		int[] tmp = ops.clone();
		tmp[i] -= 1;
		return tmp;
	}

	static void calc(int result, int numIdx, int[] ops) {
		if (numIdx == N) {
			MAX_VAL = Math.max(MAX_VAL, result);
			MIN_VAL = Math.min(MIN_VAL, result);
			return;
		}

		for (int opIdx = 0; opIdx < 4; opIdx++) {
			if (ops[opIdx] == 0) continue;

			int newResult = result;
			if (opIdx == 0) newResult += numbers[numIdx];
			else if (opIdx == 1) newResult -= numbers[numIdx];
			else if (opIdx == 2) newResult *= numbers[numIdx];
			else {
				if (newResult < 0) {
					newResult *= -1;
					newResult /= numbers[numIdx];
					newResult *= -1;
				} else {
					newResult /= numbers[numIdx];
				}
			}

			calc(newResult, numIdx + 1, copyOps(ops, opIdx));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 초기화
		N = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		int[] ops = new int[4];
		for (int i = 0; i < 4; i++) {
			ops[i] = sc.nextInt();
		}
		sc.close();

		calc(numbers[0], 1, ops);

		System.out.println(MAX_VAL);
		System.out.println(MIN_VAL);
	}
}

