package com.ssafy.day10SovingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class WirelessCharging {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int time;
    static int bcNum;
    static int[] aInfo, bInfo;
    static ArrayList<int[]> bcList;
    static int[] aLocation = {1, 1};
    static int[] bLocation = {10, 10};
    static int[] aCharge, bCharge;
    static int result;
    // col, row 가만히, 상, 우, 하, 좌
    static int[][] d = new int[][]{{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    // 매 차례 움직일때마다 각 bc 와의 거리를 확인한다.
    // 거리안에 들 때 charge 한다.
    // 거리안에 들지 않는다면
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 1; testCaseIndex < testCaseNum + 1; ++testCaseIndex) {
            String[] inputS = br.readLine().split(" ");
            // 초기화
            time = Integer.parseInt(inputS[0]);
            bcNum = Integer.parseInt(inputS[1]);
            aInfo = str2IntArray(br.readLine());
            bInfo = str2IntArray(br.readLine());
            bcList = new ArrayList<int[]>();
            aLocation[0] = 1;
            aLocation[1] = 1;
            bLocation[0] = 10;
            bLocation[1] = 10;
            for (int i = 0; i < bcNum; ++i) {
                bcList.add(str2IntArray(br.readLine()));
            }
            aCharge = new int[bcNum];
            bCharge = new int[bcNum];
            result = 0;
            mainLogic();
            System.out.print("#"+testCaseIndex+" ");
            System.out.println(result);
        }
    }

    static void mainLogic() {
        for (int i = 0; i < time; ++i) {
            // 여기에서 bc들과 비교해서 해당 범위 안에 있으면 충전하게 해준다.
            compareBC();
            // bc들을 비교해서 충전한다.
            charging();
            // charge list 리셋
            resetCharge();

            // 각 위치 설정
            aLocation[0] = aLocation[0] + d[aInfo[i]][0];
            aLocation[1] = aLocation[1] + d[aInfo[i]][1];

            bLocation[0] = bLocation[0] + d[bInfo[i]][0];
            bLocation[1] = bLocation[1] + d[bInfo[i]][1];
        }
        compareBC();
        // bc들을 비교해서 충전한다.
        charging();
        // charge list 리셋
        resetCharge();
    }

    static void printAll(int time) {
        System.out.println("time: " + time);
        System.out.println("aLocation");
        System.out.println(Arrays.toString(aLocation));
        System.out.println("bLocation");
        System.out.println(Arrays.toString(bLocation));
    }

    static void compareBC() {
        for (int i = 0; i < bcNum; ++i) {
            calc(i);
        }
    }

    static void calc(int i) {
        boolean isACharge = false, isBCharge = false;
        int[] bcInfo = bcList.get(i);
        int aCalc = Math.abs(aLocation[0] - bcInfo[0]) + Math.abs(aLocation[1] - bcInfo[1]);
        if (aCalc <= bcInfo[2]) {
            isACharge = true;
        }
        int bCalc = Math.abs(bLocation[0] - bcInfo[0]) + Math.abs(bLocation[1] - bcInfo[1]);
        if (bCalc <= bcInfo[2]) {
            isBCharge = true;
        }
        if (isACharge && isBCharge) {
            aCharge[i] = bcInfo[3];
            bCharge[i] = bcInfo[3];
        } else if (isACharge) {
            aCharge[i] = bcInfo[3];
        } else if (isBCharge) {
            bCharge[i] = bcInfo[3];
        }
    }


    static void charging() {
        int maxValue = 0;
        for(int i=0;i<bcNum;++i){
            for(int j=0;j<bcNum;++j){
                if(i==j){
                    maxValue = Math.max(maxValue,aCharge[i]);
                    maxValue = Math.max(maxValue,bCharge[i]);
                }
                else{
                    maxValue= Math.max(maxValue, aCharge[i]+bCharge[j]);
                }
            }
        }
        result+=maxValue;
    }

    static void resetCharge() {

        for (int i = 0; i < aCharge.length; ++i) {
            aCharge[i] = 0;
        }
        for (int i = 0; i < bCharge.length; ++i) {
            bCharge[i] = 0;
        }
    }

    static int[] str2IntArray(String str) {
        String[] s = str.split(" ");
        int[] intArray = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            intArray[i] = Integer.parseInt(s[i]);
        }
        return intArray;
    }
}
