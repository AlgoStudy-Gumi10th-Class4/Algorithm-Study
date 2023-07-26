import java.util.Arrays;
import java.util.Scanner;

class Solution
{	
	static int avg;
	static int[] arr;
	static int[] sum;
	static int n;
	static int m;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		sum = new int[m];
		avg = 0;
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			avg += arr[i];
		}
		avg /= m;
		sc.close();
		find();
		
		System.out.println(avg);
	}
	
	static void find() {
		int i = 0;
		int j;
		while(true)
		{
			j = 0;
			Arrays.fill(sum, 0);
			for(i=0;i<n;i++)
			{
				if(sum[j] + arr[i] > avg)
				{
					i--;
					if (j >= m-1)
					{
						break;
					}
					j++;
				}
				else
					sum[j] += arr[i];
			}
			if (i >= n-1)
				break;
			avg++;
		}
	}
	
}