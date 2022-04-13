package com.ssafy.algorithm.sweaA2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sss {
    static int W, H;
    static int[][] arr;
    static boolean[][] check;
    static ArrayList<Point> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H + 1][W + 1];
            check = new boolean[H + 1][W + 1];
            list = new ArrayList<>();
            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    check[i][j] = true;
                    list.add(new Point(i, j));
                    dfs(arr[i][j], 1);
                    list.remove(0);
                    check[i][j] = false;
                }
            }

            int result = (int) Math.pow(max, 2);

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);

    }

    static int[] dx = {1, 1, -1, 0, 1, 0, -1, -1};
    static int[] dy = {-1, 1, 0, -1, 0, 1, -1, 1};
    static int max = 0;

    public static void dfs(int sum, int dept) {
        if (dept == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < list.size(); i++) {

            int x = list.get(i).x;
            int y = list.get(i).y;

            int t;
            int num = (x - 1) * W + y;
            if (x % 2 != 0) {
                if (num % 2 == 0) t = 0;
                else t = 2;
            } else {
                if (num % 2 == 0) t = 2;
                else t = 0;
            }

            for (int k = t; k < t + 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 1 && ny >= 1 && nx <= H && ny <= W && !check[nx][ny]) {
                    check[nx][ny] = true;
                    list.add(new Point(nx, ny));
                    dfs(sum + arr[nx][ny], dept + 1);
                    list.remove(dept);
                    check[nx][ny] = false;
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}