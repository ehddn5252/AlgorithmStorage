package com.ssafy.bj;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MakeTestCase_to_file {

    static int N;
    static int M = 10000;
    static int randomValue;
    public static void main(String[] args) {
        N = (int)(Math.random()*100000);
        M = N;
        while(N <= M && M >0){
            M = (int)(Math.random()*100000);
        }
        System.out.println(N +" "+ M);
        for(int i = 0; i< N; ++i){
            randomValue = (int)(Math.random()*500);
        }
        try {
            OutputStream output = new FileOutputStream("src/com/ssafy/bj/Output.txt");
            output.write((N +" "+ M + "\n").getBytes());
            for(int i = 0; i< N; ++i) {
                randomValue = (int) (Math.random() * 1000);
                String str = randomValue + "\n";
                byte[] by = str.getBytes();
                output.write(by);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
