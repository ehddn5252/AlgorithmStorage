package com.ssafy.algorithm.day6BfsDfs.assigment.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SungbinArihmeticValidation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException{
        for(int tc=1; tc<=10; tc++) {
            boolean flag=true;
            bw.write(String.format("#%d ", tc));
            N = Integer.parseInt(br.readLine());
            for(int i=1; i<=N; i++) {
                if(i<=N/2) {
                    if(!(br.readLine().matches("(.*)[-+*/](.*)"))) {
                        flag=false;
                    }
                }else {
                    if(br.readLine().matches("(.*)[-+*/](.*)")) {
                        flag=false;
                    }
                }
            }
            if(flag) bw.write(1+"\n");
            else bw.write(0+"\n");
        }

        bw.flush();
        bw.close();
    }
}
