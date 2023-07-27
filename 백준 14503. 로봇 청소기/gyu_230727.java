import java.util.*;

public class Main {
    static int n,m,x,y,way;
    static int[][] map;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        way = sc.nextInt();

        map = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                map[i][j] = sc.nextInt();
        }
        clean();
        System.out.println(cnt);
        
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] bx = {1,0,-1,0};
    static int[] by = {0,-1,0,1};

    static void clean()
    {
        if (x < 0 || x >= n || y < 0 || y >=m || map[x][y] == 1)
            return ;
        // 1단계
        if (map[x][y] == 0)
        {
            map[x][y] = 2;
            cnt++;
        }
        // System.out.println();
        // System.out.println();
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //         System.out.print(map[i][j]);
        //     System.out.println();
        // }
        int flag = 0;
        for(int i=0;i<4;i++)
        {
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            if (temp_x >= 0 && temp_x < n && temp_y >= 0 && temp_y < m
                    && map[temp_x][temp_y] == 0)
            {
                flag = 1;
                break;
            }
        }

        if (flag == 0)
        {
            x = x + bx[way];
            y = y + by[way];
        }
        else
        {
            
            for(int i=0;i<4;i++)
            {
                way--;
                if (way < 0)
                    way = 3;
                int temp_x = x + dx[way];
                int temp_y = y + dy[way];
                
                if (temp_x >= 0 && temp_x < n && temp_y >= 0 && temp_y < m
                    && map[temp_x][temp_y] == 0)
                {
                    x = temp_x;
                    y = temp_y;
                    break;
                }
            }
        }
        clean();
    }
}
