package com.ssafy.algorithm.day4StackQueueList.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

public class HanbinAndSnack {
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            int[] NAndM = str2intArray(br.readLine());
            M = NAndM[1];
            int[] snacks = str2intArray(br.readLine());
            printTestCaseNum(testCaseIndex);
            System.out.println(mainLogic(snacks));
        }
    }
    static int mainLogic(int[] snacks) {
        sort(snacks);
        int currentWeight=-1;
        int start = 0;
        int end = snacks.length-1;
        while(start<end){
            if(snacks[start]+snacks[end]>M){
                end--;
            }
            else{
                currentWeight = snacks[start]+snacks[end];
                start++;
            }
        }
        return currentWeight;
    }


    static int[] str2intArray(String str){
        String[] strList=str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }

    static void printTestCaseNum(int testCaseIndex){
        System.out.print("#"+testCaseIndex+" ");
    }
}
