package com.ssafy.algorithm.bj;

import java.io.*;

public class Bj772_2_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s1, s2;
    static int answer;
    static int[] dp;
    // 1. 문자를 모두 arrayList에 둔다.
    // 2. 맨 처음에
    public static void main(String[] args) throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()];
        // 같은 문자면 저장, 다른 문자면 pass
        int s2Index = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        for(int i=0;i<s1Length;++i){
        }
    }
}
