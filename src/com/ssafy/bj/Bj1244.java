package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] switches;
    static int[][] studentInfo;

    public static void main(String[] args) throws IOException {

        // input
        int switchNum = Integer.parseInt(br.readLine());
        switches = new int[switchNum];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < switchNum; ++i) {
            switches[i] = Integer.parseInt(inputs[i]);
        }

        int studentNum = Integer.parseInt(br.readLine());
        studentInfo = new int[studentNum][2];
        for (int i = 0; i < studentNum; ++i) {
            String[] inputSt = br.readLine().split(" ");
            studentInfo[i][0] = Integer.parseInt(inputSt[0]);
            studentInfo[i][1] = Integer.parseInt(inputSt[1]);
        }
        // input end

        // 구현
        mainLogic();
        printSwitches();
    }

    static void printSwitches() {
        for (int i = 0; i < switches.length; ++i) {
            if(i%20==0 && i!=0){
                System.out.println();
            }
            if (i != switches.length - 1 && i% 20!=19) {
                System.out.print(switches[i] + " ");
            } else {
                System.out.print(switches[i]);
            }
        }
    }

    static void mainLogic() {
        for (int i = 0; i < studentInfo.length; ++i) {
            if (studentInfo[i][0] == 1) {
                manSwitch(studentInfo[i][1]);
            }
            else if (studentInfo[i][0] == 2) {
                womanSwitch(studentInfo[i][1]);
            }
        }
    }

    static void manSwitch(int index) {
        int saveIndex=index;
        // 남자는 자기가 받은 수의 배수 스위치의 상태를 바꾼다. 인덱스가 0부터 시작하므로 1을 빼줘야 한다.
        while (index - 1 <= switches.length - 1) {
            switchReverse(index - 1);
            index += saveIndex;
        }
    }

    static void womanSwitch(int index) {
        // 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서
        // 그 구간에 속한 스위치의 상태를 모두 바꾼다.
        switchReverse(index - 1);
        int plusIndex = index;
        int minusIndex = index - 2;
        while (minusIndex >= 0 && plusIndex < switches.length) {
            if (switches[minusIndex] == switches[plusIndex]) {
                switchReverse(minusIndex);
                switchReverse(plusIndex);

                minusIndex-=1;
                plusIndex+=1;
            }
            else{
                break;
            }
        }
    }


    static void switchReverse(int index) {
        if (switches[index] == 1) {
            switches[index] = 0;
        } else {
            switches[index] = 1;
        }
    }
}
