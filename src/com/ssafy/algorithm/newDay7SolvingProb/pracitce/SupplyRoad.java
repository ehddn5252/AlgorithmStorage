package com.ssafy.algorithm.newDay7SolvingProb.pracitce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SupplyRoad {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map, dp, d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, ans;
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; ++i) {
                char[] s = br.readLine().toCharArray();
                for (int j = 0; j < N; ++j) {
                    map[i][j] = s[j] - '0';
                    dp[i][j] = INF;
                }
            }
            mainLogic();
//            print();
            System.out.println("#" + testCaseIndex + " " + dp[N-1][N-1]);
        }
    }

    // 방법 생각: 가는 경로에서 합이 가장 작아야 한다. dp를 생각하면 좋을 듯
    // 생각나는 것은 DFS 와 DP N의 크기는 100 * 100
    // 가는 길마다 값을 더해줘야 한다.
    // 그러면 왼쪽에서 오른쪽으로만 움직이면 안되고, 미로찾기처럼 모든 경우를 다 봐야한다.
    // 그렇다면 BFS 를 사용해야 할 듯 BFS와 DP 동시에 사용
    // 일단 dp 사용해보자.
    private static void mainLogic() {
        dp[0][0]=0;
        Queue<Pos> q = new LinkedList<Pos>();
        q.offer(new Pos(0, 0));
        while (!q.isEmpty()) {
            Pos polled = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextI = polled.i + d[i][0];
                int nextJ = polled.j + d[i][1];
                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                    if (dp[nextI][nextJ] > dp[polled.i][polled.j] + map[nextI][nextJ]) {
                        dp[nextI][nextJ] = dp[polled.i][polled.j] + map[nextI][nextJ];
                        q.offer(new Pos(nextI,nextJ));
                    }
                }
            }
        }
    }


    private static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}