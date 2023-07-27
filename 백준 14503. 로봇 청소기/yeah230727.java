import java.io.*;
import java.util.Arrays;

public class Main {
    //동작 1. 지금 위치 청소 or 현재방향 앞 청소 안ㅇ되면 가서 청소
    //2. 사방향 청소안된칸 하나라도 있으면 반시계회전
    //3. 다되어있으면 후진,후진 못하는 위치이면 멈추기
    //=> 잘못된 문제 이해
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int[][] arr;

    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] tmp=br.readLine().split(" ");
        N=Integer.parseInt(tmp[0]);
        M=Integer.parseInt(tmp[1]);
        tmp=br.readLine().split(" ");
        int[] rob=new int[2];
        rob[0]=Integer.parseInt(tmp[0]);
        rob[1]=Integer.parseInt(tmp[1]);
        int dir=Integer.parseInt(tmp[2]);

        arr=new int[N][M];
        for(int i=0;i<N;i++)
        {
            tmp=br.readLine().split(" ");
            for(int j=0;j<M;j++)
            {
                arr[i][j]=Integer.parseInt(tmp[j]);
            }
        }
//        for(int[] ar:arr)
//            System.out.println(Arrays.toString(ar));
        int res=0;

        while(true)
        {
            int state=searchFour(rob[0],rob[1],dir);
            //System.out.println(rob[0]+" "+rob[1]+" "+dir+" "+state);
            if(state==0)
            {
                arr[rob[0]][rob[1]]=-1;
                res++;
//                for(int[] ar:arr)
//                    System.out.println(Arrays.toString(ar));
            }
            else if (state==1)
            {
                dir=(dir+3)%4;
                int ty=rob[0]+dy[dir];
                int tx=rob[1]+dx[dir];
                if(arr[ty][tx]==0) {
                    rob[0] = ty;
                    rob[1] = tx;
                    arr[rob[0]][rob[1]]=-1;
                    res++;
                }
            }
            else {
                int ty=rob[0]-dy[dir];
                int tx=rob[1]-dx[dir];

                if(arr[ty][tx]!=1)
                {
                    rob[0]=ty;
                    rob[1]=tx;
                }
                else {
                    break;
                }
            }

        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res+"\n");
        bw.flush();
        bw.close();
    }
    static int searchFour(int y,int x,int dir)
    {
        if(arr[y][x]==0)
        {
            return 0;
        }
        for(int i=0;i<4;i++) {
            int ty = y + dy[(dir + i) % 4];
            int tx = x + dx[(dir + i) % 4];
            if (arr[ty][tx] == 0) {
//                System.out.println(ty+" "+tx+"***"+ arr[ty][tx]);
                return 1;
            }
        }
        return -1;
    }
}
