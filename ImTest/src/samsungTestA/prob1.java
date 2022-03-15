package samsungTestA;
import java.util.Scanner;
import java.util.*;
import java.io.*;
/*
 사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
 이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class prob1
{
  static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  
  static int N;
  static int door1Num;
  static int door1personNum;
  static int door2Num;
  static int door2personNum;
  static int door3Num;
  static int door3personNum;
  static int[][] info;

	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		
      ArrayList<int[]> l = new ArrayList<int[]>();
		int T =  Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{

			// input
			// N은낚시터 자리 수
			N =  Integer.parseInt(br.readLine());
			
			// 인덱스 설정을 위해서 각 문 위치에 -1을 해준다.
			String[] s1 = br.readLine().split(" ");
			int max=0;
			door1Num = Integer.parseInt(s1[0])-1;
			//가장 작은 값을 door1로 가장 큰 값을 door3으로 설정
			int min=999;
			door1personNum = Integer.parseInt(s1[1]);
			if (door1Num>max) {
				max=door1Num;
			}
			if(door1Num<min) {
				min=door1Num;
			}
			s1 = br.readLine().split(" ");
			door2Num = Integer.parseInt(s1[0])-1;
			door2personNum = Integer.parseInt(s1[1]);
			if (door2Num>max) {
				max=door2Num;
			}
			if(door2Num<min) {
				min=door2Num;
			}
			s1 = br.readLine().split(" ");
			door3Num = Integer.parseInt(s1[0])-1;
			door3personNum = Integer.parseInt(s1[1]);
			if (door3Num>max) {
				max=door3Num;
			}
			if(door3Num<min) {
				min=door3Num;
			}
			if(min==door1Num && max == door2Num) {
				info =new int[][]{{door1Num,door1personNum},{door3Num,door3personNum},{door2Num,door2personNum}};
			}
			else if(min==door1Num && max == door3Num) {
				info =new int[][]{{door1Num,door1personNum},{door2Num,door2personNum},{door3Num,door3personNum}};
			}
			else if(min==door2Num && max == door1Num) {
				info =new int[][]{{door2Num,door2personNum},{door3Num,door3personNum},{door1Num,door1personNum}};
			}
			else if(min==door2Num && max == door3Num) {
				info =new int[][]{{door2Num,door2personNum},{door1Num,door1personNum},{door3Num,door3personNum}};			
			}
			else if(min==door3Num && max == door1Num) {
				info =new int[][]{{door3Num,door3personNum},{door2Num,door2personNum},{door1Num,door1personNum}};			
			}
			else if(min==door3Num && max == door2Num) {
				info =new int[][]{{door3Num,door3personNum},{door1Num,door1personNum},{door2Num,door2personNum}};
			}

			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case+ " "+mainLogic());
		}
	}
	static int mainLogic(){
		int answer=999999;
		int[][] cases = {{1,2,0},{1,0,2},{2,1,0},{2,0,1},{0,1,2},{0,2,1}};
		
		for(int i=0;i<cases.length;++i) {
			int[] nowCase = cases[i];
			
			for(int caseNum=0;caseNum<2;++caseNum) {
				ArrayList<Integer> L = new ArrayList<Integer>(N);
				for(int sss=0;sss<N;++sss) {
					L.add(0);
				}
				for(int j=0;j<3;++j) {
					int k=0;
					int doorNum = info[nowCase[j]][0];
					int doorPersonNum= info[nowCase[j]][1];
					while(doorPersonNum>0) {
						if(nowCase[j]==0) {
							if (doorNum -k>=0 && L.get(doorNum-k)==0) {
								L.set(doorNum-k,doorNum);
								doorPersonNum-=1;
							}
							if(doorPersonNum==0)break;
							if (doorNum+k<N && L.get(doorNum+k)==0) {
								L.set(doorNum+k,doorNum);							
								doorPersonNum-=1;
							}
						}
						
						else if(nowCase[j]==2) {
							if (doorNum+k<N && L.get(doorNum+k)==0) {
								L.set(doorNum+k,doorNum);							
								doorPersonNum-=1;
							}
							if(doorPersonNum==0)break;
							if (doorNum -k>=0 && L.get(doorNum-k)==0) {
								L.set(doorNum-k,doorNum);
								doorPersonNum-=1;
							}
						}	
						
						else if(nowCase[j]==1 && caseNum==0) {
							if (doorNum+k<N && L.get(doorNum+k)==0) {
								L.set(doorNum+k,doorNum);							
								doorPersonNum-=1;
							}
							if(doorPersonNum==0)break;
							if (doorNum -k>=0 && L.get(doorNum-k)==0) {
								L.set(doorNum-k,doorNum);
								doorPersonNum-=1;
							}
						}	
						
						else if(nowCase[j]==1 && caseNum==1) {
							if (doorNum -k>=0 && L.get(doorNum-k)==0) {
								L.set(doorNum-k,doorNum);
								doorPersonNum-=1;
							}

							if(doorPersonNum==0)break;
							
							if (doorNum+k<N && L.get(doorNum+k)==0) {
								L.set(doorNum+k,doorNum);							
								doorPersonNum-=1;
							}
						}	
						k+=1;
					}
				}
				int ll = checkLength(L);
				if(ll<answer) {
					answer=ll;
				}
			}
		}
		return answer;
	}
	
	static int checkLength(ArrayList<Integer> L) {
		int size=L.size();
		int sum=0;
		for(int i=0;i<size;++i) {
			int doorN=L.get(i);
			if(doorN!=0) {
			sum+=1+Math.abs(i-doorN);
			}
		}
		return sum;
	}

}
