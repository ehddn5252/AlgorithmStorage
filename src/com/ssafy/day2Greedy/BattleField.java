package com.ssafy.day2Greedy;
/*
문제명: 상호의 배틀필드
작성일자: 2022.02.04
작성자: 김동우
링크:(https://bit.ly/35P59ql)
문제 요약:
0. 평지(.)는 유일하게 들어갈 수 있다. 물(_)은 전차가 들어갈 수 없다. *는 벽돌, #은 강철
1. 탱크가 움직이는 것은 U D L R 로 하고 방향을 옮기고, 평지면 한칸 움직입니다.
2. S는 포탄을 발사한다. 포탄 사거리는 무한이다. 벽을 만나면 멈추고, 벽돌벽은 부수고. 강철벽은 부수지 못한다.
3. 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때,
   모든 입력을 처리하고 나면 맵의 상태가 어떻게 되는 지 구하는 프로그램을 작성하라.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BattleField {
    public static void main(String[] args) throws IOException {
        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            String mapSize = br.readLine();
            String[] s1 = mapSize.split(" ");
            int rowNum = Integer.parseInt(s1[0]);
            int colNum = Integer.parseInt(s1[1]);
            char[][] map = new char[rowNum][colNum];
            System.out.print("#"+(testCaseIndex)+" ");
            //ArrayList<String> map = new ArrayList<String>();
            for(int rowIndex=0;rowIndex<rowNum;++rowIndex){
                String mapInfo = br.readLine();
                for(int i=0;i<mapInfo.length();++i){
                    map[rowIndex][i] = mapInfo.charAt(i);
                }
                //map.add(mapInfo);
            }
            int inputSize = Integer.parseInt(br.readLine());
            String inputStr = br.readLine();
            printMap(mainLogic(map,inputStr));
        }
    }


    public static void printMap(char[][] map){
        int yMax = map.length;
        int xMax = map[0].length;
        for(char[] y: map){
            for(char x: y){
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static char[][] mainLogic( char[][] map,String inputStr){
        /*
        . 평지, * 벽돌벽, # 강철벽, _ 물,
        ^ 위쪽을 바라보는 전차(state = 0), v 아래를 바라보는 전차(state= 1), < 왼쪽을 바라보는 전차(state = 2), > 오른 쪽을 바라보는 전차(state = 3)
        U D L R S
        1. 탱크의 현재 위치를 찾습니다.
        2. 효과를 사용합니다.
        */
        int yMax = map.length;
        int xMax = map[0].length;
        ArrayList<Integer> currentInfo = findTankLocation(map);
        int y = currentInfo.get(0);
        int x = currentInfo.get(1);
        int state = currentInfo.get(2);
        int shootingX = x;
        int shootingY = y;
        for(int i = 0 ; i<inputStr.length() ;++i){
            char ch = inputStr.charAt(i);
            //printMap(map);
            //System.out.println((i+1)+"번째"+"명령어:"+ch);
            if (ch=='U'){
                state=0;
                if (y-1!=-1) {
                    if (map[y - 1][x] == '.') {
                        map[y][x] = '.';
                        y -= 1;
                    }
                }
                map[y][x]='^';
            }
            else if (ch=='D'){
                state=1;
                if (y+1!=yMax) {
                    if (map[y+1][x] == '.') {
                        map[y][x]='.';
                        y += 1;
                    }
                }
                map[y][x]='v';
            }
            else if (ch=='L'){
                state=2;
                if (x-1!=-1) {
                    if (map[y][x-1] == '.') {
                        map[y][x] = '.';
                        x -= 1;
                    }
                }
                map[y][x]='<';
            }
            else if (ch=='R'){
                state=3;
                if (x+1!=xMax){
                    if (map[y][x+1] == '.') {
                        map[y][x]='.';
                        x += 1;
                    }
                }
                map[y][x]='>';
            }
            else if (ch=='S'){
                /*
                state 에 따라서 다르다. state 가
                */

                shootingX=x;
                shootingY=y;
                if (state==0){
                    // up
                    while(true){
                        shootingY-=1;
                        if (shootingY==-1)break;
                        if(map[shootingY][shootingX]=='*'){
                            map[shootingY][shootingX]='.';
                            break;
                        }
                        else if(map[shootingY][shootingX]=='#'){
                            break;
                        }
                    }
                }
                else if(state==1) {
                    // down
                    while (true) {
                        shootingY += 1;
                        if (shootingY == yMax) break;
                        if (map[shootingY][shootingX] == '*') {
                            map[shootingY][shootingX] = '.';
                            break;
                        } else if (map[shootingY][shootingX] == '#') {
                            break;
                        }
                    }
                }
                else if(state==2){
                    // left
                    while(true) {
                        shootingX -= 1;
                        if (shootingX == -1) break;
                        if (map[shootingY][shootingX] == '*') {
                            map[shootingY][shootingX] = '.';
                            break;
                        } else if (map[shootingY][shootingX] == '#') {
                            break;
                        }
                    }
                }
                else if(state==3){
                    // right
                    while(true) {
                        shootingX += 1;
                        if (shootingX == xMax) break;
                        if (map[shootingY][shootingX] == '*') {
                            map[shootingY][shootingX] = '.';
                            break;
                        } else if (map[shootingY][shootingX] == '#') {
                            break;
                        }
                    }
                }
            }
        }
        return map;
    }

    public static ArrayList<Integer> findTankLocation(char[][] map){

        boolean isFind = false;
        ArrayList<Integer> locationInfo = new ArrayList<>();
        for(int rowIndex=0;rowIndex<map.length;++rowIndex){
            for(int colIndex=0;colIndex<map[0].length;++colIndex){
                char currentLocation= map[rowIndex][colIndex];
                if (currentLocation=='^'){
                    isFind=true;
                    locationInfo.add(rowIndex);
                    locationInfo.add(colIndex);
                    locationInfo.add(0);
                }
                else if (currentLocation=='v'){
                    isFind=true;
                    locationInfo.add(rowIndex);
                    locationInfo.add(colIndex);
                    locationInfo.add(1);
                }
                else if (currentLocation=='<'){
                    isFind=true;
                    locationInfo.add(rowIndex);
                    locationInfo.add(colIndex);
                    locationInfo.add(2);
                }
                else if (currentLocation=='>'){
                    isFind=true;
                    locationInfo.add(rowIndex);
                    locationInfo.add(colIndex);
                    locationInfo.add(3);
                }
                if(isFind==true){
                    return locationInfo;
                }
            }
        }
        return null;
    }
}