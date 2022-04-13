package com.ssafy.algorithm.newDay6SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj1577 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int colNum = Integer.parseInt(s[0]); // 가로 크기
        int rowNum = Integer.parseInt(s[1]); // 세로 크기
        int[][] map= new int[rowNum][colNum];
        int k = Integer.parseInt(br.readLine());


        Queue<Pos> q = new LinkedList<Pos>();
        for(int i=0;i<rowNum;++i){
            map[i][0]=1;
        }
        for(int j=0;j<colNum;++j){
            map[0][j]=1;
        }

        for(int i=0;i<k;++i){
            s =  br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int d = Integer.parseInt(s[3]);
            int col = Math.min(a,c);
            int row = Math.min(b,d);
//            q.offer(new Pos(row,col));
            map[row][col]=0;
            if(row==0 && b==d){
                for(int j=col+1;j<colNum;++j){
                    map[row][j]=0;
                }
            }
            if(col==0 && a==c){
                for(int j=row+1;j<rowNum;++j){
                    map[j][col]=0;
                }
            }
        }
        // 가로로 막혀져 있으면 (a !=c) 더 작은쪽 좌표를 0으로
            // 세로로 막혀져 있으면 (b!=d) 더 작은쪽 좌표를 0으로 ( 둘다 작은쪽을 가지면 될듯)
        for(int i = 0; i< rowNum; ++i){

        }
    }

    static class Pos{
        int row;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        int col;
    }
}
