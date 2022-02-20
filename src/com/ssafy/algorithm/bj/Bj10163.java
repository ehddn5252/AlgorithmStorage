package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10163 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[1001][1001];

    // row는 1001-i로 설정해야 한다.
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N + 1; ++i) {
            String[] s = br.readLine().split(" ");
            int startCol = Integer.parseInt(s[0]);
            int startRow = Integer.parseInt(s[1]);
            int colLength = Integer.parseInt(s[2]);
            int rowLength = Integer.parseInt(s[3]);
            for(int row=startRow;row<startRow+rowLength;++row){
                for(int col=startCol;col<startCol+colLength;++col){
                    map[row][col]=i;
                }
            }
        }
        for(int num=1;num<N+1;++num){
            int ans=0;
            for(int i=0;i<map.length;++i){
                for(int j=0;j<map[0].length;++j){
                    if(map[i][j]==num)
                        ans+=1;
                }
            }
            System.out.println(ans);
        }
    }
}
