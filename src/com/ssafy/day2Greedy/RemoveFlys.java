package com.ssafy.day2Greedy;

/*
문제명: 파리 퇴치 (SW Expert Academy 2001)
제출일자: 2022.02.04
제출자: 김동우
링크: https://bit.ly/3HF6PR2
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveFlys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum+1; ++testCaseIndex) {
            String[] inputInfo = br.readLine().split(" ");
            int mapSize = Integer.parseInt(inputInfo[0]);
            int miniMapSize = Integer.parseInt(inputInfo[1]);
            int [][] map = new int[mapSize][mapSize];
            for (int i = 0; i < mapSize; ++i) {
                int[] mapInput = strArray2intArray(br.readLine().split(" "));
                for(int j=0;j<mapSize;++j){
                    map[i][j]=mapInput[j];
                }
            }

            System.out.print("#"+testCaseIndex+" ");
            System.out.println(mainLogic(map,miniMapSize));
        }
    }

    static int mainLogic(int[][] map, int miniMapSize){
        int maxValue = -1;
        int innerSumRet = 0;
        for(int rowIndex=0 ; rowIndex<map.length ; ++rowIndex){
            for(int colIndex=0;colIndex<map.length;++colIndex){
                innerSumRet = innerSum(map,rowIndex,colIndex,miniMapSize);
                if (maxValue <innerSumRet){
                    maxValue =innerSumRet;
                };
            }
        }
        return maxValue;
    }
    static int innerSum(int[][] map, int rowIndex, int colIndex, int miniMapSize) {
        int mapSize = map.length;
        int innerSum = 0;
        for (int innerRowIndex = 0; innerRowIndex < miniMapSize; ++innerRowIndex) {
            for (int innerColIndex = 0; innerColIndex < miniMapSize; ++innerColIndex) {
                if (innerRowIndex + rowIndex<mapSize &&innerColIndex + colIndex < mapSize) {
                    innerSum += map[innerRowIndex + rowIndex][innerColIndex + colIndex];
                }
            }
        }
        return innerSum;
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[100];
        for (int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }
}