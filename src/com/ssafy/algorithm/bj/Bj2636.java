package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj2636 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum,time;
    static int[][] map;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static Queue<int[]> q = new LinkedList<int[]>();
    static List<Integer> l = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        map = new int[rowNum][colNum];
        // 가장자리에 있는 것들만 먼저 없어진다. 이걸 어떻게 찾나?
        // 왼쪽끝에
        for(int i=0;i<rowNum;++i){
            s = br.readLine().split(" ");
            for(int j=0;j<colNum;++j){
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j]==1){
                    if(isOutside(i,j)) q.offer(new int[]{i,j,1});
                }
            }
        }
        BFS();
        System.out.println(l.get(l.size()-1));
        System.out.println(l.size());
    }



    static Boolean isOutside(int nextI, int nextJ){
        // 1이라면 주변에 치즈가 있는 지 확인해야 한다.
        boolean ret = true;
        int count = 0;
        if(nextI ==rowNum-1 || nextJ ==colNum-1){
            return false;
        }
        // 현 위치 기준으로 위쪽으로 쭉 확인한다.
        if(nextJ +1<colNum) {
            for (int i = nextJ + 1; i < colNum; ++i) {
                if (map[nextI][i] == 1) {
                    count += 1;
                    break;
                }
            }
        }

        if(nextJ >0) {
            for (int i = nextJ - 1; i >= 0; --i) {
                if (map[nextI][i] == 1) {
                    count += 1;
                    break;
                }
            }
        }
        if(nextI +1<rowNum) {
            for (int i = nextI + 1; i < rowNum; ++i) {
                if (map[i][nextJ] == 1) {
                    count += 1;
                    break;
                }
            }
        }

        if(nextI >0) {
            for (int i = nextI - 1; i >= 0; --i) {
                if (map[i][nextJ] == 1) {
                    count += 1;
                    break;
                }
            }
        }
        System.out.println(" nextI:"+ nextI + " nextJ:" + nextJ);
        System.out.println(count);
        if(count==4) ret=false;
        return ret;
    }

    static void BFS(){

        while(!q.isEmpty()){
            int[] position = q.poll();
            if(position[2]>l.size()) l.add(1);
            else {
                // 시간별 치즈의 개수
                int tmp = l.get(position[2]-1);
                l.set(position[2]-1,tmp+1);
            }

            for(int i=0;i<4;++i){
                int nextI = d[i][0]+position[0];
                int nextJ = d[i][1]+position[1];
                if(nextJ>=0 && nextJ<colNum && nextI >=0 && nextI <rowNum){
                    if(map[nextI][nextJ]==1){
                        if(isOutside(nextI,nextJ)){
                            map[nextI][nextJ]=0;
                            q.offer(new int[]{nextI,nextJ,position[2]+1});
                        }
                    }
                }
            }
        }
    }
}