package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2602 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        String s1 =  br.readLine();
        String s2 =  br.readLine();
        String[] sList = {s1,s2};
        int startIndex=0;
        int bridgeKind=0;
        int count=0;
        while(true){
            for(int i=0;i<sList[0].length();++i){
                if(sList[bridgeKind].charAt(i)==s.charAt(startIndex)){
                    count+=1;
                }
            }
        }
    }
}
