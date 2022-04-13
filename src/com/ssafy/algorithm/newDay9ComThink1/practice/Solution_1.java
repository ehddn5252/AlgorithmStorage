package com.ssafy.algorithm.newDay9ComThink1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// swea 8458 원점으로 모여라
public class Solution_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum + 1; ++testCaseIndex) {
            int N = Integer.parseInt(br.readLine());
            int max = 0;
            int tmp;
            boolean evenFlag=false;
            boolean oddFlag=false;
            for (int i = 0; i < N; ++i) {
                st= new StringTokenizer(br.readLine());
                tmp = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                if(tmp%2==0) evenFlag=true;
                else if(tmp%2==1) oddFlag=true;
                //성립이 되는 경우라면 최대값만 가지고 온다.
                if (max < tmp) max = tmp;
            }
            // 위치가 짝수와 홀수 둘다 있을 땐 안됨.
            if(evenFlag && oddFlag) System.out.println("#" + testCaseIndex + " " + -1);
            else System.out.println("#" + testCaseIndex + " " + mainLogic(max));
        }
    }
    private static int mainLogic(int max) {
        int num = 0;
        while (true) {
            max -= num;
            if (check(max)) return num;
            num++;
        }
    }

    // 계속 빼는 데, 모든 수가 마이너스이고 짝수일 때 성립
    private static boolean check(int max) {
        if (max > 0 || max % 2 != 0) return false;
        return true;
    }
}
