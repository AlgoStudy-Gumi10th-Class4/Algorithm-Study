import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 야바위게임

public class Algo1_구미_4반_양성규 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=t;tc++) {								// 테스트의 횟수를 입력받고 반복한다.
			String[] sp = bf.readLine().split(" ");				// 가장 먼저 종이컵 수, 처음에 들어있는 간식의 위치, 위치를 바꾸는 횟수를 입력 받는다.		
			int n = Integer.parseInt(sp[0]);
			int x = Integer.parseInt(sp[1]);
			int r = Integer.parseInt(sp[2]);
			int[] arr = new int[n];								// 종이컵 수 만큼 배열을 선언해 준다.
			arr[x-1] = 1;										// 처음 간식이 있는 위치에 1을 넣어준다.
					
			for(int i=0;i<r;i++) {								// 바꿀 횟수만큼 반복한다.
				sp = bf.readLine().split(" ");
				int temp = arr[Integer.parseInt(sp[0])-1];		// temp를 사용하여 바로바로 바꿔준다.
				arr[Integer.parseInt(sp[0])-1] = arr[Integer.parseInt(sp[1]) -1];
				arr[Integer.parseInt(sp[1]) - 1] = temp;			// 이렇게 하면 입력 받은 위치가 서로 바뀌게 된다.
			}
					
			for(int i=0;i<n;i++) {
				if (arr[i] == 1) {	// 배열의 값이 1이면 간식이 들어있기 때문에 출력해주고 끝낸다.
					bw.write("#" + String.valueOf(tc) + " " + String.valueOf(i+1) + "\n");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
