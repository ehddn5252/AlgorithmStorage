package com.ssafy.algorithm.day9Greedy.assignment;
// 설탕 배달

import java.io.*;

public class Bj2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int max5Num = N / 5;
        int rest = N % 5;
        int fiveNum = max5Num;
        int threeNum = 0;
        int ret = -1;
        while (fiveNum >= 0) {
            if (rest % 3 != 0) {
                rest += 5;
                fiveNum -= 1;
            } else {
                threeNum = rest / 3;
                ret = threeNum+fiveNum;
                break;
            }
        }
        bw.write(Integer.toString(ret));
        bw.flush();
        bw.close();
    }
}
