import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr = new int[5][5];
    static int cnt = 0;
    static int bingo = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int call;
        for(int i=0;i<5;i++)
        {
        	for(int j=0;j<5;j++)
        		arr[i][j] = sc.nextInt();
        }
        for(int i=0;i<25;i++)
        {
        	call = sc.nextInt();
        	if (bingo < 3)
        	{
            	cnt++;
            	call(call);
        	}
        }
        System.out.println(cnt);
    }
    static void call(int call)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(arr[i][j] == call)
    			{
    				arr[i][j] = 0;
    				bingo = 0;
    				check(i, j);
    				return ;
    			}
    		}
    	}
    }
    static void check(int x, int y)
    {
    	int ccnt1 = 0;
    	int ccnt2 = 0;
    	for(int i=0;i<5;i++)
    	{
        	int xcnt = 0;
        	int ycnt = 0;
    		for(int j=0;j<5;j++)
    		{
    			if(arr[i][j] == 0)
    				xcnt++;
    			if(arr[j][i] == 0)
    				ycnt++;
    		}
        	if (xcnt == 5)
        		bingo++;
        	if (ycnt == 5)
        		bingo++;
    		if(arr[i][i] == 0)
    			ccnt1++;
    		if(arr[4-i][i] == 0)
    			ccnt2++;
    	}
    	if (ccnt1 == 5)
    		bingo++;
    	if (ccnt2 == 5)
    		bingo++;
    }
}
