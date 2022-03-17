package com.ssafy.algorithm.ssTest;

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/

/*
5
3
0 0 0
0 1 -1
0 0 0
4
-3 -1 1 0
-2 0 0 3
0 0 0 0
0 0 2 0
5
0 0 -3 0 0
0 0 0 3 0
0 0 0 0 2
0 0 1 0 0
-1 0 0 -2 0
6
-1 0 0 0 0 -4
0 0 0 0 2 0
-3 -2 0 4 0 0
3 0 0 0 0 1
0 0 0 0 0 0
0 0 0 0 0 0
8
3 0 0 0 -2 0 0 0
0 0 0 0 -4 0 0 0
0 0 0 0 0 0 0 0
0 0 -1 0 0 0 0 0
0 -3 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 2 4 0 1 0 0
0 0 0 0 0 0 0 0

#1 3
#2 13
#3 18
#4 22
#5 22
 */

class prob2
{
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] visit;
    static int monsterNum,allCaseNum;
    static int[] allCaseArray,allCaseArrayTmp;
    static ArrayList<int[]> clientMonsterPositionList = new ArrayList<int[]>();
    static int answer;
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            answer=999999;
            clientMonsterPositionList.clear();
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
                        clientMonsterPositionList.add(new int[]{i,j,map[i][j]});
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
        for(int i = 0; i< clientMonsterPositionList.size(); ++i) {
            for(int j = 0; j< clientMonsterPositionList.size(); ++j) {
                int[] info = clientMonsterPositionList.get(i);
                if(info[2]==allCaseArray[j]) {
                    sum+=Math.abs(nowPositionRow-info[0])+Math.abs(nowPositionCol-info[1]);
                    nowPositionRow = info[0];
                    nowPositionCol = info[1];
                    break;
                }
            }
        }
        if(sum<answer) {
            answer=sum;
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
            int nowIndex = Math.abs(allCaseArray[i]);
            if(clients[nowIndex] && !monsters[nowIndex]) {
                return false;
            }
        }
        return true;
    }
}
