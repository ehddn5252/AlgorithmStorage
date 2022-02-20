package com.ssafy.algorithm.day6BfsDfs.assigment.test;

import java.io.*;
import java.util.StringTokenizer;

public class Pibo2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        // 자료형
        long[] dpMap =new long[91];
        // 기저조건

        dpMap[0]=0;
        dpMap[1]=1;

        // 점화식
        for(int i=0;i<dpMap.length-2;++i){
            dpMap[i+2] = dpMap[i]+ dpMap[i+1];
        }
        bw.write(String.format("%d", dpMap[N]));
        bw.flush();
        bw.close();
    }
}
