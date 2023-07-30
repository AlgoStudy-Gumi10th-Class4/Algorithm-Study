import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 일기..
// 문제 잘 읽자 성규야...
// 오늘도 문제를 잘못 이해해서 다시하고 다시했다.
// 아기 상어 크기와 물고기 크기가 같으면 먹을 수 있을 줄 알았다..
// 그리고 큰 물고기는 지나가지 못하는 것을 확인하지 못하고 하다가..
// 또 다시 했다..
// 많이 지저분하다 평일에 정리해야겠따.
// 풀이
// 상어가 먹을 수 있는 물고기를 체크하는데 좀 어려움이 있었다.
// boolean으로 확인을 해가면서 할려고 했는데 시간이 너무 오래 걸렸다.
// 결국 처음으로 quene을 사용하여 풀이하였는데.
// poll하면 바로 삭제되며 값을 가져올 수 있는 것이 너무 좋았다.
// quene으로 체크하면서 배열을 하나더 만들어 거리를 확인하고 계속해서 수정해 나갈 수 있게 하였다.
// 먹을 수 있는 물고기는 ArrayList에 차곡차곡 넣어서 체크가 끝나면 eat함수로 넘어간다.
// 만약 list가 비어있다면 그 즉시 프로그램은 끝난다.
// list에 값이 들어가 있다면 먹을 수 있는 물고기가 있으므로. 거리를 기준으로 가장 가까운 물고기를 찾아낸다.
// 찾아낸 물고기를 먹으면 eatCnt값을 하나 더 증가시켜 아기 상어 size가 변동되도록 하였따.
// 이 과정을 반복한다.

public class Main {
    static int n;
    static int[][] map;
    static int size = 2;
    static int time = 0;
    static int eatCnt = 0;
    static int x;
    static int y;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				map[i][j] = sc.nextInt();
			    if(map[i][j] == 9)
				{
					x = i;
					y = j;
                    map[i][j] = 0;
				}
			}
		}
        sc.close();

		start();
		System.out.println(time);
    }

    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static ArrayList<Coor> eatFish = new ArrayList<Coor>();
    static Queue<Coor> q = new LinkedList<Coor>();
    static int[][] dis;

    static void start()
    {
        if (eatCnt == size)
        {
            eatCnt = 0;
            size++;
        }
        // boolean[][] visit = new boolean[n][n];
        q.add(new Coor(x, y, 0));
        dis = new int[n][n];
        eatCheck();

        if (eatFish.size() == 0)
            return ;
        // for(int i=0;i<eatFish.size();i++)
        //     System.out.println(eatFish.get(i));
   
        eat();
    }

    static void eatCheck()
    {
       while (!q.isEmpty())
       {
            Coor c = q.poll();
            // System.out.println(c);
            dis[c.getX()][c.getY()] = c.getDis();
            for(int i=0;i<4;i++)
            {
                // System.out.println(i);
                int tx = c.getX() + dx[i];
                int ty = c.getY() + dy[i];
                if (tx >= 0 && tx < n && ty >= 0 && ty< n && dis[tx][ty] == 0 && map[tx][ty] <= size)
                {
                    dis[tx][ty] = dis[c.getX()][c.getY()] + 1;
                    if (map[tx][ty] < size && map[tx][ty] > 0)
                        eatFish.add(new Coor(tx, ty, dis[tx][ty]));
                    else
                        q.add(new Coor(tx, ty, dis[tx][ty]));
                }
            }
       }
    }

    static void eat()
    {
        int min = Integer.MAX_VALUE;
        int[] temp;

        for(int i=0;i<eatFish.size();i++)
        {
            temp = eatFish.get(i).getCoor();
            if (min > temp[2])
            {
                min = temp[2];
                x = temp[0];
                y = temp[1];
            }
            else if(min == temp[2])
            {
                if (x > temp[0])
                {
                    x = temp[0];
                    y = temp[1];
                }
                else if (x == temp[0]){
                    if (y > temp[1])
                    {
                        x = temp[0];
                        y = temp[1];
                    }
                }
            }
        }
        eatCnt++;
        time += min;
        // System.out.println(min + " " + time + " " + eatCnt + " " + size);
        eatFish.clear();
        map[x][y] = 0;
        start();
    }
}


class Coor{
	private int x;
	private int y;
    private int dis;
	Coor() {}
	Coor(int x, int y, int dis){
		this.x = x;
		this.y = y;
        this.dis = dis;
	}
	public int[] getCoor()
	{
		int arr[] = {x, y, dis};
		return arr;
	}
	@Override
	public String toString() {
		return "Coor [x=" + x + ", y=" + y + " " + dis +  "]";
	}
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDis() {
        return dis;
    }
    public void setDis(int dis) {
        this.dis = dis;
    }
}
