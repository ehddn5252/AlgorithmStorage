package com.ssafy.algorithm.newDay6SolvingProb.others;

import java.io.*;
import java.util.*;

public class Solution {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        int[][] dl = {{1,0},{0,1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map=new int[M+1][N+1];

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 세로면 -1, 가로면 -2
            if (a==c) {
                map[Math.min(b, d)][a]=map[Math.min(b, d)][a]==-2?-3:-1;
            } else {
                map[b][Math.min(a,c)]=map[b][Math.min(a,c)]==-1?-3:-2;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        long[][] dir=new long[M+1][N+1];
        dir[0][0] = 1;
        boolean[][] visited = new boolean[M+1][N+1];

        int[][] sum = new int[M+1][N+1];

        int z=0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(map[now.y][now.x]!=-3) {
                if(!(map[now.y][now.x]==-2)&&now.x<N) {
                    dir[now.y][now.x+1] +=dir[now.y][now.x];
                }
                if(!(map[now.y][now.x]==-1)&&now.y<M){
                    dir[now.y+1][now.x] +=dir[now.y][now.x];
                }
            }
            for (int i = 0; i < 2; i++) {
                int nx = now.x+dl[i][1];
                int ny = now.y+dl[i][0];
//            if(nx<=N&&ny<=M) {

//            }
                if(nx<=N&&ny<=M&&!visited[ny][nx]) {
                    sum[ny][nx]=z++;
                    q.add(new Point(nx,ny));
                    visited[ny][nx]=true;
                }
            }
        }

//      System.out.println(dir[0][1]);
        System.out.println(dir[M][N]);
    }
}