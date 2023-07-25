import java.util.*;

class Solution
{	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int j =0;
		int min = Integer.MAX_VALUE;
		while (true)
		{
			int temp = n;
			cnt = 0;
			for(int i=0;i<j;i++)
			{
				temp -= 5;
				cnt++;
			}
			if (temp <= 0)
			{
				if (n % 5 == 0)
					min = Math.min(min, n / 5);
				break;
			}
			if(temp % 3 == 0)
				min = Math.min(min, (cnt + (temp / 3)));
			j++;
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
}
