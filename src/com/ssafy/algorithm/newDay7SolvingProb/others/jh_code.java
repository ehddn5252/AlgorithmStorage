package com.ssafy.algorithm.newDay7SolvingProb.others;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class pos {
    int x;
    int y;

    public pos(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}

public class jh_code {
    static int N, ans;
    static boolean[][] visited;
    static int[][] map;
    static int[][] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = stoi(br.readLine());
            map = new int[N][N];
            depth = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = stoi(s[j]);
                }
            }
            depth[0][0] = map[0][0];

            ans = Integer.MAX_VALUE;
            bfs();
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void bfs() {
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(0, 0));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            pos p = q.poll();
            if (p.x == N - 1 && p.y == N - 1) {
                ans = Math.min(ans, depth[N - 1][N - 1]);
            }

            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N)
                    continue;

                if (!visited[x][y] || depth[x][y] > map[x][y] + depth[p.x][p.y]) {
                    visited[x][y] = true;
                    depth[x][y] = map[x][y] + depth[p.x][p.y];
                    q.add(new pos(x, y));
                }
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
