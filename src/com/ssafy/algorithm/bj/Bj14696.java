package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj14696 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            int[] aInfo= new int[]{0,0,0,0,0};
            int[] bInfo= new int[]{0,0,0,0,0};
            String[] s = br.readLine().split(" ");

            for(int j=0;j<Integer.parseInt(s[0]);++j){
                aInfo[Integer.parseInt(s[j+1])] += 1;
            }
            String[] s2 = br.readLine().split(" ");
            for(int j=0;j<Integer.parseInt(s2[0]);++j){
                bInfo[Integer.parseInt(s2[j+1])] += 1;
            }

            for(int j=4;j>=1;--j){
                if (aInfo[j]>bInfo[j]){
                    System.out.println("A");
                    break;
                }
                else if(aInfo[j]<bInfo[j]) {
                    System.out.println("B");
                    break;
                }
                if(j==1){
                    System.out.println("D");
                }
            }
        }
    }
}
