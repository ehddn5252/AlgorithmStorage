package com.ssafy.algorithm.day13Graph.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
tc
4 5 1
1 2
1 3
1 4
2 4
3 4
 */

public class Bj1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    static int N,M,V;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        String[] s =br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);
        adjMatrix = new int[N+1][N+1];
        for(int i=0;i<M;++i){
            String[] s2 = br.readLine().split(" ");
            adjMatrix[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = 1;
            adjMatrix[Integer.parseInt(s2[1])][Integer.parseInt(s2[0])] = 1;
        }
        boolean[] visited = new boolean[N+1];
        DFS(V,visited);
        System.out.println();
        BFS(V);
    }


    static void DFS(int start,boolean[] visited){
        for(int i=1;i<=N;++i){
            if(visited[start]==false){
                visited[start]=true;
                System.out.print(start+" ");
            }
            if (adjMatrix[start][i]==1 && visited[i]==false){
                DFS(i,visited);
            }
        }
    }

    static void BFS(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[N+1];
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int s = q.poll();
            System.out.print(s+" ");
            for(int i=1;i<N+1;++i){
                if(visited[i]) continue;
                if(adjMatrix[s][i]==1){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println("");
    }
}
