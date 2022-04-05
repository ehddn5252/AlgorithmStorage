package com.ssafy.algorithm.newDay3DpSolveProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj4485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map, dp;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                    dp[i][j] = Integer.MAX_VALUE; // max 값으로 채운다.
                }
            }
            mainLogic();
            System.out.println("Problem " + count + ": " + dp[N - 1][N - 1]);
            count++;
        }
    }

    static void mainLogic() {

        // // 초기값 설정
        dp[0][0] = map[0][0];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        // BFS 로 dp 맵을 최신화해준다.
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int nowI = polled[0];
            int nowJ = polled[1];
            for (int i = 0; i < 4; ++i) {
                int nextI = nowI + d[i][0];
                int nextJ = nowJ + d[i][1];
                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N && dp[nextI][nextJ] > dp[nowI][nowJ] + map[nextI][nextJ]) {
                    dp[nextI][nextJ] = dp[nowI][nowJ] + map[nextI][nextJ];
                    q.offer(new int[]{nextI, nextJ});
                }
            }
        }
    }
}
