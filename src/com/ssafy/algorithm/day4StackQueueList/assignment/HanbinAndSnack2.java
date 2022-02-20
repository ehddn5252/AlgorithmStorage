package com.ssafy.algorithm.day4StackQueueList.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

public class HanbinAndSnack2 {
    static int maxWeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            int[] NAndM = str2intArray(br.readLine());
            maxWeight = NAndM[1];
            int[] snacks = str2intArray(br.readLine());
            printTestCaseNum(testCaseIndex);
            System.out.println(mainLogic(snacks));
        }
    }
    static int mainLogic(int[] snacks) {
        sort(snacks);
        int currentWeight=-1;
        int start = 0;
        int end = snacks.length;
        int max=0;
        int tmpWeight=0;
        for(int i=0;i<end;++i){
            for(int j=i+1;j<end;++j){
                tmpWeight = snacks[i]+snacks[j];
                if(tmpWeight<= maxWeight &&tmpWeight> currentWeight){
                    currentWeight=tmpWeight;
                }
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
