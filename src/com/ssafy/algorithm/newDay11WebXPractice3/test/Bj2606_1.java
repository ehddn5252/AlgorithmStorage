package com.ssafy.algorithm.newDay11WebXPractice3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

// linkedList 버전
public class Bj2606_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<LinkedList<Integer>> map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis(); //시작하는 시점 계산
        int computerNum = Integer.parseInt(br.readLine());
        visit = new boolean[computerNum];
        visit[0] = true;
        int edgeNum = Integer.parseInt(br.readLine());
        map = new ArrayList<LinkedList<Integer>>(computerNum);
        for(int i=0;i<computerNum;++i){
            map.add(new LinkedList<Integer>());
        }
        for(int i=0;i<edgeNum;++i) {
            String[] s = br.readLine().split(" ");
            LinkedList l = map.get(iToS(s[0]));
            l.add(iToS(s[1]));
            map.set(iToS(s[0]),l);

            l = map.get(iToS(s[1]));
            l.add(iToS(s[0]));
            map.set(iToS(s[1]),l);
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
            for(int i=0;i<map.get(polled).size();++i){
                if (!visit[map.get(polled).get(i)]){
                    visit[map.get(polled).get(i)]=true;
                    q.offer(map.get(polled).get(i));
                }
            }
        }
    }

    static int iToS(String s){
        return Integer.parseInt(s)-1;
    }
}
