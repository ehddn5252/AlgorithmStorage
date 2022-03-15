package samsungTestA;
import java.util.Scanner;
import java.util.*;
import java.io.*;
/*
 ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
 �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
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
		
      ArrayList<int[]> l = new ArrayList<int[]>();
		int T =  Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{

			// input
			// N�������� �ڸ� ��
			N =  Integer.parseInt(br.readLine());
			
			// �ε��� ������ ���ؼ� �� �� ��ġ�� -1�� ���ش�.
			String[] s1 = br.readLine().split(" ");
			int max=0;
			door1Num = Integer.parseInt(s1[0])-1;
			//���� ���� ���� door1�� ���� ū ���� door3���� ����
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

			// ǥ�����(ȭ��)���� ����� ����մϴ�.
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
