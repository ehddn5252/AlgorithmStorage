
package com.ssafy.algorithm.newDay6SolvingProb.assignment;
// 과제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static final int INF = 999999;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 0; testCaseIndex < testCaseNum; ++testCaseIndex) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            for (int i = 0; i < M; ++i) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                map[start][end] = 1;
            }
            print();
            // 나의 위치는 나보다 큰사람 수와 나보다 작은 사람의 수를 알면 된다.
            // 나보다 큰 사람의 수를 구하는 방법은 내가 가리키는 사람의 수를 구하면 된다. (visit 해서 중복 제거하기)
            int ans = 0;
            for (int i = 1; i < N + 1; ++i) {
                visit = new boolean[N + 1];
                int count = 0;
                checkBigger(i);
                checkSmaller(i);
//                System.out.println(Arrays.toString(visit));
                for (int j = 1; j < visit.length; ++j) if (visit[j]) count += 1;

                if (count == N - 1)
                    ans++;
            }
            System.out.println("#" + testCaseIndex + " " + ans);
        }
    }

    private static void checkBigger(int num) {
        visit[num] = true;
        for (int i = 1; i < map.length; ++i) {
            if (map[num][i] == 1 && !visit[i]) checkBigger(i);
        }
    }

    private static void checkSmaller(int num) {
        visit[num] = true;
        for (int i = 1; i < map.length; ++i) {
            if (map[i][num] == 1 && !visit[i]) checkSmaller(i);
        }
    }


    private static void print() {
        for (int i = 1; i < map.length; ++i) {
            for (int j = 1; j < map[0].length; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}