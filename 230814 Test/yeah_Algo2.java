import java.io.*;
import java.util.*;

public class Algo2 {
	public static void main(String[] args) throws IOException{
		//BufferedReader로 빠른 입력 받기
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 갯수 = T
		int T=Integer.parseInt(br.readLine());
		//테스트케이스 실행
		for(int t=1;t<=T;t++)
		{
			//공간의 크기 N 입력받기
			int N = Integer.parseInt(br.readLine());
			//이동할 수 있는 칸의 개수 = 결과
			int res=0;
			//String[][] 형태로 현재 map 배열 입력받기
			//char이 더욱 효율적일 수 있지만 입력값 그대로 사용하는 것이 더 편할 것 같아 String형태 사용
			String[][] arr=new String[N][];
			
			//N개의 String[]에 입력값 넣어주기
			for(int i=0;i<N;i++)
			{
				arr[i]=br.readLine().split(" ");
			}
			//arr 배열 행을 순회하며 A,B,C인 자리 찾기
			for(int i=0;i<N;i++)
			{
				//arr 배열 열을 순회하며 A,B,C인 자리 찾기
				for(int j=0;j<N;j++)
				{
					//string switch문으로 비교할 경우 자동으로 equals 비교 해줌
					switch(arr[i][j])
					{
					//A인 경우 오른쪽으로만 조회
					case "A":
						//현재 열에서 한칸 떨어진 곳에서 시작하여 배열 끝까지 조회
						for(int k=j+1;k<N;k++)
						{
							//S인 경우 이동가능
							if(arr[i][k].equals("S"))
							{
								//이동가능 칸 수 +1
								res++;
							}
							//W,A,B,C인 경우 이동불가
							else
							{
								//로봇이 멈춘다.
								break;
							}
						}
						//스위치문 나가기
						break;
					//B인 경우 상하 조회
					case "B":
						//현재 행에서 위로 한칸 떨어진 곳에서 시작하여 배열 맨위까지 조회
						for(int k=i-1;k>=0;k--)
						{
							//S인 경우 이동가능
							if(arr[k][j].equals("S"))
							{
								//이동가능 칸 수 +1
								res++;
							}
							//W,A,B,C인 경우 이동불가
							else
							{
								//로봇이 멈춘다.
								break;
							}
						}
						//현재 행에서 아래로 한칸 떨어진 곳에서 시작하여 배열 맨밑까지 조회
						for(int k=i+1;k<N;k++)
						{
							//S인 경우 이동가능
							if(arr[k][j].equals("S"))
							{
								//이동가능 칸 수 +1
								res++;
							}
							//W,A,B,C인 경우 이동불가
							else
							{
								//로봇이 멈춘다.
								break;
							}
						}
						//스위치문 나가기
						break;
					//C인 경우 상하 조회
					case "C":
						//좌상,우상,좌하,우하 배열로 미리 선언
						//y(행)
						int[] dy= {-1,-1,1,1};
						//x(열)
						int[] dx= {-1,1,-1,1};
						//4방향 탐색
						for(int dir=0;dir<4;dir++)
						{
							//탐색할 좌표 정해주기
							//행 : 로봇 시작 위치에서 dy방향으로 한칸
							int ty=i+dy[dir];
							//열 : 로봇 시작 위치에서 dx방향으로 한칸
							int tx=j+dx[dir];
							//반복문 실행
							while(true)
							{
								// tx ty가 map의 크기를 벗어나지 않으면서 값이 S이면 이동가능
								if(tx>=0&&ty>=0&&tx<N&&ty<N&&arr[ty][tx].equals("S"))
								{
									//이동가능 칸 수 +1
									res++;
									//로봇 현재 위치에서 dy방향으로 한칸
									ty+=dy[dir];
									//로봇 현재 위치에서 dx방향으로 한칸
									tx+=dx[dir];
								}
								//이동불가한 경우
								else
								{
									//로봇멈추기
									break;
								}
										
							}
						}
						//스위치문 나가기
						break;
					}
				}
			}
			//총 결과 출력
			System.out.println("#"+t+" "+res);
		}
	}
}
