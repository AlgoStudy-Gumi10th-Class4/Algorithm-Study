import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	String s = bf.readLine();
    	String[] st = s.split(" ");
    	int n = Integer.parseInt(st[0]);
    	int m = Integer.parseInt(st[1]);
    	int[] tree = new int[n];
    	s = bf.readLine();
    	st = s.split(" ");
    	bf.close();
    	
    	for(int i=0;i<st.length;i++)
    		tree[i] = Integer.parseInt(st[i]);
    	Arrays.sort(tree);
    	int start = 0;
    	int end = tree[n-1];
    	int mid = 0;
    	long cnt = 0;
    	while (start <= end) {
    		mid = (start + end) / 2;
    		cnt = 0;
    		for(int i=0;i<n;i++) {
    			if (tree[i] - mid > 0)
    				cnt += (tree[i] - mid);
    		}
    		if (cnt >= m)
    			start = mid + 1;
    		else
    			end = mid - 1;
    	}
    	System.out.println(end);
	}

}