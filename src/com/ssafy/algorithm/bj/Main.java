package com.ssafy.algorithm.bj;
// 용돈 관리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] intArray = new int[100000];
    static int N, M, answer;
    static int start = 1, end = 10000;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for (int i = 0; i < N; ++i) {
            intArray[i] = Integer.parseInt(br.readLine());
        }
        binarySearch(1, 10000, (start+end)/2);
        System.out.println(answer);
    }

    static int useMoney(int K) {
        int count = 1, rest = K;
        for (int i = 0; i < N; ++i) {
            if (intArray[i] > rest) {
                count += 1;
                rest = K - intArray[i];
            } else {
                rest = rest - intArray[i];
            }
        }
        return count;
    }

    static void binarySearch(int start, int end, int K) {

        // count 한 횟수가 M보다 더 적으면 돈을 줄일 수 있다. 줄여야 한다.
        // end를 줄인다.
        int count = useMoney(K);
        while (start < end) {
            if (count <= M) {
                answer = K;
                if (K+1==end){
                    return;
                }
                end = K+1;
                K = (start + end) / 2;
            }
            else {
                // 횟수가 더 많으면 돈을 늘려야 한다.
                // start를 늘린다.
                start = K;
                K = (start + end) / 2;
            }
            count = useMoney(K);
        }
    }
}