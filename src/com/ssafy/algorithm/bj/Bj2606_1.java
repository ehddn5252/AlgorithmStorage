package com.ssafy.algorithm.bj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// virus BFS 로 풀기
public class Bj2606_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adjMatrix;
    static boolean[] visit;
    static int N,ans;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N+1][N+1];
        visit=new boolean[N+1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adjMatrix[a][b]=1;
            adjMatrix[b][a]=1;
        }
        BFS();
        tourVisit();
        System.out.println(ans);
    }
    static void BFS(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        while(!q.isEmpty()){
            int popped = q.poll();
            for(int i=1;i<N+1;++i){
                if(adjMatrix[popped][i]!=1) continue;
                if(visit[i]) continue;
                q.add(i);
                visit[i]=true;
            }
        }
    }
    static void tourVisit(){
        for(int i=2;i<N+1;++i){
            if(visit[i]==true){
                ans+=1;
            }
        }
    }
}
