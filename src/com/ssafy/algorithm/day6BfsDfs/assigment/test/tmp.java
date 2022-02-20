package com.ssafy.algorithm.day6BfsDfs.assigment.test;

import java.io.*;
import java.util.StringTokenizer;

public class tmp {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] map;
    static int[] callingNum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = twoIntArraySetting(10,10);

    }

    public static int[][] twoIntArraySetting(int rowNum, int colNum) throws IOException {
        int[][] retArray= new int[rowNum][colNum];
        for(int rowIndex=0;rowIndex<rowNum;++rowIndex){
            int[] inputI = str2intArray(br.readLine());
            for(int colIndex=0;colIndex<colNum;++colIndex){
                retArray[rowIndex][colIndex] = inputI[colIndex];
            }
        }
        return retArray;
    }

    static int[] str2intArray(String str){
        String[] strList=str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }
}
