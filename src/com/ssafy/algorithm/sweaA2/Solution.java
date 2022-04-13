package com.ssafy.algorithm.sweaA2;

import java.io.*;
import java.util.*;

public class Solution {
    static int ans,W,H,map[][];
    static boolean[][] visited;
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx= {1,-1,1,0,-1,0,1,-1};
    static int[] dy= {-1,-1,0,1,0,-1,1,1};
    static int[][] ca = {{0,1,3},{2,4,5},{2,3,4},{5,6,7}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            ans=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            visited = new boolean[H][W];
            map = new int[H][W];

            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for (int j2 = 0; j2 < W; j2++) {
                    map[j][j2] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < H; j++) {
                total: for (int j2 = 0; j2 < W; j2++) {
                    Point[] p = new Point[4];
                    p[0] = new Point(j2,j);
                    visited[j][j2]=true;

                    DFS(0,p);

                    if (j2%2==0) {
                        for (int k = 0; k < 2; k++) {
                            int sum=map[j][j2];
                            for (int k2 = 0; k2 < 3; k2++) {
                                int nx=j2+dx[ca[k][k2]];
                                int ny=j+dy[ca[k][k2]];
                                if (nx<0||nx>=W||ny>=H||ny<0) continue total;
                                sum+=map[ny][nx];
                            }
                            ans=Math.max(ans, sum*sum);
                        }
                    } else {
                        for (int k = 2; k < 4; k++) {
                            int sum=map[j][j2];
                            for (int k2 = 0; k2 < 3; k2++) {
                                int nx=j2+dx[ca[k][k2]];
                                int ny=j+dy[ca[k][k2]];
                                if (nx<0||nx>=W||ny>=H||ny<0) continue total;
                                sum+=map[ny][nx];
                            }
                            ans=Math.max(ans, sum*sum);
                        }
                    }
                }
            }
            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
    }

    static void DFS(int cnt, Point[] pArr) {
        Point p = pArr[cnt];
        if (cnt==3) {
            int a=0;
            for(Point po:pArr) {
                a+=map[po.y][po.x];
            }
            ans=Math.max(ans, a*a);
            return;
        }
        int s = p.x%2*2;
        for (int i = s; i < s+6; i++) {
            int nx=p.x+dx[i];
            int ny=p.y+dy[i];

            if (nx>=0&&nx<W&&ny<H&&ny>=0&&!visited[ny][nx]) {
                visited[ny][nx]=true;
                pArr[cnt+1] = new Point(nx,ny);
                DFS(cnt+1,pArr);
                visited[ny][nx]=false;
            }
        }
    }

}
