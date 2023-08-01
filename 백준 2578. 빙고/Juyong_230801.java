// 빙고 (실버4) https://noj.am/2578
//
// 시도 2: 최적화 시도
// board 입력 받을 때 역인덱싱 해서 탐색 시간 단축...?
// 더 늘어나네...? 자료구조 다룰 때 연산이 많이 추가되나...
//
// 결과: 14528KB / 140ms
// https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2578&from_mine=1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Juyong_230801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];
        Map<Integer, int[]> reverseIndex = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 5; j++) {
                reverseIndex.put(board[i][j], new int[]{i, j});
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(numbers::add);
        }

        // 0, 0이 왼쪽 위, x는 아래 방향, y는 오른쪽으로 증가
        int[] bingoHorizontal = new int[5]; // 행 방향 빙고
        int[] bingoVertical = new int[5];   // 열 방향 빙고
        int bingoDiagonalRise = 0;          // 우상향 빙고
        int bingoDiagonalFall = 0;          // 우하향 빙고

        ListIterator<Integer> it = numbers.listIterator();
        int ni = 0;
        while (it.hasNext()) {
            ni += 1;
            int n = it.next();
            int x = reverseIndex.get(n)[0];
            int y = reverseIndex.get(n)[1];
            
            // i, j 체크
            bingoHorizontal[x] += 1;
            bingoVertical[y] += 1;
            if (x == y) bingoDiagonalFall += 1;
            if (x == 4 - y) bingoDiagonalRise += 1;

            // 빙고 3개 이상 있으면 break
            int bingoCount = 0;
            for (int k = 0; k < 5; k++) {
                if (bingoHorizontal[k] >= 5) bingoCount += 1;
                if (bingoVertical[k] >= 5) bingoCount += 1;
            }
            if (bingoDiagonalFall >= 5) bingoCount += 1;
            if (bingoDiagonalRise >= 5) bingoCount += 1;

            if (bingoCount >= 3) {
                System.out.println(ni);
                return;
            }
        }
    }
}

// // 시도 1: 단순 구현
// //
// // 결과: 14428KB / 132ms
// // https://www.acmicpc.net/status?user_id=cheesecat47&problem_id=2578&from_mine=1

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class Nojam2578_230801 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int[][] board = new int[5][5];
//         for (int i = 0; i < 5; i++) {
//             board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//         }

//         List<Integer> numbers = new ArrayList<>();
//         for (int i = 0; i < 5; i++) {
//             Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(numbers::add);
//         }

//         // 0, 0이 왼쪽 위, x는 아래 방향, y는 오른쪽으로 증가
//         int[] bingoHorizontal = new int[5]; // 행 방향 빙고
//         int[] bingoVertical = new int[5];   // 열 방향 빙고
//         int bingoDiagonalRise = 0;          // 우상향 빙고
//         int bingoDiagonalFall = 0;          // 우하향 빙고

//         for (int ni = 0; ni < numbers.size(); ni++) {
//             int n = numbers.get(ni);
//             // board[i][j] == n 인 좌표를 찾고
//             int x = 0, y = 0;
//             boolean flag = true;
//             for (int i = 0; flag && i < 5; i++) {
//                 for (int j = 0; flag && j < 5; j++) {
//                     if (board[i][j] == n) {
//                         x = i;
//                         y = j;
//                         flag = false;
//                     }
//                 }
//             }
            
//             // i, j 체크
//             bingoHorizontal[x] += 1;
//             bingoVertical[y] += 1;
//             if (x == y) bingoDiagonalFall += 1;
//             if (x == 4 - y) bingoDiagonalRise += 1;

//             // 빙고 3개 이상 있으면 break
//             int bingoCount = 0;
//             for (int k = 0; k < 5; k++) {
//                 if (bingoHorizontal[k] >= 5) bingoCount += 1;
//                 if (bingoVertical[k] >= 5) bingoCount += 1;
//             }
//             if (bingoDiagonalFall >= 5) bingoCount += 1;
//             if (bingoDiagonalRise >= 5) bingoCount += 1;

//             if (bingoCount >= 3) {
//                 System.out.println(ni + 1);
//                 return;
//             }
//         }
//     }
// }
