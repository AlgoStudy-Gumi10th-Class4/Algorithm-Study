// 참외밭 (실버2) https://noj.am/2477
//
// 시도 2: 처음에 인덱스 잘못 써서 한 번 틀림
// 1번씩만 나온 방향이 가장 긴 변(큰 사각형)이고, 거기서 두 칸씩 차이나는 변이 작은 사각형
//
// 결과: 17620KB / 216ms
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2477&from_mine=1

import java.util.Scanner;

public class Juyong_230801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int K = sc.nextInt();
        int[] d = new int[7];
        int[] l = new int[7];

        int[] dCount = { 0, 0, 0, 0, 0 };

        for (int i = 1; i <= 6; i++) {
            d[i] = sc.nextInt();
            l[i] = sc.nextInt();
            dCount[d[i]] += 1;
        }
        sc.close();

        int bigArea = 1;
        int smallArea = 1;
        for (int i = 1; i <= 6; i++) {
            if (dCount[d[i]] != 1) continue;
            bigArea *= l[i];
            smallArea *= l[i + 3 > 6 ? i - 3 : i + 3];
        }
        System.out.println((bigArea - smallArea) * K);        
    }
}