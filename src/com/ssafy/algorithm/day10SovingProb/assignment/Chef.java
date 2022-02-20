package com.ssafy.algorithm.day10SovingProb.assignment;

// 1. 요리사
// 2. i를 j와 같이 요리하게 되면 발생하는 시너지 Sij의 정보가 주어지고, 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 두 음식간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 정답으로 출력하는 프로그램을 만들어라


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chef {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int[] synergy;
    static int answer = 99999;

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum + 1; ++testCaseIndex) {
            // input
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] inputStr = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(inputStr[j]);
                }
            }
            // 초기화
            synergy = new int[N/2];
            answer=9999999;

            // 구현
            combination(0, 0);

            //출력
            System.out.print("#"+testCaseIndex+" ");
            System.out.println(answer);
        }
    }

    static void printAll(){
        System.out.println("synergy=====================");
        for(int i=0;i<N/2;++i){
            System.out.print(synergy[i]+" ");
        }
        System.out.println();
        System.out.println("===============");
    }


    static void combination(int cnt, int start) {
        if (cnt == N/2) {
            checkSynergy();
            return;
        }
        for (int i = start; i < N; ++i) {
            synergy[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    static void checkSynergy() {
        //printAll();
        int food1 = 0;
        int food2 = 0;
        boolean[] mask = new boolean[N];
        for(int i=0;i<N/2;++i){
            mask[synergy[i]]=true;
        }

        int[] synergy2 = new int[N/2];
        int start = 0;
        for(int i=0;i<mask.length;++i){
            if(mask[i]==false){
                synergy2[start]=i;
                start+=1;
            }
        }

        // 0, 3,0,0 이면
        // 1,2 //34
        // 1,3 // 2,4
        //1,4 // 2 ,3
        for(int i=0;i<N/2;++i){
            for(int j=0;j<N/2;++j){
                food1+=map[synergy[i]][synergy[j]];
                food2+=map[synergy2[i]][synergy2[j]];
            }
        }

        int diff = Math.abs(food1-food2);
        //System.out.println(diff);
        if ( diff< answer) {
            answer = diff;
        }
    }
}
