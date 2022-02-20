package com.ssafy.algorithm.day12SolvingProb.othersCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ji1Scale {

    static int result;
    static int[] isSelected, fact;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            sb = new StringBuilder("#");
            int N = Integer.parseInt(br.readLine());
            int[] weights = new int[N];
            fact = new int[N + 1];
            fact[0] = 1;
            int tot = 0;
            isSelected = new int[N];
            result = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                weights[j] = Integer.parseInt(st.nextToken());
                tot += weights[j];
                fact[j + 1] = (j + 1) * fact[j];
            }
            perm(N, weights, 0, 0, 0, tot);
            sb.append(i).append(" ").append(result);
            System.out.println(sb);
        }
    }

    public static void perm(int N, int[] weights, int left, int right, int cnt, int r) {
        if (right > left) return;
        if (r + right < left) {
            result += (1<<(N - cnt)) * fact[N - cnt];
            return;
        }
        if (cnt == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSelected[i] != 0) continue;
            isSelected[i] = 1;
            perm(N, weights,left + weights[i], right, cnt + 1, r - weights[i]);
            isSelected[i] = 2;
            perm(N, weights, left, right + weights[i], cnt + 1, r - weights[i]);
            isSelected[i] = 0;
        }
    }

}