package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bj1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] plusArray = new int[10001];
        int[] minusArray = new int[10001];
        for(int i=1;i<N+1;++i) {
            int input = Integer.parseInt(br.readLine());
            if(input>=0){
                plusArray[input]+=1;
            }
            else{
                minusArray[-input]+=1;
            }
            int count=0;
            int middleValue = (int)Math.ceil(i/2.0);
            boolean breakFlag=false;
            while(true){
                for(int j=10000;j>=0;--j){
                    if(minusArray[j]!=0){
                        count+=1;
                    }
                    if(middleValue==count){
                        System.out.print(-j+" ");
                        breakFlag=true;
                        break;
                    }
                }
                if(breakFlag)break;
                for(int j=1;j<10001;++j){
                    if(plusArray[j]!=0){
                        count+=1;
                    }
                    if(middleValue==count){
                        System.out.print(j+" ");
                        breakFlag=true;
                        break;
                    }
                }
                if(breakFlag)break;
            }
        }
    }
}
