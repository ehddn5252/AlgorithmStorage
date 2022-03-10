package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Bj1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> l = new ArrayList<String>(500000);
    public static void main(String[] args) throws IOException {
        String[] s =br.readLine().split(" ");
        int case1=Integer.parseInt(s[0]);
        int case2=Integer.parseInt(s[1]);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<case1;++i){
            String ss = br.readLine();
            map.put(ss,1);
        }
        int ans=0;
        for(int i=0;i<case2;++i){
            String ss = br.readLine();
            if(map.get(ss)!=null){
                ans+=1;
                l.add(ss);
            }
        }
        System.out.println(ans);
        Collections.sort(l);
        for(int i=0;i<l.size();++i){
            System.out.println(l.get(i));
        }
    }
}
