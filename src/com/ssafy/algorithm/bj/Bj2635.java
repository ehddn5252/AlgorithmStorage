package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2635 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = N / 2;
        int ansNum = Integer.MIN_VALUE;
        numbers = new int[100];
        int[] ansNumbers = new int[100];
        numbers[0] = N;

        for (int i = K; i < N+1; ++i) {
            numbers[1] = i;
            int nextNumber = numbers[0] - numbers[1];
            int startIndex = 2;
            while (nextNumber >= 0) {
                numbers[startIndex] = nextNumber;
                nextNumber = numbers[startIndex - 1] - numbers[startIndex];
                startIndex += 1;
            }
            if (startIndex > ansNum) {
                ansNumbers = Arrays.copyOf(numbers, numbers.length);
                ansNum = startIndex;
            }
            //numbers = new int[10000];
        }
        System.out.println(ansNum);
        for (int i = 0; i < ansNum; ++i) {
            if (i == ansNum - 1){
                System.out.print(ansNumbers[i]);
                break;
            }
            System.out.print(ansNumbers[i] + " ");
        }
    }
}
