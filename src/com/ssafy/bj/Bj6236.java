package com.ssafy.bj;
// 용돈 관리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 헌우는 용돈을 효율적으로 활용하기 위해 계획을 짜기로 했다.
2. N 일동안 자신이 사용할 금액을 계산, M 번만 통장에서 돈을 빼서 쓰기로 했다.
3. 헌우는 통장에서 K원을 인출하며, 모자라면 다시 집어놓고 K원을 인출한다.
4. 헌우는 M 이라는 숫자를 좋아하기 때문에, 정확히 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많아도 집어놓고
다시 K원을 인출하려 한다.
5.

N은 일수
M은 인출하는
K 를 구하시오

예시
7 5
100
400
300
100
500
101
400

7일동안 5번 돈을 꺼내야 한다.
K가 500원이고 돈 꺼낸 횟수 count 를 0이라고하자.
-----
첫날 100원 써야한다. 500원(K)꺼내고 count++, 100씀. 현재 남은 돈 400원. count=1
둘째날 400원 써야한다. 어제 남은 돈 400 - 400. 현재 남은돈 0원
셋째날 300원 써야한다. 어제 남은돈 0원 다시 500(K)을 꺼냄 500 - 300. 현재 200원 count=2
넷째날 100원 써야한다. 어제 남은 돈200 - 100. 현재 100원, count = 2
다섯째날 500원 써야한다. 어제 남은돈 100원이라 다시 100원 넣고 500원 꺼내와서 쓴다 500 - 500. 현재 0원 count=3;
여섯째날 101원 써야한다. 어제 남은돈 0원 다시 500을 꺼냄. 500-101. 현재 399원. count=4
일곱째날(마지막날) 400원 써야한다. 어제 남은 돈 399원 400원 보다 작으므로 넣고 다시 500꺼냄. 500-400 = 100. count=5
 */

public class Bj6236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] intArray = new int[100000];
    static int N, M, answer;
    static int start = 1, end = 10000;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int end = 0;
        for (int i = 0; i < N; ++i) {
            intArray[i] = Integer.parseInt(br.readLine());
            end += intArray[i];
        }
        binarySearch(1, end, (start + end) / 2);
        System.out.println(answer);
    }

    static void printAll(int K, int start, int end, int count) {
        System.out.println("=============");
        System.out.println("K: " + K);
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("count: " + count);
        System.out.println("=============");
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
        while (start <= end) {
            //printAll(K, start, end, count);
            if (count <= M) {
                answer = K;
                end = K-1;
            } else {
                // 횟수가 더 많으면 돈을 늘려야 한다.
                // start를 늘린다.
                start = K + 1;
            }
            K = (start + end) / 2;
            count = useMoney(K);
        }
    }
}