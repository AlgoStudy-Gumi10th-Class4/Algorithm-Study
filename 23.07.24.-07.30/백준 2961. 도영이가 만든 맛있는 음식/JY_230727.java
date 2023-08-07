// 도영이가 만든 맛있는 음식 (실버2) https://noj.am/2961
//
// 결과: 14092KB / 120ms
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2961&from_mine=1
// 
// 기억할 점
// 도영이.. 짜파구리 요리사.. 메모...

// 시도 1
// 
// 접근 방법
// 신맛 또는 쓴맛 재료 하나 이상은 사용
// 신맛은 재료의 곱, 쓴맛은 합, 이 계산 결과의 차이가 가장 작도록

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JY_230727 {
    static int N;
    static long[][] ingredients;
    static long MIN_SOUR_BITTER_DELTA=Integer.MAX_VALUE;

    static void cook(int idx, long sour, long bitter) {
        if (sour > 0 && bitter > 0) {
            MIN_SOUR_BITTER_DELTA = Math.min(MIN_SOUR_BITTER_DELTA, Math.abs(sour - bitter));    
        }

        if (idx == N) return;

        // 이번 재료 사용
        cook(idx + 1, sour == 0 ? ingredients[idx][0] : sour * ingredients[idx][0], bitter + ingredients[idx][1]);
        // 사용 안함
        cook(idx + 1, sour, bitter);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력
            N = Integer.parseInt(br.readLine());
            ingredients = new long[N][2];

            for (int i = 0; i < N; i++) {
                // 0은 신맛, 1은 쓴맛
                String[] SB = br.readLine().split(" ");
                ingredients[i][0] = Integer.parseInt(SB[0]);
                ingredients[i][1] = Integer.parseInt(SB[1]);
            }

            // 0번 재료 사용
            cook(1, ingredients[0][0], ingredients[0][1]);
            // 사용 안함
            cook(1, 0, 0);

            System.out.println(MIN_SOUR_BITTER_DELTA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
