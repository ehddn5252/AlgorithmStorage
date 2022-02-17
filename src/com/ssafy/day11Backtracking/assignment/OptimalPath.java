package com.ssafy.day11Backtracking.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalPath {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] endLocation, startLocation;
    static int[][] VIPs;
    static boolean[] isVisited;
    static int[] visitOrder, inputOrder;
    static int minDistance=99999;
    public static void main(String[] args) throws IOException {
        int testCaseNum;
        testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 1; testCaseIndex < testCaseNum+1; ++testCaseIndex) {
            int customerNum = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            endLocation = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
            startLocation = new int[]{Integer.parseInt(s[2]), Integer.parseInt(s[3])};
            VIPs = new int[customerNum][2];
            isVisited = new boolean[customerNum];
            visitOrder = new int[customerNum];
            inputOrder = new int[customerNum];

            for(int i=0;i<visitOrder.length;++i){
                inputOrder[i]=i;
            }
            int j=0;
            for (int i = 0; i < customerNum; i ++) {
                VIPs[i] = new int[]{Integer.parseInt(s[4 + j]), Integer.parseInt(s[4 + j + 1])};
                j+=2;
            }
            permutationBacktracking(0, startLocation[0],startLocation[1],0);
            System.out.print("#"+testCaseIndex+" ");
            System.out.println(minDistance);
            minDistance = 99999;
            //printInput();
        }
    }

    // 회사에서 시작해서 고객들을 다 만나고 우리집으로 돌아간다.
    // 고객의 수 n은 2 ~ 10 명이다.
    // 순열로 모든 경우의수 돌려보면 된다.
    static void permutationBacktracking(int cnt, int currentLocationX, int currentLocationY, int currentDistance){
        if(currentDistance>=minDistance)return;
        if (cnt==VIPs.length){
            currentDistance += Math.abs(currentLocationX-endLocation[0]) +  Math.abs(currentLocationY -endLocation[1]);
            if(currentDistance<minDistance){
                minDistance = currentDistance;
            }
            return;
        }

        for(int i=0;i<VIPs.length;++i){
            if(isVisited[i])continue;
            int d = Math.abs(currentLocationX-VIPs[i][0]) +  Math.abs(currentLocationY -VIPs[i][1]);
            isVisited[i] = true;
            permutationBacktracking(cnt+1,VIPs[i][0],VIPs[i][1],d+currentDistance);
            isVisited[i] = false;
        }
    }
}
