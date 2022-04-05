package com.ssafy.algorithm.newDay4Dp2LIS.practice;

import java.util.Scanner;

/**
 * @author taeheekim
 */
public class LISTest1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N]; // 각수를 끝에 세울수 있는 최장길이
		
		for (int i = 0; i < N; i++) arr[i] = s.nextInt();
		
		int max = 0;
		for(int i=0; i<N; ++i) { // 기존 증가수열에 덧붙일 대상
			LIS[i] = 1; // 일단 현재의 수만 수열에 넣었을때 길이로 초기화.
			for(int j=0; j<i; ++j) { // 결국, 자신의 앞쪽에 세울수 있는(자신보다 작은) 애 중에 가장 긴 최장길이에 자신을 붙인다.
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {  // 최대값 갱신 
					LIS[i] = LIS[j]+1;
				}
			}// 결국, LIS[i]에는 자신을 끝으로 하는 최대값이 저장되어 있음
			
			// 최장길이최대값 갱신 
			if(max<LIS[i]) max = LIS[i];
		}

		System.out.println(max);
	}

}
