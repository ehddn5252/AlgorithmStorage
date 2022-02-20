package com.ssafy.algorithm.day7SolvingProb.practice;

import java.io.*;

/*
100 * 100 사이즈의 int[][]를 만들고 값을 4개의 직사각형에 1을 넣으면 된다.
 */
public class Square4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] int2DArray = new int[100][100];
    static int sum=0;
    public static void main(String[] args) throws IOException {
        for (int squareIndex = 0; squareIndex < 4; ++squareIndex) {
            int[] intArray = str2IntArray(br.readLine());
            for (int i = intArray[1]; i < intArray[3]; ++i) {
                for (int j = intArray[0]; j < intArray[2]; ++j) {
                    int2DArray[i][j] = 1;
                }
            }
        }
        for(int i=0;i<100;++i){
            for(int j=0;j<100;++j){
                sum+=int2DArray[i][j];
            }
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }

    static int[] str2IntArray(String str) {
        String[] s = str.split(" ");
        int[] intArray = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            intArray[i] = Integer.parseInt(s[i]);
        }
        return intArray;
    }
}
