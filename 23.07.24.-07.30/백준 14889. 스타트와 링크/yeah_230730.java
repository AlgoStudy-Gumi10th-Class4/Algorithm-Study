import java.io.*;
import java.util.*;
// 풀이시간이 2시간 정도로 매우 어렵게 품
// 1. 규칙성을 찾아서 dp? knapsack 느낌으로 풀려고 했으나 해법을 찾지못함
// 2. HashMap으로 dfs를 구현하려고 했으나 그럼 모든 경우의 수의 합을 계속 가지고 있어야함
// 메모리가 너무 커질 것 같아서 포기
// 3.결국 익숙한 dfs로 한번에 해결.

public class Main {
	static int N;
	static int[] cmb;
	static int[][] arr;
	static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++)
        {
            String[] tmp=br.readLine().split(" ");
            for(int j=0;j<N;j++)
            {
                if(i>j)
                {
                    arr[j][i]+=Integer.parseInt(tmp[j]);
                }
                else
                    arr[i][j]+=Integer.parseInt(tmp[j]);
            }
        }
//        for(int[] ar:arr)
//        	System.out.println(Arrays.toString(ar));
        cmb=new int[N/2];
        dfs(0,1);
        System.out.println(min);
    }
    static void dfs(int big,int len)
    {
    	if(len>=N/2)
    	{
    		int[] other=new int[N/2];
    		int idx=0;
    		int cmbIdx=0;
    		int i=0;
    		while (idx<N/2)
    		{
    			if(cmb[cmbIdx]>i)
    			{
    				other[idx++]=i;
    			}
    			else if(cmb[cmbIdx]==i)
    			{
    				cmbIdx++;
    			}
    			i++;
    			if(cmbIdx==N/2)
    			{
    				for(int j=cmb[cmbIdx-1]+1;j<N;j++)
    				{
    					//System.out.println(idx+" "+j+Arrays.toString(other));
    					other[idx++]=j;
    				}
    				break;
    			}
    		}
    		int res=Math.abs(getSum(cmb)-getSum(other));
//    		System.out.println(Arrays.toString(cmb)+" "+Arrays.toString(other));
//    		System.out.println(res);
    		if(res<min) {
    			min=res;
    		}
    		return;
    	}
    	for(int i=big+1;i<N;i++)
    	{
    		cmb[len]=i;
    		//System.out.println(Arrays.toString(cmb));
    		dfs(i,len+1);
    	}
    }
    static int getSum(int[] cmb)
    {
    	int res=0;
    	for(int i=cmb.length-1;i>0;i--)
    	{
    		for(int j=0;j<i;j++)
    		{
    			res+=arr[cmb[j]][cmb[i]];
    		}
    	}
    	return res;
    }
}
