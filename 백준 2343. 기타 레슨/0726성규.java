/*
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
*/
// 위 코드는 시간이 너무 오래 걸려 다시 만들었다.
// cnt 값이 m 보다 크면 mid 값이 작기 때문에 start 값을 늘려간다.
// cnt 값이 m 보다 작으면 mid 값이 크기 때문에 end 값을 줄여간다.

import java.util.Arrays;
import java.util.Scanner;

class Solution
{		
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		int end = 0;
		int start = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			end += arr[i];
			start = Math.max(start, arr[i]);
		}
		sc.close();
		
		int mid, cnt, sum;
		while(start <= end)
		{
			mid = (start + end) / 2;
			cnt = 0;
			sum = 0;
			for(int i=0;i<n;i++)
			{
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			
			if (sum != 0)	cnt++;
			if (cnt > m)	start = mid + 1;
			else			end = mid - 1;
		}
		
		System.out.println(start);
	}	
}
