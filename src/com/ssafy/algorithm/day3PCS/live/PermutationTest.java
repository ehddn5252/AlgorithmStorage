package com.ssafy.algorithm.day3PCS.live;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {

    static int N,R;
    static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
    static boolean[] isSelected;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R];
        isSelected = new boolean[N];

        for( int i=0; i < N;i++){
            input[i] = sc.nextInt();
        }
        permutation(0);

    }

    // 현재 자리에 수 뽑기
    public static void permutation(int cnt){

        // 기본 파트
        if (cnt == R){
            System.out.println(Arrays.toString(numbers));
        }

        // 입력받은 모든 수를 현재 자리에 넣어보기
        for(int i=0; i<N; i++){
            // 기존자리의 수들과 중복되는지 체크
            if(isSelected[i]) continue;

            numbers[cnt] = input[i];
            isSelected[i] = true;
            // 다음 수 뽑으러 가기
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
