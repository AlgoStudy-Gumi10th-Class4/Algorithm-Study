import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juyong_Algo_1 {

	public static void main(String[] args) throws IOException {
		// 입력을 받기 위한 BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 위한 StringBuilder 선언
		StringBuilder sb = new StringBuilder();

		// 게임 테스트 횟수 입력
		int T = Integer.parseInt(br.readLine());
		// T번 반복
		for (int t = 1; t <= T; t++) {
			// 종이컵의 수, 간식이 들어있는 종이컵 위치, 컵의 위치를 맞바꾸는 횟수 입력
			String[] NXK = br.readLine().split(" ");
			// 종이컵의 수
			int N = Integer.parseInt(NXK[0]);
			// 간식이 들어있는 종이컵 위치
			int X = Integer.parseInt(NXK[1]);
			// 컵의 위치를 맞바꾸는 횟수
			int K = Integer.parseInt(NXK[2]);

			// 컵 위치 K번 바꾸기
			for (int k = 0; k < K; k++) {
				// 바꾼 두 컵의 위치 A, B
				String[] AB = br.readLine().split(" ");
				// A 인덱스
				int A = Integer.parseInt(AB[0]);
				// B 인덱스
				int B = Integer.parseInt(AB[1]);

				// 이번에 바꿀 두 컵 중 간식이 든 컵이 있는지 확인
				if (X == A) {
					// 만약 A가 X와 같다면 X에 B 저장
					X = B;
				} else if (X == B) {
					// B가 X와 같다면 X에 A 저장
					X = A;
				}
			}
			// 이번 게임 테스트 결과 출력 스트링 sb에 추가
			sb.append(String.format("#%d %d\n", t, X));
		}
		// 전체 결과 출력
		System.out.println(sb);
	}

}
