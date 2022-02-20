package com.ssafy.algorithm.day12SolvingProb.othersCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChanhoScale {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;

    static void permutate(int cnt, int right, int left, int[] weight, int N, boolean[] visited) {
        if (right > left) {
            return;
        }
        if (cnt == N) {
            ans++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    permutate(cnt + 1, right + weight[i], left, weight, N, visited);
                    permutate(cnt + 1, right, left + weight[i], weight, N, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] weight = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            boolean[] visited = new boolean[N];
            permutate(0, 0, 0, weight, N, visited);
            System.out.println("#" + t + " " + ans);
        }
    }
}
