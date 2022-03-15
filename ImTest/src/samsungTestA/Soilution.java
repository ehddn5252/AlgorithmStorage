package samsungTestA;/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution
{
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[] visit;
	static int monsterNum,allCaseNum;
	static int[] allCaseArray,allCaseArrayTmp;
	static ArrayList<int[]> q = new ArrayList<int[]>();
	static int answer=99999;
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

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			answer=999999;
			q.clear();
			int N = Integer.parseInt(br.readLine());
			map= new int[N][N];
			monsterNum=0;
			

			for(int i=0;i<N;++i) {
				String[] s = br.readLine().split(" ");
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(s[j]);
					if(map[i][j]>monsterNum) {
						monsterNum=map[i][j];
					}
					if(map[i][j]!=0) {
						q.add(new int[]{i,j,map[i][j]});
						
					}
				}
			}
			allCaseNum = monsterNum*2;
			allCaseArray= new int[allCaseNum];
			allCaseArrayTmp= new int[allCaseNum];
			visit = new boolean[allCaseNum];
			for(int i=0;i<monsterNum;++i) {
				allCaseArray[i]=i+1;
				allCaseArray[monsterNum+i]=-(i+1);

				allCaseArrayTmp[i]=i+1;
				allCaseArrayTmp[monsterNum+i]=-(i+1);
			}
			mainLogic();
			
			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case+" "+ answer);
		}

	}
	static void mainLogic(){
		permu(0);
		
	}
	
	static void permu(int cnt) {
		if(cnt==allCaseNum) {
			if(check()) {
				find();
			}
			return;
		}
		for(int i=0;i<allCaseNum;++i) {
			if(visit[i])continue;
			// 몬스터보다 고객에 먼저 가는 경우
			visit[i]=true;

			allCaseArray[cnt]=allCaseArrayTmp[i];
			permu(cnt+1);
			visit[i]=false;
		}
	}
	
	static void find() {
		int sum=0;
		int nowPositionRow=0;
		int nowPositionCol=0;
		for(int i=0;i<q.size();++i) {
			for(int j=0;j<q.size();++j) {
				int[] info = q.get(i);
				if(info[2]==allCaseArray[j]) {
					sum+=Math.abs(nowPositionRow-info[0])+Math.abs(nowPositionCol-info[1]);
					nowPositionRow = info[0];
					nowPositionCol = info[1];
					break;
				}
			}
			if(sum<answer) {
				answer=sum;
			}
		}
	}
	static boolean check() {
		boolean[] monsters=new boolean[monsterNum+1];
		boolean[] clients=new boolean[monsterNum+1];
		for(int i=0;i<allCaseArray.length;++i) {
			if(allCaseArray[i]>0) {
				monsters[allCaseArray[i]]=true;
			}
			else if(allCaseArray[i]<0) {
				clients[-allCaseArray[i]]=true;
			}
			if(clients[i]==true && monsters[i]==false) {
				return false;
			}
		}
		return true;
	}
}
