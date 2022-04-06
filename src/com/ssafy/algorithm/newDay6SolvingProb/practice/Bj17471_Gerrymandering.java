package com.ssafy.algorithm.newDay6SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj17471_Gerrymandering {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[] population;
    static boolean[] visit;
    static final int INF = 9999999;
    static int sum, ans=INF;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String[] s = br.readLine().split(" ");
        population=new int[N];
        visit=new boolean[N];
        for(int i=0;i<s.length;++i){
            population[i]=Integer.parseInt(s[i]);
            sum+=population[i];
        }
        for(int i=0;i<N;++i){
            s = br.readLine().split(" ");
            for(int j=1;j<s.length;++j){
                map[i][Integer.parseInt(s[j])-1]=1;
            }
        }
        powerSet(0,0,0);
        if(ans==INF) ans=-1;

        System.out.println(ans);
    }


    private static void powerSet(int cnt,int populationSum,int visitCount) {
        if(cnt==population.length){
            if(visitCount==0 || visitCount==population.length)return;
            if(checkConnect(visitCount)){
                int diff = Math.abs(sum-populationSum-populationSum);
                if(diff<ans){
                    ans=diff;
                }
            }
            return;
        }
            visit[cnt]=true;
            powerSet(cnt+1,populationSum+population[cnt],visitCount+1);
            visit[cnt]=false;
            powerSet(cnt+1,populationSum,visitCount);
    }


    private static boolean checkConnect(int visitCount) {
        // 각 지역구가 연결이 되어 있는 지 확인하는 함수
        // visit 으로 방문했는 지 확인
        boolean ret = true;
        HashSet<Integer> set1 = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<visit.length;++i){
            if(visit[i]){
                q.offer(i);
                set1.add(i);
                break;
            }
        }

        while(!q.isEmpty()){
            int polled = q.poll();
            // 각각이 연결되어 있는 지 확인해야 한다.
            for(int i=0;i<visit.length;++i){
                if(map[polled][i] == 1 && visit[i]){
                    if(!set1.contains(i)){
                        q.offer(i);
                        set1.add(i);
                    }
                }
            }
        }
        if(set1.size()!=visitCount) return false;

        set1 = new HashSet<>();
        q = new LinkedList<Integer>();
        for(int i=0;i<visit.length;++i){
            if(!visit[i]){
                q.offer(i);
                set1.add(i);
                break;
            }
        }

        while(!q.isEmpty()){
            int polled = q.poll();
            // 각각이 연결되어 있는 지 확인해야 한다.
            for(int i=0;i<visit.length;++i){
                if(map[polled][i] == 1 && !visit[i]){
                    if(!set1.contains(i)){
                        q.offer(i);
                        set1.add(i);
                    }
                }
            }
        }
        if(set1.size()!=visit.length-visitCount) {
            ret = false;
        }
        return ret;
    }
}
