package com.ssafy.algorithm.day2Greedy;
/*
문제명: 농작물 수확하기
제출일자: 2022.02.04
제출자: 김동우
링크: https://bit.ly/3AVLCzO
N x N 크기의 농장이 있다.

1. 농장의 크기는 항상 홀수이다.
2. 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crops {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            System.out.print("#"+testCaseIndex+" ");
            int mapSize = Integer.parseInt(br.readLine());
            char[][] map = new char[mapSize][mapSize];
            for(int mapRowIndex=0;mapRowIndex<mapSize;++mapRowIndex){
                String s = br.readLine();
                for(int mapColIndex=0;mapColIndex<mapSize;++mapColIndex){
                    map[mapRowIndex][mapColIndex] = s.charAt(mapColIndex);
                }
            }

            //printMap(map);
            // 위에 까지 map setting 완료
            System.out.println(mainLogic(map));

        }
    }
    private static void printMap(char[][] map){
        for(char[] i:map){
            for(char j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private static int mainLogic(char[][] map){
        int sum=0;
        int mapSize=map.length;

        for(int rowIndex=0;rowIndex<mapSize;++rowIndex){
            if (rowIndex<(mapSize/2+1)) {
                for (int colIndex = 0; colIndex <= rowIndex ; ++colIndex) {
                    if (colIndex == 0) {
                        sum += map[rowIndex][mapSize / 2]-'0';
                    } else{
                        sum += map[rowIndex][mapSize / 2 + colIndex]-'0';
                        sum += map[rowIndex][mapSize / 2 - colIndex]-'0';
                    }
                }
            }
            else{
                for (int colIndex = 0; colIndex <mapSize - rowIndex; ++colIndex) {
                    if (colIndex == 0) {
                        sum += map[rowIndex][mapSize / 2]-'0';
                    } else{
                        sum += map[rowIndex][mapSize / 2 + colIndex]-'0';
                        sum += map[rowIndex][mapSize / 2 - colIndex]-'0';
                    }
                }
            }
        }
        return sum;
    }
}
