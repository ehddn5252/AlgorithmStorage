package com.ssafy.day3PCS.live;

import java.util.Arrays;
import java.util.Scanner;

public class DictTest {
    static int N, numbers[];
    private static int totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        int M = sc.nextInt();
        switch (M) {
            case 1: // 중복순열
                dice1(0);
                break;
            case 2: // 순열
                dice2(0, new boolean[7]);
                break;

            case 3: // 중복조합
                dice3(0, 1);
                break;
            case 4: // 조합
                dice4(0, 0);
            default:
                break;
        }
        System.out.println("총 경우의 수: " + totalCnt);
    }

    // 중복 순열
    public static void dice1(int cnt) {

        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 6; ++i) {
            numbers[cnt] = i;
            dice1(cnt + 1);
        }
    }

    // 순열: nPr
    public static void dice2(int cnt, boolean[] isSelected) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (isSelected[i]) {
                continue;
            }

            numbers[cnt] = i;
            isSelected[i] = true;

            dice2(cnt + 1, isSelected);
            isSelected[i] = false;
        }
    }

    // 중복 조합
    public static void dice3(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice3(cnt + 1, i); // 다음 주사위는 선택한 현재수부터 시작하도록 한다.
        }
    }

    // 조합
    public static void dice4(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);
        }
    }
}
