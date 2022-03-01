package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 연산자 끼워넣기

/*
1. 숫자 N 개가 주어지고 연산자 N-1 개가 주어진다.
2. 연산자 우선순위 상관없이 숫자 사이에 연산자를 끼워넣어서 나올 수 있는 값의 최대와 최소를 구하라.
(permutation 사용)
 */
public class Bj14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] numbers;
    static boolean[] visit;
    static int[] operatorList;
    static int plusNum, minusNum, multiplyNum, divisionNum;
    static int resultMin = Integer.MAX_VALUE, resultMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operatorList = new int[N];
        visit = new boolean[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(s[i]);
        }

        // 0은 더하기, 1은 빼기, 2는 곱하기, 3은 나누기

        s = br.readLine().split(" ");
        plusNum = Integer.parseInt(s[0]);
        minusNum = Integer.parseInt(s[1]);
        multiplyNum = Integer.parseInt(s[2]);
        divisionNum = Integer.parseInt(s[3]);
        operatorList[0] = 0;
        int indexNum = 1;
        for (int i = 0; i < plusNum; ++i) {
            operatorList[indexNum] = 0;
            indexNum += 1;
        }
        for (int i = 0; i < minusNum; ++i) {
            operatorList[indexNum] = 1;
            indexNum += 1;
        }
        for (int i = 0; i < multiplyNum; ++i) {
            operatorList[indexNum] = 2;
            indexNum += 1;
        }
        for (int i = 0; i < divisionNum; ++i) {
            operatorList[indexNum] = 3;
            indexNum += 1;
        }
        permu(1, numbers[0]);
        System.out.println(resultMax);
        System.out.println(resultMin);
    }

    static void permu(int cnt, int calcResult) {
        if (cnt == N) {
            if (calcResult > resultMax) resultMax = calcResult;
            if (calcResult < resultMin) resultMin = calcResult;
            return;
        }

        for (int i = 1; i < N; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            if (operatorList[i] == 0) {
                permu(cnt + 1, calcResult + numbers[cnt]);
            } else if (operatorList[i] == 1) {
                permu(cnt + 1, calcResult - numbers[cnt]);
            } else if (operatorList[i] == 2) {
                permu(cnt + 1, calcResult * numbers[cnt]);
            } else if( operatorList[i] == 3 ){
                if(calcResult <0){
                    permu(cnt+1,-(Math.abs(calcResult) / numbers[cnt]));
                }
                else{
                    permu(cnt + 1, calcResult / numbers[cnt]);
                }
            }
            visit[i]=false;
        }
    }
}
