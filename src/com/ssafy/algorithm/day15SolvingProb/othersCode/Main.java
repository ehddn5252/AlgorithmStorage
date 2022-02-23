package com.ssafy.algorithm.day15SolvingProb.othersCode;
// 아기상어
import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[][] arr;

    static int sharkRow;
    static int sharkCol;

    static int sharkSize = 2;
    static int sharkEat = 0;
    static int time = 0;


    static int[] dRow = {1, 0, 0, -1};
    static int[] dCol = {0, -1, 1, 0};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    sharkRow = i;
                    sharkCol = j;
                    arr[i][j] = 0;
                }
            }
        }

        PriorityQueue<Capsule> pq = new PriorityQueue<Capsule>(new Comparator<Capsule>() {

            @Override
            public int compare(Capsule o1, Capsule o2) {
                if(o1.count == o2.count) {
                    if(o1.row == o2.row) {
                        return (o1.col <= o2.col)? -1 : 1;
                    }

                    return (o1.row <= o2.row)? -1 : 1;
                }

                return (o1.count <= o2.count)? -1 : 1;
            }
        });


        boolean[][] visited = new boolean[N][N];
        visited[sharkRow][sharkCol] = true;
        pq.add(new Capsule(sharkRow, sharkCol, 0));

        while(!pq.isEmpty()) {
            Capsule now = pq.poll();

            if(arr[now.row][now.col] != 0 && arr[now.row][now.col] < sharkSize) {
                sharkEat++;
                if(sharkEat == sharkSize) {
                    sharkSize++;
                    sharkEat = 0;
                }

                time += now.count;

                visited = new boolean[N][N];
                sharkRow = now.row;
                sharkCol = now.col;
                arr[sharkRow][sharkCol] = 0;
                visited[sharkRow][sharkCol] = true;

                pq.clear();
                pq.add(new Capsule(now.row, now.col, 0));
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int row = now.row + dRow[i];
                int col = now.col + dCol[i];

                if(row < 0 || N <= row || col < 0 || N <= col) {
                    continue;
                }

                if(visited[row][col]) {
                    continue;
                }

                if(sharkSize < arr[row][col]) {
                    continue;
                }

                pq.add(new Capsule(row, col, now.count+1));
                visited[row][col] = true;

            }

        }
        System.out.println(time);
    }
    static class Capsule{
        int row;
        int col;
        int count;

        public Capsule(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}