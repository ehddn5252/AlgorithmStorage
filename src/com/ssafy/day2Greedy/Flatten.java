package com.ssafy.day2Greedy;
/*
문제명: Flattern
작성일자: 2022.02.04
작성자: 김동우
링크: https://bit.ly/3J4hepM
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Flatten {
    public static void main(String[] args) throws Exception {

        final int TESTCASE_NUM = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < TESTCASE_NUM; ++i) {
            int moveTimes = Integer.parseInt(br.readLine());
            String[] dumps = br.readLine().split(" ");
            int[] intDumps = strArray2intArray(dumps);
            System.out.print("#"+(i+1)+" ");
            System.out.println(mainLogic(moveTimes, intDumps));
        }
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[100];
        for (int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }

    static int mainLogic(int moveTimes, int[] intDumps) {
        /*
        1. max값 구하고 min 값 구한다음 이걸 계속 반복하면 된다.
         */
        final int COL_SIZE=100;
        while (true) {
            int maxValue = -1;
            int minValue = 101;
            int maxIndex = -1;
            int minIndex = -1;
            int currentNum = 0;
            for (int i = 0; i < COL_SIZE; ++i) {
                currentNum = intDumps[i];
                if (currentNum > maxValue) {
                    maxValue = currentNum;
                    maxIndex = i;
                }
                if (currentNum < minValue) {
                    minValue = currentNum;
                    minIndex = i;
                }
            }
            intDumps[maxIndex] = maxValue - 1;
            intDumps[minIndex] = minValue + 1;
            moveTimes--;
            if (moveTimes==-1){
                return maxValue-minValue;
            }
        }
    }
}