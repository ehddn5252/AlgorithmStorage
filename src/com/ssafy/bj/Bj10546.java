package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Bj10546 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        N = Integer.parseInt(br.readLine());


        for(int i=0;i<N;++i){
            String s = br.readLine();
            if (map.get(s)==null){
                map.put(s,1);
            }
            else{
                map.put(s,map.get(s)+1);
            }
        }

        for(int i=0;i<N-1;++i){
            String s = br.readLine();
            map.put(s,map.get(s)-1);
        }
        for(String i: map.keySet()){
            if (map.get(i)==1){
                System.out.println(i);
                break;
            }
        }
    }
}
