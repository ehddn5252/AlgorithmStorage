package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_2513_x {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K,S;
    static int[] l;
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        S = Integer.parseInt(s[2]);

        l = new int[100001];

        /*
        아파트 단지의 길이는 0이상 100,000 이하이다.
        아파트 단지수 N, 통학버스의 정원 K, 학교의 위치 S
        주변에 있는 인원들을 태우고 계속 학교로 보내줘야 한다.
        경우는 2가지가 있다. 
        1. 학교로부터 왼쪽에 있는 것들을 다 확인해서 값을 빼고 오른쪽에 있는 것들 확인해서 값 빼기
        2. 학교로부터 오른쪽에 있는 것들을 다 확인해서 값을 뺴고 왼쪽에 있는 것들 확인해서 값 빼기
         */
        for(int i=0;i<N;++i){
            s = br.readLine().split(" ");
            l[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
        }

        for(int i=0;i<N;++i){

        }

    }
}
