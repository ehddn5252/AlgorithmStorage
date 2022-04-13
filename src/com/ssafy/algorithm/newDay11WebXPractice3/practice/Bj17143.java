package com.ssafy.algorithm.newDay11WebXPractice3.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj17143 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum, sharkNum, ans;
    static List<Shark> l = new ArrayList<Shark>();
    static Queue<Shark> q = new LinkedList<Shark>();
    static int[][] d = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        sharkNum = Integer.parseInt(s[2]);
        for(int i=0;i<sharkNum;++i){
            s = br.readLine().split(" ");
            //r, c, s, d, z : row col 속력 방향 크기
            // d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
            Shark tmpShark = new Shark(iToS(s[0]),iToS(s[1]),iToS(s[2]),iToS(s[3]),iToS(s[4]));
            l.add(tmpShark);
            q.offer(tmpShark);
        }

        for(int i=1;i<colNum;++i){
            mainLogic(i);
        }
        System.out.println(ans);
    }

    private static Queue<Shark> qClone(){
        Queue<Shark> newQ = new LinkedList<Shark>();
        for (Shark s : q){
            newQ.offer(s);
        }
        return newQ;
    }


    private static void mainLogic(int time) {
        catchShark(time);
        moveShark();
        eatShark(); // 같은 칸에 있는 지 확인 같은 칸에 있으면 잡아먹음 처리
    }

    private static void catchShark(int time) {
        int minJ = 99999;
        int minJIndex=-1;
        int minJSharkSize=-1;
        int size = l.size();
        for ( int i = 0 ; i < size ; ++i ){
            Shark s = l.get(i);
            if (s.c==time-1) {
                if (s.r<minJ) {
                    minJIndex = i;
                    minJSharkSize = s.s;
                    minJ = s.r;
                }
            }
        }
        if(minJIndex!=-1){
            ans+=minJSharkSize;
            l.remove(minJIndex);
        }
    }


    private static void moveShark(){
        // d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
        for(int i=0;i<l.size();++i){
            Shark s = l.get(i);
            int times = s.s;
            /*
            여기서 상어들 움직이는 거 처리해야하는데, 방향 왔다갔다 하는거 연습을 좀 해야 할 듯

             */
            while(times>=0) {
                s.r = s.r + d[s.d][0] * s.s; // 이거 계산식을 우째하더라..
                s.c = s.c + d[s.d][1] * s.s;
            }
        }
    }

    private static void eatShark(){
        for(int i=0;i<l.size();++i){
            boolean is_same_location=false;
            Shark s = l.get(i);

            for(int j=l.size()-1;j>i;--j){
                Shark s1 = l.get(j);

                if(s.c==s1.c && s.r == s1.r){
                    if(s.s>s1.s){
                        l.remove(j);
                    }
                    else{
                        l.remove(i);
                        j=l.size();
                    }
                }
            }
        }

    }

    private static int iToS(String s){
        return Integer.parseInt(s);
    }

    static class Shark{

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r; // row
            this.c = c; // col
            this.s = s; // 속력
            this.d = d; // 방향
            this.z = z; // 크기
        }

        int r;
        int c;
        int s;
        int d;
        int z;
    }
}
