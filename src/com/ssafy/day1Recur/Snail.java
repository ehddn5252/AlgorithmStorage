package com.ssafy.day1Recur;
/*
문제명: SW Except Academy 1954번 달팽이 숫자
작성일자: 2022.02.03
작성자: 김동우
문제요약:
1. 맨 처음테스트 케이스 수를 받고 테스트케이스 수만큼 num을 받습니다.
ex)
2       3
4       5
2       2
        8

2. num 의 크기만큼 n * n 의 지도에 달팽이 모양으로 숫자를 출력하시오. (예시 참고)
ex)
입력을
2
4
2
로 받았을 때 출력 값
#1
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7

#2
1 2
4 3

종료 코드 0(으)로 완료된 프로세스

3. 문제 출력

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {

    public static void main(String[] args) throws IOException {
        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // testCAse 수 입력
        int testCaseNum = Integer.parseInt(br.readLine());

        for(int i=1; i<testCaseNum+1; ++i){
            // 입력부
            int num = Integer.parseInt(br.readLine());
            // #1 #2 와 같은 index를 출력한다.
            printStartNum(i);
            //메인 로직
            int[][] map= snailLogic(num);
            // 메인 로직 출력부
            printSnail(map);
        }
    }

    public static void printStartNum(int num){
        System.out.println("#"+num);
    }
    public static void printSnail(int[][] map){
        // 답을 print 하는 함수
        for(int[] i:map){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static int[][] snailLogic(int num){
        /*
        1. 입력 받은 숫자 num *num 크기의 int[][] map을 만듭니다. 초기에는 모두 0으로 초기화 된 상태입니다.
        2. 현재 X좌표, 현재 Y좌표, 현재 숫자, 현재 상태 변수를 초기화해줍니다.
           여기에서 현재 숫자의 최대 크기는 num * num이며, 상태는 상화 좌우 이동하는 상태를 뜻합니다.
        3. 달팽이 모양으로 숫자를 print하려면 맨 처음에는 왼쪽으로 이동하고 끝에 다달하거나
           그 다음에 다른 수가 있다면 막힌다면 아래로 막힌다면 왼쪽 왼쪽이 막히면 오른쪽으로 가게 합니다.
        3-1. 여기에서 막히는 기준이 그 다음 이동하는 곳의 숫자가 0이 아닐때를 뜻합니다.
        4. 만약 현재 숫자가 maxSize와 같거나 커진다면 반복문은 종료됩니다.
         */
        int[][] map = new int[num][num];
        int maxSize = num*num;
        int startX = 0;
        int startY = 0;
        int number = 1;
        // state가 0이면 goRight 1이면 goDown 2면 goLeft 3면 goUp
        int state = 0;
        map[startY][startX]=1;
        while(number<maxSize){
            number++;
            //go Right
            if (state==0){
                startX+=1;
                map[startY][startX]=number;
                if(startX == num-1 || map[startY][startX+1]!=0){
                    state=1;
                }
            }
            // go Down
            else if(state==1){
                startY+=1;
                map[startY][startX]=number;
                if(startY == num-1|| map[startY+1][startX]!=0){
                    state=2;
                }
            }
            // go Left
            else if(state==2){
                startX-=1;
                map[startY][startX]=number;
                if(startX==0 || map[startY][startX-1]!=0){
                    state=3;
                }
            }
            // go Up
            else if(state==3){
                startY-=1;
                map[startY][startX]=number;
                if(startY==0 || map[startY-1][startX]!=0){
                    state=0;
                }
            }
        }
        return map;
    }
}