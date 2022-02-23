package com.ssafy.algorithm.day14Graph2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST2_PrimTest {

    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = null;
        int[][] adjMatrix = new int[N][N];
        int[] minEdge = new int[N]; // 타정점에서 자신으로의 간선비용중 최소비용
        boolean[] visited = new boolean[N]; // 신장트리에 선택된 여부
        
        
        for(int i=0;i<N;++i){
            st = new StringTokenizer(in.readLine()," ");
            for(int j =0;j<N;++j){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0; // MST 비용
        minEdge[0]=0;

        for(int c=0;c<N;++c){  // N개의 정점을 모두 연결
            // 신장트리에 연결되지 않은 정점중 가장 유리한 비용의 정점을 선택
            int min = Integer.MAX_VALUE;
            int minVertex= 0;
            for(int i=0;i<N;++i){
                if(!visited[i]&& min>minEdge[i]){
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            // 선택된 정점을 신장트리에 포함시키
            visited[minVertex] = true;
            result += min;
            
            // 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간성비용을 따져보고 최솟값 갱신
            for(int i=0;i<N;++i){
                if(!visited[i] && adjMatrix[minVertex][i] !=0 && minEdge[i] > adjMatrix[minVertex][i]){
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}
