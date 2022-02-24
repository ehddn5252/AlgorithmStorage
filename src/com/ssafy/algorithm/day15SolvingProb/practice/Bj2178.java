package com.ssafy.algorithm.day15SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2178 {
    static int rowNum, colNum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit;
    static int result=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        map=new int[rowNum][colNum];
        visit = new boolean[rowNum][colNum];
        for(int i=0;i<rowNum;++i){
            String s1 = br.readLine();
            for(int j=0;j<colNum;++j){
                map[i][j] = s1.charAt(j)-'0';
            }
        }
        BFS();
        System.out.println(result);
    }

    private static void BFS(){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0,1});
        visit[0][0]=true;
        while(!q.isEmpty()){
            int[] popped = q.poll();
            if(popped[0]==rowNum-1 && popped[1]==colNum-1){
                if(result>popped[2]){
                    result = popped[2];
                }
                continue;
            }
            for(int i=0;i<4;++i){
                int nextI=popped[0]+d[i][0];
                int nextJ=popped[1]+d[i][1];
                if(nextI>=0 && nextI <rowNum && nextJ>=0 && nextJ < colNum){
                    if(visit[nextI][nextJ]) continue;
                    if(map[nextI][nextJ]==1){
                        // 여기에 visit 을 true 로 해두지 않으면 메모리 초과가 난다.
                        // 왜냐하면 여기서 for 문이 또 4번 도는데, 그것 들어간 것에는 visit = true가 적용되지 않기 때문.
                        visit[nextI][nextJ]=true;
                        q.offer(new int[]{nextI,nextJ,popped[2]+1});
                    }
                }
            }
        }

    }
}
