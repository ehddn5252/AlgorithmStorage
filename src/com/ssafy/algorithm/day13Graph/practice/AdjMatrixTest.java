package com.ssafy.algorithm.day13Graph.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
public class AdjMatrixTest {
    static int N;

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int C = sc.nextInt();

        int[][] adjMatrix = new int[N][N];

        for (int i = 0; i < C; ++i) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }
        for (int[] is : adjMatrix) {
            System.out.println(Arrays.toString(is));
        }
        bfs(adjMatrix,0);
    }


    public static void bfs(int[][] adjMatrix, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char) (current + 65));

            for (int j = 0; j < N; ++j) {
                if (!visited[j] && adjMatrix[current][j] != 0) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}