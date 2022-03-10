package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int count=0;
        for(int i=1;i< s.length;++i){
            if(Integer.parseInt(s[i])>Integer.parseInt(s[i-1])){
                count+=1;
            }
            if(Integer.parseInt(s[i])<Integer.parseInt(s[i-1])){
                count-=1;
            }
        }
        if(count==7){
            System.out.println("ascending");
        }
        else if(count==-7){
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }
    }
}
