package com.ssafy.algorithm.day7SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KoreanMelon_1 {
    static final int RIGHT = 0;
    static final int LEFT = 1;
    static final int DOWN = 2;
    static final int UP = 3;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<int[]> intArray;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] inputIntArray;
        int checkStack = 0;
        intArray = new ArrayList<int[]>();
        for (int i = 0; i < 6; ++i) {
            inputIntArray = str2intArray(br.readLine());
            inputIntArray[0] = inputIntArray[0] - 1;
            intArray.add(inputIntArray);
        }
        //입력을 2번 집어넣음
        for(int i=0;i<6;++i){
            inputIntArray =intArray.get(i);
            intArray.add(inputIntArray);
        }

        // 큰사각형에서 작은 사각형 뺌
        for(int i=3;i<12;++i){
            int[] now=intArray.get(i);
            int[] before1=intArray.get(i-1);
            int[] before2=intArray.get(i-2);
            int[] before3=intArray.get(i-3);

            // 만약 2번연속 같은패턴이 나오면 계산 끝
            if(now[0]==before2[0] && before1[0]==before3[0]){
                int[] before=intArray.get(i-1);
                int[] next = intArray.get(i+1);
                int[] next2 = intArray.get(i+2);

                // 결과값  큰사각형에서 작은 사각형 뺌
                System.out.println(N*(next[1]*next2[1]-before[1]*before2[1]));
                return;
            }
        }
    }
    // 스트링을 int 배열로 바꿔줌
    static int[] str2intArray(String str) {
        String[] strList = str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }
}