import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 종이접기 (골드3)
 *
 * @author cheesecat47@gmail.com
 * @see https://noj.am/20187
 */

/**
 * 결과: 18864KB / 184ms / 100점
 */
public class Juyong_Algo_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] foldOrder = new String[2 * k];
        for (int i = 0; i < 2 * k; i++) {
            foldOrder[i] = st.nextToken();
        }
        int pos = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[2][2];
        if (pos == 0) arr[0][0] = true;
        else if (pos == 1) arr[0][1] = true;
        else if (pos == 2) arr[1][0] = true;
        else if (pos == 3) arr[1][1] = true;

        for (int i = 2 * k - 1; i >= 0; i--) {
            boolean[][] tmpArr = null;
            int h = arr.length;
            int w = arr[0].length;
            switch (foldOrder[i]) {
                case "D":
                    tmpArr = new boolean[h * 2][w];
                    for (int m = 0; m < h; m++) {
                        tmpArr[m] = arr[h - 1 - m];
                        tmpArr[h + m] = arr[m];
                    }
                    break;
                case "U":
                    tmpArr = new boolean[h * 2][w];
                    for (int m = 0; m < h; m++) {
                        tmpArr[m] = arr[m];
                        tmpArr[h * 2 - 1 - m] = arr[m];
                    }
                    break;
                case "R":
                    tmpArr = new boolean[h][w * 2];
                    for (int m = 0; m < h; m++) {
                        for (int n = 0; n < w; n++) {
                            tmpArr[m][w + n] = arr[m][n];
                            tmpArr[m][w - 1 - n] = arr[m][n];
                        }
                    }
                    break;
                case "L":
                    tmpArr = new boolean[h][w * 2];
                    for (int m = 0; m < h; m++) {
                        for (int n = 0; n < w; n++) {
                            tmpArr[m][n] = arr[m][n];
                            tmpArr[m][w * 2 - 1 - n] = arr[m][n];
                        }
                    }
                    break;
            }
            arr = tmpArr;
        }

        for (int i = 0; i < 1 << k; i++) {
            for (int j = 0; j < 1 << k; j++) {
                if (arr[i * 2][j * 2]) sb.append(0);
                else if (arr[i * 2][j * 2 + 1]) sb.append(1);
                else if (arr[i * 2 + 1][j * 2]) sb.append(2);
                else if (arr[i * 2 + 1][j * 2 + 1]) sb.append(3);

                if (j != 1 << k) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

///**
// * 결과: 19680KB / 208ms / 63점
// */
//public class Nojam20187 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int k = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        String[] foldOrder = new String[2 * k];
//        for (int i = 0; i < 2 * k; i++) {
//            foldOrder[i] = st.nextToken();
//        }
//        int pos = Integer.parseInt(br.readLine());
//
//        int n = 1 << k;
//
//        int[][] arr = new int[n][n];
//
//        int x = 1;
//        int y = 1;
//
//        Collections.reverse(Arrays.asList(foldOrder));
//        for (String s : foldOrder) {
//            if (s.equals("D")) x <<= 1;
//            else if (s.equals("R")) y <<= 1;
//        }
//        x = (x - 1) % 2;
//        y = (y - 1) % 2;
//        // System.out.printf("%d %d\n", x, y);
//
//        boolean[] hole = new boolean[4];
//        hole[pos] = true;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean[] tmpHole = hole.clone();
//                boolean tmp;
//                if (i % 2 != x && j % 2 == y) {
//                    tmp = tmpHole[0];
//                    tmpHole[0] = tmpHole[2];
//                    tmpHole[2] = tmp;
//                    tmp = tmpHole[1];
//                    tmpHole[1] = tmpHole[3];
//                    tmpHole[3] = tmp;
//                } else if (i % 2 == x && j % 2 != y) {
//                    tmp = tmpHole[0];
//                    tmpHole[0] = tmpHole[1];
//                    tmpHole[1] = tmp;
//                    tmp = tmpHole[2];
//                    tmpHole[2] = tmpHole[3];
//                    tmpHole[3] = tmp;
//                } else if (i % 2 != x && j % 2 != y) {
//                    tmp = tmpHole[0];
//                    tmpHole[0] = tmpHole[3];
//                    tmpHole[3] = tmp;
//                    tmp = tmpHole[1];
//                    tmpHole[1] = tmpHole[2];
//                    tmpHole[2] = tmp;
//                }
//                for (int k = 0; k < 4; k++) {
//                    if (!tmpHole[k]) continue;
//                    arr[i][j] = k;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                sb.append(arr[i][j]);
//                if (j != n - 1) sb.append(" ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//    }
//}
