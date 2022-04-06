package com.ssafy.algorithm.newDay6SolvingProb.assignment;
// 과제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum+1; ++testCaseIndex) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            for (int i = 0; i < M; ++i) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                map[start][end] = 1;
            }
            // 나의 위치는 나보다 큰사람 수와 나보다 작은 사람의 수를 알면 된다.
            // 나보다 큰 사람의 수를 구하는 방법은 내가 가리키는 사람의 수를 구하면 된다. (visit 해서 중복 제거하기)
            int ans = 0;
            for (int i = 1; i < N + 1; ++i) {
                visit = new boolean[N + 1];
                int count = 0;
                check(i,true);
                check(i,false);
                for (int j = 1; j < visit.length; ++j) if (visit[j]) count += 1;
                if (count == N) ans++;
            }
            System.out.println("#" + testCaseIndex + " " + ans);
        }
    }

    private static void check(int num, boolean isBiggerCheck) {
        visit[num] = true;
        for (int i = 1; i < map.length; ++i) {
            if (isBiggerCheck && map[num][i] != 1) continue;
            else if (!isBiggerCheck && map[i][num] != 1) continue;
            if(!visit[i]) check(i, isBiggerCheck);
        }
    }
}