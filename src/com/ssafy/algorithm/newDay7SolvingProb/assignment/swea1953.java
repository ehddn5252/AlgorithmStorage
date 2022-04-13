package com.ssafy.algorithm.newDay7SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea1953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum,R,C, time;
    static int[][] map, d = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        // N M R C L
        for(int testCaseIndex = 1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            rowNum = Integer.parseInt(s[0]); // 세로 크기
            colNum = Integer.parseInt(s[1]); // 가로 크기
            R = Integer.parseInt(s[2]); // 탈주범 Row
            C = Integer.parseInt(s[3]); // 탈주범 Col
            time = Integer.parseInt(s[4]);
            map = new int[rowNum][colNum];
            visit = new boolean[rowNum][colNum];

            for(int i = 0; i< rowNum; ++i){
                s = br.readLine().split(" ");
                for(int j = 0; j< colNum; ++j){
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }
            // 맵 세팅
            mainLogic();
            int ans=0;
            for(int i=0;i<rowNum;++i){
                for(int j=0;j<colNum;++j){
                    if(visit[i][j]){
                        ans++;
                    }
                }
            }
            System.out.println("#"+testCaseIndex+" "+ans);
        }
    }


    /*
    파이프마다 갈 수 있는 곳이 한정되어 있고, 그것을 판단해서 분기해야 한다.
    처음 위치에서부터 다른 곳으로 BFS 를 사용해서 풀면 될 듯
     */
    private static void mainLogic() {
        Queue<Pos> q = new LinkedList<Pos>();
        q.offer(new Pos(R,C,0));

        while(!q.isEmpty()){
            Pos polled = q.poll();
            visit[polled.i][polled.j]=true;
            if (polled.time== time-1) continue;
            // 1 : 상하좌우
            // 2 : 상 하
            // 3 : 좌우
            // 4 : 상 우
            // 5 : 하 우
            // 6 : 하 좌
            // 7 : 상 좌
            for(int i=0;i<4;++i){
                // d = {{1,0},{-1,0},{0,1},{0,-1}}; 
                // i 에 따른 next 움직이는 위치 0: 하, 1: 상, 2: 우, 3: 좌
                // 여기에서 polled.i의 타입을 확인한다. 움직일 수 있는 방향 설정
                if(map[polled.i][polled.j]==2) if (i==2 || i ==3) continue;
                if(map[polled.i][polled.j]==3) if (i==0 || i ==1) continue;
                if(map[polled.i][polled.j]==4) if (i==0 || i ==3) continue;
                if(map[polled.i][polled.j]==5) if (i==1 || i ==3) continue;
                if(map[polled.i][polled.j]==6) if (i==1 || i ==2) continue;
                if(map[polled.i][polled.j]==7) if (i==0 || i ==2) continue;

                int nextI = polled.i+d[i][0];
                int nextJ = polled.j+d[i][1];

                if(nextI>=0 && nextI<rowNum && nextJ >=0 && nextJ <colNum){
                    if(!visit[nextI][nextJ]){
                        // i 에 따른 next 움직이는 위치 0: 하, 1: 상, 2: 우, 3: 좌
                        // 1 : 상하좌우
                        // 2 : 상 하
                        // 3 : 좌우
                        // 4 : 상 우
                        // 5 : 하 우
                        // 6 : 하 좌
                        // 7 : 상 좌
                        if(i==0){
                            if(map[nextI][nextJ]==1 ||map[nextI][nextJ]==2 || map[nextI][nextJ]==4 || map[nextI][nextJ]==7){
                                q.offer(new Pos(nextI,nextJ,polled.time+1));
                            }
                        }
                        else if(i==1){
                            if(map[nextI][nextJ]==1 || map[nextI][nextJ]==2 || map[nextI][nextJ]==5 || map[nextI][nextJ]==6){
                                q.offer(new Pos(nextI,nextJ,polled.time+1));
                            }
                        }
                        else if(i==2){
                            if(map[nextI][nextJ]==1 || map[nextI][nextJ]==3 || map[nextI][nextJ]==6 || map[nextI][nextJ]==7){
                                q.offer(new Pos(nextI,nextJ,polled.time+1));
                            }
                        }
                        else{
                            if(map[nextI][nextJ]==1 || map[nextI][nextJ]==3 || map[nextI][nextJ]==4 || map[nextI][nextJ]==5){
                                q.offer(new Pos(nextI,nextJ,polled.time+1));
                            }
                        }

                    }

                }
            }
        }
    }

    static class Pos{
        int i;
        int j;
        int time;

        public Pos(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

}
