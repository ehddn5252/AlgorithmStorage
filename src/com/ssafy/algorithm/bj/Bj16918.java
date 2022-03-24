package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj16918 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map1;
    static char[][] mapAllBoom;
    static char[][] mapReverse;
    static int rowNum, colNum, t;
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        map1 = new char[rowNum][colNum];
        mapAllBoom = new char[rowNum][colNum];
        mapReverse = new char[rowNum][colNum];
        t = Integer.parseInt(s[2]);
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < rowNum; ++i) {
            String inputS = br.readLine();
            for (int j = 0; j < colNum; ++j) {

                map1[i][j] = inputS.charAt(j);
                if (map1[i][j] == 'O') {
                    q.offer(new int[]{i, j});
                }
                mapAllBoom[i][j] = 'O';
                mapReverse[i][j] = 'O';
            }
        }
        BFS(q);
        if (t % 4 == 1) {
            printMap(map1);
        } else if (t % 4 == 3) {
            printMap(mapReverse);
        } else {
            printMap(mapAllBoom);
        }
    }

    static void printMap(char[][] map) {
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    static void BFS(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] positionInfo = q.poll();
            int row = positionInfo[0];
            int col = positionInfo[1];
            mapReverse[row][col] = '.';
            for (int i = 0; i < 4; ++i) {
                int dRow = row + d[i][0];
                int dCol = col + d[i][1];
                if (dRow >= 0 && dCol >= 0 && dRow < rowNum && dCol < colNum) {
                    mapReverse[dRow][dCol] = '.';
                }
            }
        }

    }
}
