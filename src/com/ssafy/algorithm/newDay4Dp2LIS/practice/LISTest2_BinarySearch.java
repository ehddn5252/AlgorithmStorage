package com.ssafy.algorithm.newDay4Dp2LIS.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author taeheekim
 */
public class LISTest2_BinarySearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int[] C = new int[N];
		
		for (int i = 0; i < N; i++) arr[i] = s.nextInt();
		
		int size = 0;
        for (int i=0; i < N; i++) {

            int temp = Arrays.binarySearch(C, 0, size, arr[i]); // 리턴값 : -insertPoint -1
            temp = Math.abs(temp)-1;//삽입위치
            C[temp] = arr[i];// temp 자리에 값을 update 하면 그 의미는 
            			     // 0인덱스 위치부터 temp위치까지의 원소 갯수가  temp위치에 저장된 그 값을 마지막으로 하는 LIS 길이가 됨
            				 // 배열의 원소가 LIS를 이루는 구성요소와는 관계가 없다.

            if (size == temp) {// 삽입위치의 인덱스와 크기가 같으면(결국,마지막이 삽입위치라는 얘기임) 크기 1늘림.
                size++;
            }
        }
        System.out.println(size);
	}

}
