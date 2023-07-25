import java.util.*;

class Solution
{	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = -1;
		int cnt = n / 5;
		
		while (cnt >= 0)
		{
			int temp = n - (5 * cnt);
			
			if(temp == 0)
			{
				min = cnt;
				break;
			}
			
			if(temp % 3 == 0)
			{
				min = cnt + (temp / 3);
				break;
			}
			cnt--;
		}
		System.out.println(min);
	}
}
