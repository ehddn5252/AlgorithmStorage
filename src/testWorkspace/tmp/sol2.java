package testWorkspace.tmp;


import java.io.*;
import java.util.*;

public class sol2 {
    static int ans,N,M,map[][],dp[][];
    static boolean[][] visited;
    static Point start,end;
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx= {0,0,1,-1};
    static int[] dy= {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            ans=Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];
            dp = new int[N][M];


            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int j2 = 0; j2 < M; j2++) {
                    map[j][j2] = Integer.parseInt(st.nextToken());
                    if (map[j][j2]==2) start=new Point(j,j2);
                    if (map[j][j2]==3) end=new Point(j,j2);
                    dp[j][j2]=Integer.MAX_VALUE;
                }
            }
            visited[start.x][start.y]=true;
            DFS(0,start);
            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
    }

    static void DFS(int maxH, Point p) {
        if (maxH>ans) return;
        if (p.x==end.x&&p.y==end.y) {
            ans=Math.min(ans, maxH);
            return;
        }


        total:for (int i = 0; i < 4; i++) {
            int d=0;
            int nx=p.x;
            int ny=p.y;
            if (i>1) {
                while (true) {
                    d++;
                    nx+=dx[i];
                    ny+=dy[i];

                    if (nx<0||nx>=N||ny>=M||ny<0||maxH>=dp[nx][ny]) continue total;
                    if (map[nx][ny]==1||map[nx][ny]==3) {
                        maxH=Math.max(maxH, d);
                        dp[nx][ny]=Math.min(dp[nx][ny], maxH);
                        DFS(maxH, new Point(nx,ny));
                        break;
                    }
                }
            } else {
                nx+=dx[i];
                ny+=dy[i];
                if (nx<0||nx>=N||ny>=M||ny<0||maxH>=dp[nx][ny]||map[nx][ny]==0) continue;
                dp[nx][ny]=Math.min(dp[nx][ny], maxH);
                DFS(maxH, new Point(nx,ny));
            }
        }
    }
}