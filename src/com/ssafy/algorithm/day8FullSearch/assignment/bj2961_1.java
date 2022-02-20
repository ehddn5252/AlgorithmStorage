package com.ssafy.algorithm.day8FullSearch.assignment;

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
import java.util.StringTokenizer;

public class bj2961_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int S, B;
        for(int i=0;i<2;++i){
            S = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;++i){
        }
    }
}