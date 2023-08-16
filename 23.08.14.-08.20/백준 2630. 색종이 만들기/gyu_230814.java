import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[][] arr;
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		N = Integer.parseInt(sp[0]);
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			sp = bf.readLine().split(" ");
			for(int j=0;j<N;j++)
				arr[i][j] = Integer.parseInt(sp[j]);
		}
		check(N,0,0);		// 함수 시작
		bw.write(String.valueOf(white) + "\n");
		bw.write(String.valueOf(blue) + "\n");
		bf.close();
		bw.flush();
		bw.close();
	}
	static void check(int n,int x,int y) {
		for(int i=x;i<x+n;i++) {				// 구역 반복
			for(int j=y;j<y+n;j++) {	
				if (arr[x][y] != arr[i][j]) {		// 값이 다르다면
					check(n/2,x,y);					// 4등분으로 다시 함수 시작
					check(n/2,x,y+n/2);
					check(n/2,x+n/2,y);
					check(n/2,x+n/2,y+n/2);
					return;
				}
			}
		}
		if(arr[x][y] == 0)			// 값이 다 같다면 카운트해준다.
			white++;
		else
			blue++;
	}
}
