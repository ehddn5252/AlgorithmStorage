package com.ssafy.algorithm.newDay6SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2239_sudoku {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[9][9];
    static boolean retFlag = false;

    public static void main(String[] args) throws IOException {
        Queue<Pos> q = new LinkedList<Pos>();
        for (int i = 0; i < 9; ++i) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < 9; ++j) {
                map[i][j] = s[j] - '0';
                if (map[i][j] == 0) {
                    q.offer(new Pos(i, j));
                }
            }
        }
        sudoku(qClone(q));
    }

    /*
    1. 스도쿠는 3x3 에 1부터 9까지 모든 숫자가 있어야 한다.
    2. 한 줄에는 1부터 9까지의 숫자가 모두 있어야 한다.

    생각나는 방법:
    1. 백트레킹으로 DFS 로 모든 경우를 확인한다.
    2. DP??

    1. 1부터 9까지의 숫자를 적어놓고 만약 0이 있는 경우에 q에 넣는다.
    2. q를 빼고 1~9까지 다 넣어보는 DFS 한다.
    */

    private static Queue<Pos> qClone(Queue<Pos> q) {
        Queue<Pos> newQ = new LinkedList<Pos>();
        for (Pos p : q) newQ.add(p);
        return newQ;
    }

    private static void printMap() {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j)
                System.out.print(map[i][j]);
            System.out.println("");
        }
    }

    private static void sudoku(Queue<Pos> q) {
        if (retFlag) return;
        if (q.isEmpty()) {
            printMap();
            retFlag = true;
            return;
        }
        if (!q.isEmpty()) {
            Pos polled = q.poll();
            for (int k = 1; k < 10; ++k) {
                if (map[polled.i][polled.j] == 0) {
                    map[polled.i][polled.j] = k;
                    if (rowColCheck(polled.i, polled.j) && sectionCheck(polled.i, polled.j)) sudoku(qClone(q));
                    map[polled.i][polled.j] = 0;
                }
            }
        }
    }

    private static boolean rowColCheck(int nowI, int nowJ) {
        int[] arrays = new int[10];
        boolean ret = true;
        for (int i = 0; i < 9; ++i) arrays[map[i][nowJ]] += 1;
        for (int i = 1; i < 10; ++i) if (arrays[i] > 1) return false;

        arrays = new int[10];
        for (int i = 0; i < 9; ++i) arrays[map[nowI][i]] += 1;
        for (int i = 1; i < 10; ++i) if (arrays[i] > 1) return false;

        return ret;
    }

    private static boolean sectionCheck(int nowI, int nowJ) {
        boolean ret = true;
        int addSectionI = nowI / 3 * 3;
        int addSectionJ = nowJ / 3 * 3;

        int[] arrays = new int[10];
        for (int i = 0 + addSectionI; i < addSectionI + 3; ++i)
            for (int j = 0 + addSectionJ; j < addSectionJ + 3; ++j)
                arrays[map[i][j]] += 1;

        for (int i = 1; i < 10; ++i) if (arrays[i] > 1) return false;
        return ret;
    }

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
