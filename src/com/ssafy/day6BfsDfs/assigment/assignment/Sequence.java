package com.ssafy.day6BfsDfs.assigment.assignment;

import java.io.*;
// 문제명: bj2491
public class Sequence {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] numbers;
    static int maxLength=1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        numbers = str2intArray(br.readLine());
        mainLogic();
        bw.write(String.format("%d",maxLength));
        bw.flush();
        bw.close();
    }

    private static void debuging(int index, int currentBiggerLength,int currentSmallerLength,int maxLength){
        System.out.println("index: "+index);
        System.out.println("currentBiggerLength: "+currentBiggerLength);
        System.out.println("currentSmallerLength: "+currentSmallerLength);
        System.out.println("maxLength: "+ maxLength);
        System.out.println("==================");
    }

    public static void mainLogic(){
        int beforeNum;
        int currentBiggerLength = 1;
        int currentSmallerLength = 1;
        beforeNum = numbers[0];
        for(int i=1;i< numbers.length;++i){
            if (beforeNum<=numbers[i]) currentBiggerLength += 1;
            else currentBiggerLength=1;
            if (beforeNum>=numbers[i]) currentSmallerLength += 1;
            else currentSmallerLength=1;

            //debuging(i,currentBiggerLength,currentSmallerLength,maxLength);
            beforeNum = numbers[i];

            if (currentSmallerLength > maxLength) maxLength = currentSmallerLength;
            if (currentBiggerLength > maxLength) maxLength = currentBiggerLength;

        }
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
