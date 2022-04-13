package com.ssafy.algorithm.newDay11WebXPractice3.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA4013 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int magnet[][];
    static final int MAGNET_NUM = 4;
    static final int CONVEX_POINT_NUM = 8;

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        magnet = new int[MAGNET_NUM][CONVEX_POINT_NUM];
        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {
            int commandNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < MAGNET_NUM; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < CONVEX_POINT_NUM; ++j) {
                    magnet[i][j] = Integer.parseInt(s[j]);
                }
            }
            for (int i = 0; i < commandNum; ++i) {
                String[] s = br.readLine().split(" ");
                int magnetNum = Integer.parseInt(s[0]) - 1;
                int direction = Integer.parseInt(s[1]);
                BFS(magnetNum, direction);
            }
//            for(int i=0;i<MAGNET_NUM;++i){
//                for(int j=0;j<CONVEX_POINT_NUM;++j){
//                    System.out.print(magnet[i][j]+" ");
//                }
//                System.out.println();
//            }
            System.out.println("#"+testCaseIndex+" "+getAns());
        }
    }



    private static void BFS(int magnetNum, int direction) {
        final int OFFSET = 1;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{magnetNum, direction});
        int[] visit = {0,0,0,0};
        visit[magnetNum] = direction;
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            // 오른쪽에 있는 자석을 방문하지 않은 경우
            if (popped[0] + OFFSET < 4 && visit[popped[0] + OFFSET] == 0) {
                if (magnet[popped[0]][2] != magnet[popped[0] + OFFSET][6]) {
                    visit[popped[0] + OFFSET] = -popped[1];
                    q.offer(new int[]{popped[0] + OFFSET, -popped[1]});
                }
            }
            if (popped[0] - OFFSET >= 0 && visit[popped[0] - OFFSET] == 0) {
                if (magnet[popped[0]][6] != magnet[popped[0] - OFFSET][2]) {
                    visit[popped[0] - OFFSET] = -popped[1];
                    q.offer(new int[]{popped[0] - OFFSET, -popped[1]});
                }
            }
        }
        // 회전 확인
//        System.out.println(visit[0]+" "+ visit[1] +" "+ visit[2]+" "+visit[3]);
        for (int i = 0; i < MAGNET_NUM; ++i) {
            if (visit[i] != 0) {
                rotate(i, visit[i]);
            }
        }
    }


    private static void rotate(int num, int direction) {
        // direction 이 1이면 시계방향
        if (direction == 1) {
            int tmp = magnet[num][7];
            for (int i = 7; i > 0; --i) {
                magnet[num][i] = magnet[num][i - 1];
            }
            magnet[num][0] = tmp;
        }

        // 반 시계로 돌린다.
        else if(direction==-1) {
            int tmp = magnet[num][0];
            for (int i = 0; i < 7; ++i) {
                magnet[num][i] = magnet[num][i + 1];
            }
            magnet[num][7] = tmp;
        }
    }

    private static int getAns(){
        int ans=0;
        for(int i=0;i<MAGNET_NUM;++i){
            if(magnet[i][0]==1){
                if(i==0){
                    ans+=1;
                }
                else if(i==1){
                    ans+=2;
                }
                else if(i==2){
                    ans+=4;
                }
                else if(i==3){
                    ans+=8;
                }
            }
        }
        return ans;
    }


}
