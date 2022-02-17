package com.ssafy.day11Backtracking.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸에는 말이 놓여 있다.
2. 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과 달라야 한다. 즉 같은 알파벳이 적힌 칸을 두번 지날 수 없다.
3. 좌측 상단에서 시작해서 말이 최대 몇 칸을 지날 수 있는 지를 구하는 프로그램을 작성하시오.

 */
public class Alphabet {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] map;
    private static int rowNum ,colNum, globalCount;
    private static boolean[] isVisit;
    // 하 우 상 좌 순서로 움직임
    private static int[][] d = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        initInput();
        int count = initCondition();
        mainLogic(0,0,count);
        printAnswer();
    }

    private static int initCondition(){
        isVisit = new boolean[26];
        isVisit[map[0][0]-'A']=true;
        return 1;
    }

    private static void printAnswer(){
        System.out.println(globalCount);
    }

    private static void mainLogic(int row, int col,int count){
        // 말은 상하좌우로 갈 수 있다.
        //DFS 로 주변으로 가고, 만약에 갈 곳이 없으면 ret
        if(count>=globalCount){
            globalCount = count;
        }

        for(int i=0;i<4;++i){
            int dRow = d[i][0] + row;
            int dCol = d[i][1] + col;
            if(0<= dRow && dRow<=rowNum-1 && 0<= dCol && dCol <=colNum-1){
                int location = map[dRow][dCol]-'A';
                if(isVisit[location]) continue;
                isVisit[location] = true;
                mainLogic(dRow, dCol,count+1);
                isVisit[location] = false;
            }
        }
    }

    private static void initInput() throws IOException {
        String[] inputS = br.readLine().split(" ");
        rowNum = Integer.parseInt(inputS[0]);
        colNum = Integer.parseInt(inputS[1]);
        // colNum 은 알파벳 종류 개수는 26개이다.
        map = new char[rowNum][colNum];
        for(int i=0;i<rowNum;++i) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
    }
}
