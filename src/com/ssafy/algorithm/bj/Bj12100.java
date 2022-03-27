package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj12100 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int maxValue=0;
    static int count=0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[][] currentMap = new int[N][N];
        int[][] changedMap = new int[N][N];
        for(int i=0;i<N;++i){
            String[] s =br.readLine().split(" ");

            for(int j=0;j<N;++j){
                currentMap[i][j] = Integer.parseInt(s[j]);
                changedMap[i][j] = Integer.parseInt(s[j]);
            }
        }
        mainLogic(0,currentMap,changedMap);
        System.out.println(maxValue);
//        System.out.println(count);
    }


    // 모든 경우의 수 선택하면 될 듯
    // 위 오른쪽 아래 왼쪽 순서대로 체크를 해주고 만약에 같은 값이 붙어 있으면 *2
    // queue 자료형 만들어서 하면 될듯
    // 전역이라서 설정 다르게 해줘야 한다.
    static void mainLogic(int cnt,int[][] currentMap,int[][] changedMap){
        if(cnt==5) return;
        int[][] newBeforeMap = changedMap;
        int[][] newChangedMap, newCurrentMap=currentMap;
        for(int i=0;i<4;++i){
            newChangedMap = move(i,newCurrentMap);
            newCurrentMap = newChangedMap;
            mainLogic(cnt+1,newCurrentMap,newChangedMap);
            newCurrentMap=newBeforeMap;
        }
    }

    // 0 1 2 3 -> 위 오른쪽 아래 왼쪽
    static int[][] move(int direction, int[][] currentMap){
        int[][] changedMap=new int[N][N];
        for(int i=0;i<N;++i){
            Queue<Integer> q = new LinkedList<Integer>();
            int current=0;
            for(int j=0;j<N;++j) {
                count+=1;

                // 방향이 위나 아래면
                if (direction == 0 || direction == 2) {
                    if(j==0){
                        current=currentMap[j][i];
                        continue;
                    }

                    // 현재 값이 다음 값과 같으면 q에 넣는다.
                    if (current == currentMap[j][i] && currentMap[j][i]!=0) {
                        q.offer(currentMap[j][i] * 2);
                        current=0;
                    }

                    // 현재 값이 다음 값과 다르고 둘다 0이 아니면 현재값을 q에 넣고 최신화 한다.는다.
                    else if(current != currentMap[j][i] && currentMap[j][i]!=0 && current!=0){
                        q.offer(current);
                        current=currentMap[j][i];
                    }

                    // current는 0이면
                    else if(current==0 ){
                        current=currentMap[j][i];
                    }

                    // 방향이 오른쪽이나 왼쪽이면
                } else if (direction == 3 || direction == 1) {
                    if(j==0){
                        current=currentMap[i][j];
                        continue;
                    }
                    if (current == currentMap[i][j] && currentMap[i][j]!=0) {
                        q.offer(currentMap[i][j] * 2);
                        current=0;
                    }
                    else if(current != currentMap[i][j] && currentMap[i][j]!=0  && current!=0){
                        q.offer(current);
                        current = currentMap[i][j];
                    }
                    else if(current==0){
                        current = currentMap[i][j];
                    }
                }
                if(j==N-1 && current!=0){
                    q.offer(current);
                }
            }

            int setIndex=0;
            int size = q.size();
            while(!q.isEmpty()){
                int polled = q.poll();
                if(polled>maxValue) maxValue=polled;
                // N - q.size + setIndex
                if(direction==0) changedMap[setIndex][i]=polled;
                else if(direction==1) changedMap[i][N-size+setIndex]=polled;
                else if(direction==2) changedMap[N-size+setIndex][i]=polled;
                else if(direction==3) changedMap[i][setIndex]=polled;
                setIndex+=1;

            }
        }
        return changedMap;
    }
}
