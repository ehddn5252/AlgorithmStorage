package com.ssafy.algorithm.newDay4Dp2LIS.practice;

import java.util.Scanner;

/**
 * @author taeheekim
 */
public class Floyd {

	static final int INF = 9999999;
	static int N,adjMatrix[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				adjMatrix[i][j] = sc.nextInt();
				if(i != j && adjMatrix[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					adjMatrix[i][j]=INF;
				}
			}
		}
		System.out.println("===========입력==========");
		print();
        // 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}
			print();
		}
	
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}
