package samsungTestA;/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
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
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� sample_input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� sample_input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		*/
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		*/

		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.
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
			// ���ͺ��� ���� ���� ���� ���
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
