package com.ssafy.day7SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KoreanMelon {
    static final int RIGHT = 0;
    static final int LEFT = 1;
    static final int DOWN = 2;
    static final int UP = 3;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] saveL = {0, 0, 0, 0};
    static int[] saveD = {0, 0, 0, 0};
    static ArrayList<int[]> intArray;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ii;
        intArray = new ArrayList<int[]>();
        for (int i = 0; i < 6; ++i) {
            ii = str2intArray(br.readLine());
            ii[0] = ii[0] - 1;
            intArray.add(ii);
        }
        System.out.print(N * mainLogic());
    }

    static int mainLogic() {
        int smallBeforeIndex = 0;
        int smallIndex = 0;
        int minus = 0;
        boolean isFirstCheck = true;
        for (int i = 0; i < 6; ++i) {
            int direction = intArray.get(i)[0];
            int length = intArray.get(i)[1];
            if (direction == RIGHT) {
                saveD[0] += 1;
                saveL[0] = length;
            } else if (direction == LEFT) {
                saveD[1] += 1;
                saveL[1] = length;
            } else if (direction == DOWN) {
                saveD[2] += 1;
                saveL[2] = length;
            } else if (direction == UP) {
                saveD[3] += 1;
                saveL[3] = length;
            }
            if (isFirstCheck) {
                for (int j = 0; j < 4; ++j) {
                    if (saveD[j] == 2) {
                        if(j==RIGHT ||j== LEFT){
                            int[] before = intArray.get(i - 1);
                            int[] before2 = intArray.get(i - 2);
                            smallIndex = before[0];
                            smallBeforeIndex = before2[0];
                            minus = before2[1] * before[1];
                            isFirstCheck = false;
                            break;
                        }
                        //j==UP or Down
                        else{
                            smallIndex = j;
                            int[] now = intArray.get(i);
                            int[] before = intArray.get(i - 1);
                            smallBeforeIndex = before[0];
                            minus = now[1] * before[1];
                            isFirstCheck = false;
                            break;
                        }

                    }
                }
            }
        }

        int total = 0;
        if (smallIndex == RIGHT) {
            total = saveL[LEFT] * saveL[UP + DOWN - smallBeforeIndex];
        } else if (smallIndex == LEFT) {
            total = saveL[RIGHT] * saveL[UP + DOWN - smallBeforeIndex];
        } else if (smallIndex == DOWN) {
            total = saveL[UP] * saveL[LEFT + RIGHT - smallBeforeIndex];
        } else if (smallIndex == UP) {
            total = saveL[DOWN] * saveL[LEFT + RIGHT - smallBeforeIndex];
        }
        return total - minus;
    }

    static void printAll() {
        System.out.println("intArray");
        for (int i = 0; i < intArray.size(); ++i) {
            System.out.print(intArray.get(i)[0] + " " + intArray.get(i)[1]);
            System.out.println();
        }


        System.out.println("saveD");
        for (int i = 0; i < saveD.length; ++i) {
            System.out.print(saveD[i] + " ");
        }
        System.out.println();
        System.out.println("saveL");
        for (int i = 0; i < saveL.length; ++i) {
            System.out.print(saveL[i] + " ");
        }
    }

    static int[] str2intArray(String str) {
        String[] strList = str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }
}
