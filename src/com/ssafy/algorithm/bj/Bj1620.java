package com.ssafy.algorithm.bj;

//이다솜
import java.util.*;
import java.io.*;

class Bj1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static HashMap<String,String> map = new HashMap<String,String>();
    public static void main(String[] args) throws IOException {

        String[] s =br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for(int i=1;i<N+1;++i){
            String inputStr = br.readLine();
            map.put(Integer.toString(i),inputStr);
            map.put(inputStr, Integer.toString(i));
        }
        for(int i=0;i<M;++i){
            String inputStr = br.readLine();
            bw.write(map.get(inputStr)+"\n");
        }
        bw.flush();
        bw.close();
    }
}