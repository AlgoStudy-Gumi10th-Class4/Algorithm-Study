import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        	arr[i] = sc.nextInt();
        int manager = sc.nextInt();
        int assistant = sc.nextInt();
        long total = 0;
        
        for(int i=0;i<n;i++)
        {
        	arr[i] -= manager;
        	total++;
        	if(arr[i] > 0)
        	{
        		total += (arr[i] / assistant);
        		arr[i] %= assistant;
        		if (arr[i] != 0)
        			total++;
        	}
        }
        System.out.println(total);
    }
}
