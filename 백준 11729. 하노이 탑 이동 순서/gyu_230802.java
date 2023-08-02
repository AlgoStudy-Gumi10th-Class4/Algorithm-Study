import java.util.Scanner;
// 재귀 어렵다..
// 도저히 모르겠어서 인터넷 찾아서 해결한 문제이다.
// 이게 왜??
// 직접 메모장에 출력해보니 된다..
// 신가하다.
public class Main {
	static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hanoi(n,1,2,3);								// start = 1, mid = 2, to = 3으로 시작한다.
        System.out.println(cnt + "\n" + sb);		// 이동 횟수와 저장해둔 String을 출력
    }
    static void Hanoi(int n, int start, int mid, int to) {
    	if (n == 1) {								// n이 1이면 가장 처음이기 때문에 현재 위치를 저장하고 돌아간다.
    		sb.append(start + " " + to + "\n");
    		cnt++;
    		return ;
    	}
    	Hanoi(n - 1, start, to, mid);				// A-> B로 옮길 때, (start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
    	sb.append(start + " " + to + "\n");			// A-> C로 옮길 때, (start 지점의 N번째 원판을 to지점으로 옮긴다.)
    	cnt++;	
    	Hanoi(n - 1, mid, start, to);				// B-> C로 옮길 때, (mid 지점의 n-1개의 원판을 to 지점으로 옮긴다.)
    }
}
