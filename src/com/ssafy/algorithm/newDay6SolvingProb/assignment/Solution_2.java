package com.ssafy.algorithm.newDay6SolvingProb.assignment;
import java.io.*;
import java.util.Scanner;
// 숏코딩. 이거 우째 줄이냐 ㄷㄷ
public class Solution_2 {
    static int[][] m;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int tt = 1; tt < t +1; ++tt) {
            int N = s.nextInt();
            int M = s.nextInt();
            m = new int[N + 1][N + 1];
            for (int i = 0; i < M; ++i) {
                int g = s.nextInt();
                int e = s.nextInt();
                m[g][e] = 1;
            }
            int a = 0;
            for (int i = 1; i < N + 1; ++i) {
                v = new boolean[N + 1];
                int n = 0;
                c(i,true);
                c(i,false);
                for (int j = 1; j < v.length; ++j) if (v[j]) n += 1;
                if (n == N) a++;
            }
            System.out.println("#" + tt + " " + a);
        }
    }

    private static void c(int num, boolean b) {
        v[num] = true;
        for (int i = 1; i < m.length; ++i) {
            if (b && m[num][i] != 1) continue;
            else if (!b && m[i][num] != 1) continue;
            if(!v[i]) c(i, b);
        }
    }
}