import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 처음에 잘못 이해한 문제이다.
// 팀들의 함을 구해 최소 차이점을 구하는 문제인데,, 왜 그렇게 생각했는지는 모르겠지만, 2명씩 묶어서 계산을 하였다.
// 결국 인터넷을 보고 문제를 잘못 이해한 것을 알고, 다시 작성하였다.
// 또한, 차이점을 구하면서 시간 초과가 발생하여 0값이 나오면 프로그램을 강제 종료하게 만들었다.
// 문제를 잘 읽어보자...

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
        
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		check = new boolean[n];
        
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
        

        find(0,0);
        System.out.println(min);
    }

    static void find(int index, int dep){
        if (dep == n/2)
        {
            int ssum = 0;
            int lsum = 0;
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(check[i] && check[j])
                    {
                        ssum += arr[i][j];
                        ssum += arr[j][i];
                    }
                    else if (!check[i] && !check[j])
                    {
                        lsum += arr[i][j];
                        lsum += arr[j][i];
                    }
                }
            }
            int val = Math.abs(ssum - lsum);
            if (val == 0)
            {
                System.out.println(val);
                System.exit(0);
            }
            min = Math.min(min,val);
            return;
        }
        for(int i=index;i<n;i++)
        {
            if(!check[i])
            {
                check[i] = true;
                find(i + 1, dep + 1);
                check[i] = false;
            }
        }
    }
}
