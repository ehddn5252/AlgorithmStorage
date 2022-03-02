package com.ssafy.algorithm.bj;
// 랜선 자르기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K,N;
    static ArrayList<Integer> lanLines = new ArrayList<Integer>(10000);
    public static void main(String[] args) throws IOException {
        String[] s  = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        for(int i=0;i<K;++i){
            lanLines.add(Integer.parseInt(br.readLine()));
        }
        long start=0;
        long end=Long.MAX_VALUE;
        long middle=0;
        long result =0;
        int lanNum;
        while(start<=end){
            middle = (start+end)/2;
            lanNum = check(middle);
            // 목표한 것보다 수가 많으면 길이를 늘려야 한다.
            if(lanNum>=N){
                start=middle+1;
                result =middle;
            }
            // 목표한 것보다 수가 적으면 길이를 줄여야 한다.
            else if(lanNum<N){
                end=middle-1;
            }
        }
        System.out.println(result);
    }

    static int check(long middle){
        int ret = 0;
        for(int i = 0; i< lanLines.size(); ++i){
            ret+=lanLines.get(i)/middle;
        }
        return ret;
    }
}
