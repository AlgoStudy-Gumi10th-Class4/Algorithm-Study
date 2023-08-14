import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Algo2_구미_4반_양성규 {
	static int n;					// 공간 크기
	static char[][] map;			// 배열
	static int sum;					// 이동 횟수
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=t;tc++) {								// 테스트의 횟수를 입력받고 반복한다.
			n = Integer.parseInt(bf.readLine());
			map = new char[n][n];
			sum = 0;
			
			for(int i=0;i<n;i++) {								// 공간의 값을 입력받는다.
				String[] sp = bf.readLine().split(" ");
				for(int j=0;j<n;j++) 
					map[i][j] = sp[j].charAt(0);
			}
			
			for(int i=0;i<n;i++) {					
				for(int j=0;j<n;j++) {
					char c = map[i][j];					// 배열을 다시 돌면서
					if(c == 'A')						// A,B,C 로봇인지 확인 후 
						move(0,i,j);					// move함수에 어떤 로봇인지, 현재 좌표는 어디인지를 같이 보낸다.
					else if(c == 'B')
						move(1,i,j);
					else if(c == 'C')
						move(2,i,j);
				}
			}
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(sum) + "\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
	
	static void move(int index, int sx, int sy) {
		int x = sx;
		int y = sy;
		if (index == 0) {			// index 0은 A로봇이다.
			while(true) {			// 오른쪽으로만 갈수 있기 때문에 공백일때까지만 반복 하면서 카운트해준다.
				y += 1;
				if (y >= n || map[x][y] != 'S')
					break;
				sum++;
			}
		}else if(index== 1) {		// index 1은 B로봇이다.
			int[] temp = {-1,1};		// 상하로 움직이기에 temp 배열을 선언해주어 방향을 정해준다.
			for(int i=0;i<2;i++) {
				x =sx;
				while(true) {			// for문에서 방향전환이 되기 때문에 while에서 반복하면서 공백일때만 움직인다.
					x += temp[i];
					if(x < 0 || x >= n || map[x][y] != 'S')
						break;
					sum++;
				}
			}
		}else {					// index 2은 C로봇이다. else if는 굳이 해줄 필요가 없기 때문에 else로 해주었다.
			int[] dx = {-1,-1,1,1};		// 대각선으로 움직이기 때문에 배열로 방향을 정해준다.
			int[] dy = {-1,1,1,-1};
			for(int i=0;i<4;i++) {		// 총 대각선은 4가지이므로 4번 반복할 예정이다.
				x = sx;
				y = sy;
				while(true) {			// 각 for문의 값에 따라 대각선 방향이 정해지므로 while문에서는 그저 반복만하면서 범위안에 있는지,
					x += dx[i];			// 공백인지 체크하면서 이동횟수를 더해준다.
					y += dy[i];
					if(x < 0 || x >= n || y < 0 || y >= n || map[x][y] != 'S')
						break;
					sum++;
				}
				
			}
		}

	}
}
