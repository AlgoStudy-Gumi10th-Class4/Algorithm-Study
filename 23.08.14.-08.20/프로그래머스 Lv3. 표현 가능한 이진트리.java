// 익숙하지않은 유형이라 생각보다 이해하는 데 시간이 꽤 오래 걸림.
// 놓치기 쉬운 테케 맨밑에 첨부
import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int n=0;n<numbers.length;n++)
        {
            String bin=Long.toBinaryString(numbers[n]);
            //System.out.println(bin);
            int len=2;
            while(len-1<bin.length())
            {
                len*=2;
            }
            len--;
            //System.out.println(len);
            int[] tree=new int[len];
            for(int i=0;i<bin.length();i++)
            {
                tree[len-1-i]=bin.charAt(bin.length()-1-i)-'0';
            }
            //System.out.println(Arrays.toString(tree));
            int res=checkTree(tree,0,len-1);
            answer[n]=(res==-1)?0:1;
        }
        return answer;
    }
    static int checkTree(int[] tree,int start,int end)
    {
        //System.out.println(start+" "+end);
        if(start==end)
        {
            return tree[start];
        }
        int mid=(start+end)/2;
        int left=checkTree(tree,start,mid-1);
        int right=checkTree(tree,mid+1,end);
        if(left==-1||right==-1)
        {
            return -1;
        }
        if(tree[mid]==0&&left+right>0)
        {
            return -1;
        }
        return tree[mid];
    }
}
//0001111(15) -> 1(가능)

