import java.util.*;

class Main
{	
	static int[] num;
	static int n;
	static int max;
	static int min;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] sig = new int[4];
		n = sc.nextInt();
		num = new int[n];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			num[i] = sc.nextInt();
		
		for(int i=0;i<4;i++)
			sig[i] = sc.nextInt();
		
		find(sig, 1, num[0]);
		System.out.println(max + "\n" + min);
	}
	
	static void find(int[] sig, int arr_index, int sum)
	{
		if (arr_index == n)
		{
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return ;
		}
		for(int i=0;i<4;i++)
		{
			int[] temp = sig.clone();
			if(sig[i] != 0)
			{
				
				temp[i]--;
				if (i == 0)
					find(temp, arr_index + 1, sum + num[arr_index]);
				else if (i == 1)
					find(temp, arr_index + 1, sum - num[arr_index]);
				else if (i == 2)
					find(temp, arr_index + 1, sum * num[arr_index]);
				else
					find(temp, arr_index + 1, sum / num[arr_index]);
			}
		}
		
	}
}
