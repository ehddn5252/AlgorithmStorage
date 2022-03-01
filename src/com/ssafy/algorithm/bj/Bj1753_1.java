package com.ssafy.algorithm.bj;
/*
1. 시작 정점과 다른 정점사이의 거리 배열을 만든다.
2. 방문했는 지 확인하는 배열 만든다.
3. 각 정점사이의 거리를 나타내는 인접 행렬을 만든다.
4. 세팅을 다 했다면 주변 노드와의 거리를 검색해본다.
5. 검색해보고
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1753_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V,E,startVertex;
    static int[][] adjMatrix;
    static boolean[] visit;
    static int[] dFromStart;
    public static void main(String[] args) throws IOException {
        String[] s =br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        adjMatrix = new int[V+1][V+1];
        visit = new boolean[V+1];
        dFromStart = new int[V+1];
        int start = Integer.parseInt(br.readLine());
        for(int i=0;i<E;++i) {
            s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            adjMatrix[from][to] = weight;
        }

        Arrays.fill(dFromStart, Integer.MAX_VALUE);
        dFromStart[start]=0;
        //visit[start]=true;
        for(int i=1;i<V+1;++i){
            // 단계 1 : 최소 비용이 확정되지 않은 정점중 최소비용의 정점 선택
            int min = Integer.MAX_VALUE,current = 0;
            for(int j=1;j<V+1;++j){
                if(!visit[j] && min>dFromStart[j]){
                    min = dFromStart[j];
                    current = j;
                }
            }

            visit[current] = true;
            // 단계 2: 선택된 정점을 경유지로 하여 아직 최소 비용이 확정되지 않은 다른 정점의 최소비용 고려
            for(int j=1;j<V+1;++j){
                if(!visit[j] && adjMatrix[current][j] !=0 &&
                dFromStart[j]> dFromStart[current] + adjMatrix[current][j]){
                    dFromStart[j] = dFromStart[current] + adjMatrix[current][j];
                }
            }
        }

        for(int i=1;i<dFromStart.length;++i){
            if(dFromStart[i]!=Integer.MAX_VALUE){
                System.out.println(dFromStart[i]);
            }
            else{
                System.out.println("INF");
            }
        }
    }
}
