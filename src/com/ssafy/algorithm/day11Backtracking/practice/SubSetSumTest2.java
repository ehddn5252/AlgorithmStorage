package com.ssafy.algorithm.day11Backtracking.practice;

import java.util.Scanner;

public class SubSetSumTest2 {

    static int N, S, input[], ans;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt(); // 목표합
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; ++i) {
            input[i] = sc.nextInt();
        }
        generateSubset2(0, 0);
        System.out.println(ans);
    }

    static int callCnt=0;
    public static void generateSubset2(int cnt, int sum) {
        if(cnt==N) {
            if (sum == S) {
                ++ans;
                for (int i = 0; i < N; ++i) {
                    System.out.print(isSelected[i] ? input[i] + " " : "");
                }
                System.out.println();
                return;
            }
            return;
        }
        if (sum>S) return;

        isSelected[cnt] = true;
        generateSubset2(cnt + 1, sum + input[cnt]);
        isSelected[cnt] = false;
        generateSubset2(cnt + 1, sum);

    }
}
