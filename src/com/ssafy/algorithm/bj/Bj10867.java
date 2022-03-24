package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
10
-1000 1000 999 -999 -222 0 0 0 0 1 1 1 1 1000 1000 999

*/

// 중복 빼고 정렬하기
public class Bj10867 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] s = new int[1001];
        int[] minusS = new int[1001];
        String[] strings = br.readLine().split(" ");
        for(int i=0;i<strings.length;++i){
            int num = Integer.parseInt(strings[i]);
            if(num>=0)s[num]+=1;
            else{
                minusS[-num]+=1;
            }
        }
        for(int i=minusS.length-1;i>0;--i){
            if(minusS[i]!=0){
                System.out.print(-i+" ");
            }
        }
        for(int i=0;i<s.length;++i){
            if(s[i]!=0){
                System.out.print(i+" ");
            }
        }
    }
}
