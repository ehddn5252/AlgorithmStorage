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
public class Solution_5643_키순서4_Floyd {

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
			
			StringTokenizer st = null;
			int a,b;
			for (int i = 0; i < M; i++) { // 간선 정보 입력받아 인접행렬에 표현
				st = new StringTokenizer(in.readLine()," "); // a b : a보다 b가 키가 크다
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			} // 입력처리

			// 모든 쌍의 관계를 파악
			// 경 출 도
			for (int k = 1; k <= N; k++) { // 경유 학생
				for (int i = 1; i <= N; i++) { // 출발 학생(자신과 다른 학생과의 관계를 알고 싶은 학생)
					if(i==k || adjMatrix[i][k] == 0) continue;
					for (int j = 1; j <=N ; j++) { // 도착 학생(다른학생)
						if(adjMatrix[i][j]==1) continue;
						if(adjMatrix[k][j]==1) {
							adjMatrix[i][j] = 1;
						}
					}
				}
			}
			// 알수 있는 모든 쌍의 관계가 반영되어 있음.
			
			// 자신보다 큰, 작은 학생수 카운트 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
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
}
