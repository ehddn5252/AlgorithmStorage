package com.ssafy.algorithm.newDay8SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj17135_1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map, mapTmp, d = {{1,0},{-1,0},{0,1},{0,-1}};
    private static boolean[] visitComb;
    private static ArrayList<Pos> zeroList = new ArrayList<Pos>();
    private static ArrayList<Pos> combinationedList = new ArrayList<Pos>();
    private static int N,M,range;
    private static int ans;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        range = Integer.parseInt(s[2]);
        map = new int[N][M];
        mapTmp = new int[N][M];
        for(int i=0;i<3;++i){
            combinationedList.add(new Pos(0,0));
        }

        for(int i=0;i<N;++i){
            s = br.readLine().split(" ");
            for(int j=0;j<M;++j){
                map[i][j] = Integer.parseInt(s[j]);
                mapTmp[i][j] = map[i][j];
                if(map[i][j]==0){
                    zeroList.add(new Pos(i,j));
                }
            }
        }

        visitComb = new boolean[zeroList.size()];
        comb(0,3);
        System.out.println(ans);
    }
    /*
    0은 빈칸, 1은 적이 있는 위치이다.
    거리는 유클리드 거리로 한다.
    궁수는 3명이다.
     */


    private static void comb(int cnt,int r) {
        if(cnt==r){

            int count = depence();
            // 초기화
            if(count>ans){
                ans=count;
            }
            // 맵도 초기화 해야함
            mapReset();
            // 방문 맵 초기화
            return;
        }

        for(int i = cnt; i< zeroList.size(); ++i){
            if(visitComb[i])continue;
            visitComb[i]=true;
            combinationedList.set(cnt, zeroList.get(i));
            comb(cnt+1,r);
            visitComb[i]=false;
        }
    }

    private static int depence() {
        int count=0;
        for(int i = 0; i< combinationedList.size(); ++i){
            Pos setting = combinationedList.get(i);
            // 궁수는 2로 세팅
            // 궁수 배치
            map[setting.i][setting.j]=2;
        }

        for(int i=0;i<N;++i){
            count+=shooting();
            down();
        }
        // 유클리드 거리에 있는 적 제거
        return count;
    }

    private static int shooting(){
        //1.각 궁수들의 자리를 리스트에서 꺼낸다.
        //2. 궁수별로 왼쪽 아래에서부터 사정거리 내에 적이 있는지 확인한다.
        //3. 적이 있으면 제거하고 0으로 채우고 종료
        int count = 0;
        for(int k = 0; k < combinationedList.size(); ++ k){
            Pos archerPos = combinationedList.get(k);
            int iStart = Math.max(0,archerPos.i-range);
            int jStart = Math.max(0,archerPos.j-range);
            int iEnd = Math.min(N,archerPos.i+range);
            int jEnd = Math.min(M,archerPos.j+range);
            boolean breakFlag = false;

            for(int i=iStart;i<iEnd;++i){
                for(int j=jStart;j<jEnd;++j){
                    if(calcDistance(i,j,archerPos.i,archerPos.j)<=range && map[i][j]==1){
                        map[i][j]=0;
                        count++;
                        breakFlag = true;
                    }
                    if(breakFlag)break;
                }
                if(breakFlag)break;
            }
        }
        return count;
    }

    private static int calcDistance(int i1,int j1, int i2,int j2){
        return Math.abs(i1-i2)+Math.abs(j1-j2);
    }

    private static void down(){
        for(int i=N-2;i>=0;--i){
            for(int j=0;j<M;++j){
                if(map[i+1][j]!=2 &&i!=0 && map[i][j]!=2){
                    map[i+1][j] = map[i][j];
                }
                if(i==0){
                    map[i][j]=0;
                }
            }
        }
    }


    private static void mapReset(){
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                map[i][j]=mapTmp[i][j];
            }
        }
    }

    private static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
