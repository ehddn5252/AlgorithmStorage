package com.ssafy.day3PCS.Assignment;
/*
내용:
탑들을 한번 쭉 돌면서 기존의 값보다 더 높은 값이 있으면 +1 한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Top {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] tops = strArray2intArray(br.readLine().split(" "));
        printAll(mainLogic(tops));
    }

    static void printAll(int[] result){

        for(int i =0;i<result.length;++i){
            if (i==result.length-1){
                System.out.print(result[i]);
            }
            else{
                System.out.print(result[i]+" ");
            }
        }
    }

    // 1회 순회로 끝내야함.자신보다 높은 위치에 있는 지 확인해야 한다.
    // 맨 처음에 만난 자기보다 높은 탑에서 신호를 받는다. 그리고 끝
    // 신호는 왼쪽으로 쏜다.
    // 신호를 받는 것이 없다면 x
    // 6 9 5 7 4
    // 신호를 쏜것을 저장
    static int[] mainLogic(int[] tops){
        int[] receiveInfo = new int[N];
        int start = tops.length-1;
        int trace = start-1;
        while(trace>=0){
            if(tops[trace]>tops[start]){
                receiveInfo[start]=trace+1;
                start-=1;
                trace=start-1;
            }
            else{
                trace-=1;
            }
        }
        return receiveInfo;
    }


    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for(int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }


}
