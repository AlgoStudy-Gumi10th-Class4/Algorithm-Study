import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();				// 시험장 개수
        int[] arr = new int[n];				// 각 시험장 응시자 수
        for(int i=0;i<n;i++)
        	arr[i] = sc.nextInt();
        int manager = sc.nextInt();			// 총감독관이 응시할 수 있는 사람 수
        int assistant = sc.nextInt();		// 부감독관이 응시할 수 있는 사람 수
        long total = 0;						// 총 감독관 수
        
        for(int i=0;i<n;i++)				// 시험장 개수만큼 반복한다.
        {
        	arr[i] -= manager;				// 총감독관은 오직 1명이기 때문에 가장 먼저 빼주고 시작한다.
        	total++;						// 총감독관이 들어갔으니 감독관 수를 증가 시킨다.
        	if(arr[i] > 0)					// 만약 총감독관이 들어갔는데 응시해야되는 사람 수 가 있을 경우
        	{
        		total += (arr[i] / assistant);		// 나누기로 부감독관 수를 가져온다.
        		arr[i] %= assistant;				// 나누고 나머지가 있다면 부감독관이 감시할 수 있는 사람 수보다는 적기 때문에
        		if (arr[i] != 0)					// 감독관 수를 증가 시키고 끝낸다.
        			total++;
        	}
        }
        System.out.println(total);
    }
}


// 저번에 푼 코드이다.
// 내가 했지만 두 코드가 조금씩 다르다.
// 
/*
import java.util.Arrays;
import java.util.Scanner;

class Main
{		
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int mas = sc.nextInt();
		int sub = sc.nextInt();
		sc.close();
		long min = 0;
		
		for(int i=0;i<n;i++)
		{
			if (arr[i] > 0)
			{
				arr[i] -= mas;
				min++;
				if (arr[i] > 0)
				{
					min += (arr[i] / sub);
					if(arr[i] % sub != 0)
						min++;
				}
			}
		}
		System.out.println(min);
		
	}	
}
*/
