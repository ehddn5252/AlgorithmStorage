package com.ssafy.algorithm.day3PCS.live;

import java.util.Scanner;

public class SubSetTest {

    static int N, input[];
    static boolean[] isSelected;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        input = new int[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N;++i){
            input[i] = sc.nextInt();
        }
        generateSubset(0);
    }

    public static void generateSubset(int cnt){ // 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수

        if(cnt==N) { //마지막 원소까지 부분집합에 다 고려된 상황

            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        // 현재 원소를 선택
        isSelected[cnt] = true;
        generateSubset(cnt+1);
        // 현재 원소를 비선택
        isSelected[cnt] = false;
        generateSubset(cnt+1);
    }
}
