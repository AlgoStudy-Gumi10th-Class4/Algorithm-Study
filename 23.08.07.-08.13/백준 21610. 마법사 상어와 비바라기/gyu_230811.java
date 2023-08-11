import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static Cloud cloud = Cloud.getInstance();
	static int[][] location;
	static int[][] map;
	static int water = 0;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sp = bf.readLine().split(" ");
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		cloud.setCloud(new int[] {n-2,0}, new int[] {n-1,1}, n);
		map = new int[n][n];
		for(int i=0;i<n;i++) {								// 바구니 입력
			sp = bf.readLine().split(" ");
			for(int j=0;j<n;j++)
				map[i][j] = Integer.parseInt(sp[j]);
		}
		for(int i=0;i<m;i++) {								// 이동 입력
			sp = bf.readLine().split(" ");					
			cloud.moveCloud(Integer.parseInt(sp[0])-1, Integer.parseInt(sp[1]));
			rain();											// 바로바로 이동시키고 비가 오게 한다.
		}
		for(int i=0;i<n;i++) {								// 바구니에 들어있는 물을 더해준다.
			for(int j=0;j<n;j++)
				water += map[i][j];
		}
		bw.write(String.valueOf(water));
		bf.close();
		bw.flush();
		bw.close();
	}
	static boolean[][] visit;								// 구름을 생성하기 위해 현재 비가 내린 지역을 표시하기 위해 배열을 선언한다.
	static void rain() {
		visit = new boolean[n][n];
		location = cloud.getLocation();						// 구름 위치를 받아온다.
		for(int i=0;i<location.length;i++) {				// 구름의 개수 만큼 반복하며
			map[location[i][0]][location[i][1]]++;			// 구름이 있는 위치의 바구니에 비가 내리게 한다.
			visit[location[i][0]][location[i][1]] = true;	// 방문했다고 표시해준다.
		}
		magic();
		createCloud();
	}
	
	static int[] mx = {-1, -1, 1 ,1};						// 마법을 부르기위해 대각선 방향을 가지고 있을 배열을 선언한다.
	static int[] my = {-1, 1, 1, -1};
	static void magic() {
		for(int i=0;i<location.length;i++) {
			int sum = 0;
			for(int j=0;j<4;j++) {							// 구름의 위치에서 각 대각선 바구니를 확인하여 더해준다.
				int tempX = location[i][0] + mx[j];
				int tempY = location[i][1] + my[j];
				if(tempX < 0 || tempX >= n || tempY < 0 || tempY >= n || map[tempX][tempY] < 1)
					continue;
				sum++;
			}
			map[location[i][0]][location[i][1]] += sum;
		}
	}
	
	static void createCloud() {								// 비가 다 내리고 구름을 생성할 함수이다.
		ArrayList<int[]> temp = new ArrayList<>();			// 배열을 선언해주고
		for(int i=0;i<n;i++) {						
			for(int j=0;j<n;j++) {	
				if (visit[i][j] == false) {					// 구름이 없는 바구니 이면서 바구니에 들어있는 물의 양이 2보다 크면
					if (map[i][j] >= 2) {
						map[i][j] -= 2;
						temp.add(new int[] {i,j});			// 선언한 배열에 위치를 저장해둔다.
					}
				}
			}
		}
		cloud.createCloud(temp);							// 저장해둔 위치를 구름클래스의 생성함수를 사용하여 구름을 생성한다.
	}
}

// 구름 정보를 가지고 있을 클래스 선언
class Cloud{
	private int[] dx = {0,-1,-1,-1,0,1,1,1};		// 이동에 필요한 방향배열이다.
	private int[] dy = {-1,-1,0,1,1,1,0,-1};
	private int[][] location;						// 현재 구름 위치
	private int n;
	private Cloud() {}									// 싱글톤
	private static Cloud instance = new Cloud();
	public static Cloud getInstance() {
		return instance;
	}
	public void setCloud(int[] left, int[] right, int n) {		// 처음 시작할때 주어지는 구름이다.
		location = new int[4][2];
		location[0] = left;
		location[1] = new int[] {right[0],left[1]};
		location[2] = right;
		location[3] = new int[] {left[0],right[1]};
		this.n = n;
	}
	public void createCloud(ArrayList temp) {					// 구름을 생성하면 구름의 개수와 위치가 다 다르기 때문에 다시 정의해준다ㅣ
		location = new int[temp.size()][2];
		for(int i=0;i<temp.size();i++) {
			location[i] = (int[]) temp.get(i);
		}
	}
		
	public void moveCloud(int dir, int cnt) {					// 구름을 이동해준다.
		for(int i=0;i<location.length;i++) {
			for(int j=0;j<cnt;j++) {
				location[i][0] += dx[dir];			
				location[i][1] += dy[dir];
				if(location[i][0] < 0)							// 만약 범위를 넘어가면 n 또는 0으로 바꿔준다.
					location[i][0] = n-1;
				if(location[i][0] >= n)
					location[i][0] = 0;
				if(location[i][1] < 0)
					location[i][1] = n-1;
				if(location[i][1] >= n)
					location[i][1] = 0;
			}
		}
	}
	public int[][] getLocation() {								// 구름 위치를 반환한다.
		return location;
	}
}
