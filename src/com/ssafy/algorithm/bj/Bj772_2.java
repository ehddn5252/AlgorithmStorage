package com.ssafy.algorithm.bj;

import java.io.*;

public class Bj772_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s1, s2;
    static int answer;
    static boolean[] visit;
    // 1. 문자를 모두 arrayList에 둔다.
    // 2. 맨 처음에
    public static void main(String[] args) throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();
        visit = new boolean[s1.length()];
        // 같은 문자면 저장, 다른 문자면 pass
        int s2Index = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();
        int start=0;
        while(true) {
            for (int i = start; i < s1Length; ++i) {
                if(visit[i]) continue;
                if (s1.charAt(i) == s2.charAt(s2Index)) {
                    if(s2Index==0){
                        start=i+1;
                    }
                    visit[i]=true;
                    s2Index+=1;
                }
                if(s2Index == s2Length){
                    s2Index=0;
                    answer+=1;
                    if(i==s1Length-1){
                        System.out.println(answer);
                        return;
                    }
                    break;
                }
                if(i==s1Length-1){
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
}
