import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int i=N/5;
		int res=-1;
		for(;i>=0;i--)
		{
			int left=N-i*5;
			if(left%3==0)
			{
				res=i+(left/3);
				break;
			}
		}
		System.out.println(res);
	}

}

