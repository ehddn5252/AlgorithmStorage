package com.ssafy.algorithm.day15SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Bj15686 치킨배달
public class ChickenDeliver {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static List<int[]> chicken = new ArrayList<int[]>();
    static List<int[]> combinationChicken = new ArrayList<int[]>();
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        map = new int[N][N];
        M = Integer.parseInt(s[1]);
        for (int i = 0; i < M; ++i) {
            combinationChicken.add(new int[]{});
        }

        for (int i = 0; i < N; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
                // 치킨집 리스트를 만든다. 각 집마다 치킨집과의 거리를 계산해 가장 거리가 짧은 것을 치킨거리로 둔다.
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }
        combination(0, 0);
        System.out.println(minResult);
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            calcu();
            return;
        }
        for (int i = start; i < chicken.size(); ++i) {
            combinationChicken.set(cnt, chicken.get(i));
            combination(cnt + 1, i + 1);
        }
    }

    // 조합써서 치킨집 몇 개를 구해놓고
    static void calcu() {
        int size = combinationChicken.size();
        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] != 1) continue;

                int minDistance = Integer.MAX_VALUE;
                int distance = Integer.MAX_VALUE;

                for (int k = 0; k < size; ++k) {
                    int[] s = combinationChicken.get(k);
                    distance = Math.abs(i - s[0]) + Math.abs(j - s[1]);
                    if (distance < minDistance) {
                        minDistance = distance;
                    }
                }
                result += minDistance;
                if (result >= minResult) {
                    return;
                }
            }
        }
        if (minResult > result) {
            minResult = result;
        }
    }
}