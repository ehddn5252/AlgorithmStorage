package com.ssafy.algorithm.newDay7SolvingProb.pracitce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author kimtaehee
 */
public class Solution_5643_키순서2_DFS2 {

	static int N;
	static int[][] adjMatrix,radjMatrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			
			// 인접행렬 : 0으로 자동 초기화(0: 키 관계를 모름, 1: 자신보다 키가 큰 학생과의 관계를 표현)
			adjMatrix = new int[N+1][N+1]; // 학생번호 1부터 시작하도록..
			radjMatrix = new int[N+1][N+1]; // 학생번호 1부터 시작하도록..
			
			StringTokenizer st = null;
			int a,b;
			for (int i = 0; i < M; i++) { // 간선 정보 입력받아 인접행렬에 표현
				st = new StringTokenizer(in.readLine()," "); // a b : a보다 b가 키가 크다
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				radjMatrix[b][a] = adjMatrix[a][b] = 1;
			}
			
			int answer = 0; // 자신의 키를 알수 있는 학생 수
			for (int i = 1; i <= N; i++) {
				cnt=0;
				DFS(i, new boolean[N+1],adjMatrix); // 나보다 큰 학생 탐색
				DFS(i, new boolean[N+1],radjMatrix); // 나보다 작은 학생 탐색
				if(cnt == N-1) ++answer;
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	static int cnt=0;
	static void DFS(int cur,boolean[] visited,int[][] adjM) {
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { // 모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
			if(adjM[cur][i] != 0 && !visited[i]) {
				++cnt;
				DFS(i, visited,adjM);
			}
		}
	}
}










