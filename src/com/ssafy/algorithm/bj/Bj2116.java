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
    static int diceMax = 0;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        dices = new int[N][6];
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<6;++j){
                dices[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i=1;i<7;++i){
            bruteForce(i);
        }
        System.out.println(diceMax);
    }

    // 한 옆면 숫자의 합이 가장 큰 값을 출력해야 한다.
    // 주사위 개수는 1만개 이하이다.
    // A는 F, B는 D, C는 E와 매칭이 된다.
    // A B C D E F
    // 0 1 2 3 4 5
    // 맞붙는 면의 숫자가 같아야 한다. 주사위 6개로 순서대로 시작해본다. dp로 해야할 듯

    public static void bruteForce(int start){
        int diceNum = start; // dice 눈 값이다.
        int sum=0;
        int length = dices.length;

        // 최댓값을 찾는다. dice 의
        for(int i=0;i<length;++i){
            // 시작눈의 dices[i][diceNum]은 그 인덱스의 주사위 값이다.
            sum+=findMax(i,diceNum);
            diceNum = findb(i,diceNum);
        }
        if(diceMax<sum){
            diceMax=sum;
        }
    }

    // o
    public static int findb(int index, int diceNum) {
        for (int currentDiceNum = 0; currentDiceNum < 6; ++currentDiceNum) {
            if(dices[index][currentDiceNum]==diceNum){
                return dices[index][findOpposite(currentDiceNum)];
            }
        }
        return 0;
    }

    // 요건 맞다.
    //
    public static int findMax(int index, int diceNum){
        int maxValue = 0;
        for(int currentDiceNum = 0; currentDiceNum <6; ++currentDiceNum){
            // 만약 주사위값이
            if(dices[index][currentDiceNum] !=diceNum && dices[index][findOpposite(currentDiceNum)]!=diceNum){
                if(dices[index][currentDiceNum]>maxValue){
                    maxValue=dices[index][currentDiceNum];
                }
            }
        }
        return maxValue;
    }

    // 반대를 찾아준다.
    public static int findOpposite(int diceNum){
        switch(diceNum){
            case 0:
                return 5;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 0;
        }
        return 0;
    }
}
