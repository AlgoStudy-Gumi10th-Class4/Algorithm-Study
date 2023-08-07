import java.io.*;
import java.util.Arrays;
//8:10
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nClass= Integer.parseInt(br.readLine());
        int[] classes=new int[nClass];

        String[] tmp=br.readLine().split(" ");
        for(int i=0;i<nClass;i++)
        {
            classes[i]=Integer.parseInt(tmp[i]);
        }

        tmp=br.readLine().split(" ");
        int b=Integer.parseInt(tmp[0]);
        int c=Integer.parseInt(tmp[1]);

        long res=0;
        for(int i=0;i<nClass;i++)
        {
            int num=classes[i]-b;
            if(num<0)
            {
                num=0;
            }
            res+=num/c+(num%c==0?1:2);
        }
        System.out.println(res);
    }
}
//최대 결과 1,000,000,000,000
