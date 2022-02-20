package com.ssafy.algorithm.bj;

// 주사위 쌓기
// 정보
// 정육면체, 보통 주사위와 달리 마주 보는 면에 적힌 숫자의 합이 반드시 7이 아니다.
// 주사위 쌓기 놀이는 1번, 2번, 3번 순서로 쌓는다.
// 서로 붙어 있는 두 개의 주사위에서 아래에 있는 주사위의 윗면에 적혀 있는 숫자는 위에 있는 주사위의 아랫면에 적혀 있는 숫자와 같아야 한다.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2116 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dices;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        dices = new int[N][6];
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<6;++j){
                dices[i][j] = Integer.parseInt(s[j]);
            }
        }
        mainLogic();
    }

    // 한 옆면 숫자의 합이 가장 큰 값을 출력해야 한다.
    // 주사위 개수는 1만개 이하이다.
    public static void mainLogic(){

    }
}
