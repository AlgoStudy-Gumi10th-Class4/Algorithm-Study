import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 숫자 카드 (실버5)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/10815
 */

// 169300KB / 1124ms
class Juyong_230815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 카드에 같은 수가 적힌 경우는 없다.
        Map<Integer, Integer> map = new HashMap<>();

        // 문제 입력
        int N = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(c -> map.put(c, 1));

        int M = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(c -> sb.append(map.getOrDefault(c, 0)).append(" "));

        System.out.println(sb.toString().trim());
    }
}

// 128084KB / 1428ms
//class Nojam10815 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        // 문제 입력
//        int N = Integer.parseInt(br.readLine());
//        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int M = Integer.parseInt(br.readLine());
//        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        // 정렬
//        Arrays.sort(cards);
//
//        for (int m : numbers) {
//            sb.append(binarySearch(cards, 0, N - 1, m)).append(" ");
//        }
//        System.out.println(sb.toString().trim());
//    }
//
//    static int binarySearch(int[] arr, int l, int r, int m) {
//        if (l > r) return 0;
//        if (l == r) return arr[l] == m ? 1 : 0;
//
//        int answer = 0;
//        int n = (l + r) / 2;
//        if (arr[n] == m) answer = 1;
//        if (arr[n] > m) answer = binarySearch(arr, l, n - 1, m);
//        if (arr[n] < m) answer = binarySearch(arr, n + 1, r, m);
//        return answer;
//    }
//}
