package com.ssafy.algorithm.day13Graph.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for(int i=1;i<testCaseNum+1;++i){
            String[] s = br.readLine().split(" ");
            float x = (float)Integer.parseInt(s[0]);
            float y = (float)Integer.parseInt(s[1]);
            float max=0;
            // (a-2*x)(b-2*x)*x 가 최대가 되는 수 구하기.
            for(float h=0;h<x/4;h+=0.0002){
                float cal = (x-2*h) *(y-2*h)*h;
                if(max<cal){
                    max = cal;
                }
            }
            System.out.printf("#%d %.6f\n",i,max);
        }
    }
}
