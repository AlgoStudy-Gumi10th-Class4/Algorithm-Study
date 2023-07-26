import java.util.Arrays;
import java.util.Scanner;
// 블루레이 개수가 제한되어 있으므로, 입력 받아 온 개수를 사용해 평균을 구한다.
// 평균을 기준으로 sum배열에 arr 값을 순서대로 입력해가며 만약 제한된 블루레이 개수를 넘어가면 평균 값을 더해가며 반복한다.
// 최소 값(평균 값)이 계속 더해지면서 반복하기 때문에 만약 arr 값이 다 들어간다면 그 평균 값이 최소 값이기 때문에 그 즉시
// while문을 빠져나와 끝낸다.
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
