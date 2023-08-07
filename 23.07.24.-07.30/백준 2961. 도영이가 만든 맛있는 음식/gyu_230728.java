import java.util.Arrays;
import java.util.Scanner;
// 입력 후
// 함수에 들어가 index값이 n값 보다 작은지 체크 후 만약 같거나 크다면 mul, sum값이 변동이 있었는지 확인을 한다.
// 변동이 있었다면 최소값을 구하고 끝낸다.
// index값이 n 값보다 작다면, 현재 mul,sum 값에 각각 현재 index값을 더해주고 곱해서 다시 1번으로 돌아간다.
// 그리고 mul,sum 값에 변동을 주지 않고 현재 index 값만 더해서 1번으로 돌아간다.
class Solution
{		
	static int n;
	static int[][] arr;
	static int min;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		min = Integer.MAX_VALUE;
		
		n = sc.nextInt();
		arr = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		find(0,1,0);
		System.out.println(min);
	}
	
	static void find(int index, int mul, int sum) {
		if(index == n)
		{
			if (mul != 1 && sum != 0) {
				int res = Math.abs(mul - sum);
				min = Math.min(min, res);
			}
			return ;
		}
		find(index + 1, mul * arr[index][0], sum + arr[index][1]);
		find(index + 1, mul, sum);
	}
}
