package com.ssafy.algorithm.newDay11WebXPractice3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis(); //시작하는 시점 계산

        int computerNum = Integer.parseInt(br.readLine());
        visit = new boolean[computerNum];
        visit[0] = true;
        int edgeNum = Integer.parseInt(br.readLine());
        map= new int[computerNum][computerNum];
        for(int i=0;i<edgeNum;++i){
            String[] s = br.readLine().split(" ");
            map[iToS(s[0])][iToS(s[1])]=1;
            map[iToS(s[1])][iToS(s[0])]=1;
        }
        BFS();

        int ans=0;
        for(int i=1;i<visit.length;++i){
            if(visit[i]){
                ans+=1;
            }
        }
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println((end-start));
        System.out.println(ans);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int polled = q.poll();
            for(int i=0;i<map[0].length;++i){
                if (!visit[i] && map[polled][i]==1){
                    visit[i]=true;
                    q.offer(i);
                }
            }
        }
    }


    static int iToS(String s){
        return Integer.parseInt(s)-1;
    }
}
