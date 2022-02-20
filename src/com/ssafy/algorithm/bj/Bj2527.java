package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2527 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] points = new int[4][8];
    static char[][] map = new char[50000][50000];
    public static void main(String[] args) throws IOException {

        // input
        for(int i=0;i<4;++i){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<8;++j){
                points[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
    
    // 해당 크기의 직사각형을 2개 만들어서 직접 빼준다.
    //
    static void check(int order){
        for(int i=0;i<map.length;++i){

        }
    }
}
