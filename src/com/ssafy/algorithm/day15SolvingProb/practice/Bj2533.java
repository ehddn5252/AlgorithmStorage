package com.ssafy.algorithm.day15SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2533 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int N;
    static boolean visit[];
    static final int EARLY_ADOPTER=1;
    static final int NORMAL_ADOPTER=0;
    static int count;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N - 1; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }
        Queue<int[]> q= new LinkedList<int[]>();
        q.offer(new int[]{1,EARLY_ADOPTER,1});
        count=1;
        visit = new boolean[N+1];
        BFS(q);
        int case1Count = count;
        q= new LinkedList<int[]>();
        count = 0;
        q.offer(new int[]{1,NORMAL_ADOPTER,0});
        visit = new boolean[N+1];
        BFS(q);
        int case2Count = count;
        System.out.println(Math.min(case1Count,case2Count));
    }

    static void BFS(Queue<int[]> q){
        visit[1]=true;
        //
        while(!q.isEmpty()){
            int[] popped = q.poll();
            for(int i=1;i<N+1;++i){
                if(map[popped[0]][i]!=1)continue;
                if (visit[i]) continue;
                visit[i]=true;
                if(popped[1]==EARLY_ADOPTER){
                    q.offer(new int[] {i,NORMAL_ADOPTER});
                }
                else{
                    count+=1;
                    q.offer(new int[] {i,EARLY_ADOPTER});
                }
            }
        }
    }
    // 일단 루트노드를 찾아야 한다.
    // 루트 노드를 찾고 나서는 루트 노드에서 연결된 노드마다 leaf 노드까지의 개수를 구한다.
    // 각 분기의 노드 depth 가 홀수이면 짝수번째 노드가 얼리어답터가 되어야 해고,
    // 분기의 노드 depth 가 짝수면 홀수번째 노드가 얼리어답터가 되어야 한다.
    //

    /*
    풀이방법:
    1. 루트노드 찾는다.
    2. 루트노드부터 BFS 를 한다. 
    이때 루트노드부터 얼리어뎁터인 것, 루트노드가 얼리어답터가 아닌 것 으로 각각 시작해서 얼리어답터 수를 구한다.
    3. 두 경우중 얼리 어답터의 수 최저가 답이 된다.
    // 루트노드를 우째 구하누?
    // 루트 노드를 구할 필요가 없다 -> 그냥 하나의 정점에서 시작하면 됨.
     */

}
