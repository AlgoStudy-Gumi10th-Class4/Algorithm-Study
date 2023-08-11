import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 좌표 정렬하기 (실버5)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/11650
 */

/**
 * <p>
 * 시도 3: 단순하게 구현해보자
 *
 * </p>
 * 문제 자체가 단순히 10만 개 입출력이었기 때문에 오히려 TreeMap을 쓰는게 입출력 할 때마다 정렬과정이 포함돼서 느렸나보다.
 * <p>
 * 결과: 205892KB / 2212ms
 */
class Juyong_230811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> s = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            s.putIfAbsent(c[0], new ArrayList<>());
            s.get(c[0]).add(c[1]);
        }

        for (Map.Entry<Integer, List<Integer>> e : s.entrySet()) {
            int k = e.getKey();
            ArrayList<Integer> arr = (ArrayList<Integer>) e.getValue();
            Collections.sort(arr);
            for (int a: arr) {
                sb.append(String.format("%d %d\n", k, a));
            }
        }
        System.out.println(sb);
    }
}

/**
 * <p>
 * 시도 2: 오히려 컬렉션이 더 느린가?
 *
 * </p>
 * <p>
 * 결과: KB / ms
 */
//class Nojam11650 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] coordinates = new int[N][2];
//        Map<Integer, Map<Integer, Boolean>> s = new TreeMap<>();
//
//        for (int i = 0; i < N; i++) {
//            int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//            s.putIfAbsent(c[0], new TreeMap<Integer, Boolean>());
//            s.get(c[0]).put(c[1], true);
//        }
//
//        for (Map.Entry<Integer, Map<Integer, Boolean>> e : s.entrySet()) {
//            for (Map.Entry<Integer, Boolean> a : e.getValue().entrySet()) {
//                sb.append(String.format("%d %d\n", e.getKey(), a.getKey()));
//            }
//        }
//        System.out.println(sb);
//    }
//}

/**
 * <p>
 * 시도 1 단순 구현 -> 시간 초과
 * </p>
 * <p>
 * 결과: KB / ms
 */
//class Nojam11650 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] coordinates = new int[N][2];
//        Map<Integer, Map<Integer, Boolean>> s = new TreeMap<>();
//
//        for (int i = 0; i < N; i++) {
//            int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//            s.putIfAbsent(c[0], new TreeMap<Integer, Boolean>());
//            s.get(c[0]).put(c[1], true);
//        }
//
//        for (Map.Entry<Integer, Map<Integer, Boolean>> e : s.entrySet()) {
//            for (Map.Entry<Integer, Boolean> a : e.getValue().entrySet()) {
//                sb.append(String.format("%d %d\n", e.getKey(), a.getKey()));
//            }
//        }
//        System.out.println(sb);
//    }
//}
