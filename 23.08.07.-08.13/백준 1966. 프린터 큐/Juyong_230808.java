import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 프린터 큐 (실버3)
 * 
 * <p>
 * 시도 1 단순 구현
 * </p>
 * 
 * 결과: 14796KB / 148ms
 * 
 * @author cheesecat47@gmail.com
 * @see https://noj.am/1966
 */
public class Juyong_230808 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      String[] NM = br.readLine().split(" ");
      int N = Integer.parseInt(NM[0]);
      int M = Integer.parseInt(NM[1]);

      Queue<int[]> q = new ArrayDeque<int[]>();
      int[] level = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int i = 0; i < N; i++) {
        // {문서인덱스, 중요도}
        q.offer(new int[] { i, level[i] });
      }
      Arrays.sort(level);

      int i = level.length - 1;
      int nth = 0;

      int[] doc = q.poll();
      while (doc != null) {
        if (doc[1] < level[i]) {
          // 나머지 문서 중 중요도가 높은 문서가 있다면
          // 이 문서 인쇄 않고 다시 큐에 넣음
          q.offer(doc);
        } else {
          // 인쇄
          i -= 1;
          nth += 1;
          if (doc[0] == M) {
            sb.append(nth).append('\n');
            break;
          }
        }
        doc = q.poll();
      }
    }
    System.out.println(sb);
  }
}
