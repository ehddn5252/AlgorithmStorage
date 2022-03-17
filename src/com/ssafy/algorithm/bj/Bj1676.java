package com.ssafy.algorithm.bj;
// 팩토리얼 0의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1676 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial((N)));
    }

    static long factorial(int n){
        int fiveCount=0;
        for(int i=n;i>0;--i){
            int num = i;
            while(true){
                if(num%5==0){
                    num/=5;
                    fiveCount+=1;
                }
                else{
                    break;
                }
            }
        }
        return fiveCount;
    }

}
