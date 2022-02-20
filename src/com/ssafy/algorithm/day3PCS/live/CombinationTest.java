package com.ssafy.algorithm.day3PCS.live;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {

    static int N,R;
    static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
    static boolean[] isSelected;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R];

        for( int i=0; i < N;i++){
            input[i] = sc.nextInt();
        }
        combination(0,0);
    }

    public static void combination(int cnt, int start){
        if (cnt ==R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start;i<N;++i){
            numbers[cnt] = input[i];
            // 다음 자리 수를 확인하고, 현재 뽑은 수의 다음 자리부터 시작한다.
            combination(cnt+1,i+1);
        }
    }


}
