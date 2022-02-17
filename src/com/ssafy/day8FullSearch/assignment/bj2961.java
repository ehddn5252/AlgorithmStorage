package com.ssafy.day8FullSearch.assignment;

// 도영이가 만든 맛있는 음식
// 재료가 N개, 신맛 S 쓴맛 B
// 신 맛은 사용한 신맛의 곱이고 쓴맛은 합이다.
// 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만든다. 재료는 적어도 하나 사용해야 한다.

// input
// 첫 줄에는 재료의 개수, 다믕 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다. 모든 재료를 사용해서 요리를 만들때
// 그 요리의 신맛과 쓴맛은 모두 1,000,000,000 보다 작은 양의 정수이다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj2961 {
    // 왼쪽은 신맛이고, 오른쪽은 쓴맛이다.
    // 신맛끼리는 신맛 곱이고, 쓴맛은 쓴맛끼리 합. 부분집합
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long sourAndBitterDiffMin = Long.MAX_VALUE;
    static int count;
    static List<int[]> l = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        int S, B;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String[] inputList = br.readLine().split(" ");
            S = Integer.parseInt(inputList[0]);
            B = Integer.parseInt(inputList[1]);
            l.add(new int[]{S, B});
        }
        //부분집합 문제
        powerSet(0, 1, 0, 0);
        //System.out.println(count);
        System.out.println(sourAndBitterDiffMin);
    }

    static void printAll(int cnt, long sourSum, long bitterSum) {
        long diff = Math.abs(sourSum - bitterSum);
        System.out.println("cnt:" + cnt);
        System.out.println("sourSum:" + sourSum);
        System.out.println("bitterSum:" + bitterSum);
        System.out.println(diff);
    }

    static void powerSet(int cnt, long sourSum, long bitterSum, int depth) {
        //printAll(cnt,sourSum,bitterSum);
        count += 1;
        long diff = Math.abs(sourSum - bitterSum);
        if (sourAndBitterDiffMin > diff && depth != 0) {
            sourAndBitterDiffMin = diff;
        }

        if (cnt == N) return;
        int[] sourAndBitter = l.get(cnt);

        powerSet(cnt + 1, sourSum * sourAndBitter[0], bitterSum + sourAndBitter[1], depth + 1);
        powerSet(cnt + 1, sourSum, bitterSum, depth);
    }
}