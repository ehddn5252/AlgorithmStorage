package com.ssafy.algorithm.bj;

import java.io.*;
import java.util.Arrays;

public class Bj772_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] aArray;
    static int[] answer;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        aArray = new int[N+1];
        answer = new int[N];

        for(int i=0;i<N;++i){
            aArray[i+1] =Integer.parseInt(s[i]);
        }

        int answerIndex = 0;
        int beforeJ = 0;
        int beforeIndex = 0;
        for(int i=1;i<N+1;++i){
            boolean check=false;
            if(beforeJ!=0 &&aArray[beforeIndex]==aArray[i]){
                answer[answerIndex]=beforeJ;
                answerIndex+=1;
                continue;
            }

            for(int j=i+1;j<N+1;++j){
                if(aArray[i]!= aArray[j]){
                    check=true;
                    answer[answerIndex] = j;
                    beforeJ = j;
                    beforeIndex = i;
                    answerIndex += 1;
                    break;
                }
            }

            if(check==false){
                answer[answerIndex]=-1;
                beforeJ=-1;
                answerIndex+=1;
                beforeIndex = i;
            }
        }
        for(int i=0;i<answer.length;++i){
            bw.write(answer[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
