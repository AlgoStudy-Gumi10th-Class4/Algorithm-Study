import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = bf.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        arr = new int[n];
        sp = bf.readLine().split(" ");
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(sp[i]);
        Arrays.sort(arr);
        dfs(0,0,new int[m]);
        bf.close();
        bw.flush();
        bw.close();

    }
    static void dfs(int index, int size, int[] temp) throws IOException{

        if (size == m){
            for(int i=0;i<m;i++)
                bw.write(String.valueOf(temp[i]) + " ");
            bw.write("\n");
            return ;
        }
        if (index == n)
            return;
        for(int i=0;i<n;i++){
            temp[size] = arr[i];
            if (size == 0 || temp[size-1] <= arr[i])
                dfs(index + 1, size + 1, temp);
        }
    }
}

