package com.ssafy.algorithm.day2Greedy;

/*
문제명: 백준 1244. 스위치 켜고 끄기
제출일자: 2022.02.04
제출자: 김동우
링크: https://www.acmicpc.net/problem/1244
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchOnOff {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine(); // 쓸모 없음
        int[] switches = strArray2intArray(bf.readLine().split(" "));
        int studentNum = Integer.parseInt(bf.readLine());
        for(int i=0;i<studentNum;++i){
            int[] studentInfo = strArray2intArray(bf.readLine().split(" "));
            switches = mainLogic(studentInfo,switches);
        }
        printAll(switches);
    }
    static void printAll(int[] intArray){
        String strs = "";
        for(int i=0;i<intArray.length;++i){
            if (i!=0 && i%20==0){
                System.out.println(strs);
                strs="";
            }
            if(i==intArray.length-1){
                strs+=Integer.toString(intArray[i]);
                //System.out.print(intArray[i]);
            }
            else {
                strs+=Integer.toString(intArray[i])+" ";
                //System.out.print(intArray[i] + " ");
            }
        }
        System.out.println(strs);
    }
    static int[] mainLogic(int[] studentInfo,int[] switches){

        // 남자
        int sexInfo = studentInfo[0];
        int switchNum = studentInfo[1];
        int switchNum_tmp = switchNum;
        if (sexInfo==1){
            while (switchNum-1<switches.length){
                switches[switchNum - 1] = switchChange(switches[switchNum - 1]);
                switchNum+=switchNum_tmp;
            }
        }
        else if(sexInfo == 2){
            int countSymmetry = 1;
            switches[switchNum - 1] = switchChange(switches[switchNum - 1]);
            while(true) {
                if (switchNum - countSymmetry - 1 >= 0 && switchNum + countSymmetry - 1 < switches.length) {
                    if (switches[switchNum - countSymmetry - 1] == switches[switchNum + countSymmetry - 1]) {
                        switches[switchNum - countSymmetry - 1] = switchChange(switches[switchNum - countSymmetry - 1]);
                        switches[switchNum + countSymmetry - 1] = switchChange(switches[switchNum + countSymmetry - 1]);
                        countSymmetry+=1;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        return switches;
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }

    static int switchChange(int s){
        if (s==1){
            return 0;
        }
        else{
            return 1;
        }
    }
}