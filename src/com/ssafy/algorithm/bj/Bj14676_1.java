package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj14676_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 건물 종류의 개수
        int M = Integer.parseInt(s[1]); // 건물 사이의 관계의 개수
        int K = Integer.parseInt(s[2]); // 영우의 게임 정보의 개수 1은 건설 2는 파괴

        map = new int[N][N];
        // 2차원 배열을 1차원으로 바꿔주기 -> linkedList,
        // 중복 건설
        for (int i = 0; i < M; ++i) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]) - 1;
            int end = Integer.parseInt(s[1]) - 1;
            map[end][start] = 1;
        }

        for (int i = 0; i < K; ++i) {
            s = br.readLine().split(" ");
            int command = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]) - 1;
            if (command == 1) {
                for (int j = 0; j < map.length; ++j) {
                    // 의존관계에서 기존에 생성해야 할 게 있다.
                    if (map[end][j] == 1) {
                        System.out.println("Lier!");
                        return;
                    }
                }
                // 여기로 가는 것들은 모두 ok라는 뜻
                for (int j = 0; j < map.length; ++j) {
                    if (map[j][end] == 1) {
                        map[j][end] = 2;
                    }
                }
            }else if (command == 2) {
                boolean isNotLier = true;
                for (int j = 0; j < map.length; ++j) {
                    if (map[j][end] == 1) {
                        isNotLier = false;
                    }
                }
                if (!isNotLier) {
                    System.out.println("Lier!");
                    return;
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}
