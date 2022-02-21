package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Bj17219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String,String> hash = new HashMap<String,String>();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i=0;i<n;++i){
            s = br.readLine().split(" ");
            hash.put(s[0],s[1]);
        }
        for(int i=0;i<m;++i){
            String key = br.readLine();
            System.out.println(hash.get(key));
        }
    }
}
