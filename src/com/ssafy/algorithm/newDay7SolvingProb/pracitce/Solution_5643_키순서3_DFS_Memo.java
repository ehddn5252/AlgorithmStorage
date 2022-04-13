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
public class Solution_5643_키순서3_DFS_Memo {

	static int N;
	static int[][] adjMatrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			
			// 인접행렬 : 0으로 자동 초기화(0: 키 관계를 모름, 1: 자신보다 키가 큰 학생과의 관계를 표현)
			adjMatrix = new int[N+1][N+1]; // 학생번호 1부터 시작하도록..
			
			for (int i = 1; i <= N; i++) adjMatrix[i][0] = -1; // 탐색 전을 나타내는 의미로 초기화
			
			
			StringTokenizer st = null;
			int a,b;
			for (int i = 0; i < M; i++) { // 간선 정보 입력받아 인접행렬에 표현
				st = new StringTokenizer(in.readLine()," "); // a b : a보다 b가 키가 크다
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				// 탐색 전인 학생들만 탐색
				if(adjMatrix[i][0] == -1) gtDFS(i);
			}
			
			// 자신보다 작은 학생수 카운트
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= N; i++) {
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			
			int answer = 0; // 자신의 키를 알수 있는 학생 수
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[i][0] + adjMatrix[0][i] == N-1) ++answer;
			}
			System.out.println("#"+tc+" "+answer);			
		}
	}

	static void gtDFS(int cur) {

		for (int i = 1; i <= N; i++) {
			if(adjMatrix[cur][i] != 0) { // 나보다 큰 학생이면
				if(adjMatrix[i][0] == -1) gtDFS(i); // 탐색 전이면 탐색하러 가기
				
				if(adjMatrix[i][0] > 0) { // i보다 큰 학생이 있다면
					// 나보다 큰 학생이 알고있는 다른 학생관의 키 관계를 나와의 직접 관계로 매핑
					// cur < i < j   ==>   cur < j
					for (int j = 1; j <= N; j++) {
						if(adjMatrix[i][j] == 1) {
							adjMatrix[cur][j] = 1;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += adjMatrix[cur][i];
		}
		adjMatrix[cur][0] = cnt;
	}


}
