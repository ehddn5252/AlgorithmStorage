package com.ssafy.algorithm.day12SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DFS 사용해야 함
/*
모든 경우의 수를 다 계산해야 한다. 이는 DFS 를 사용하면 쉽게 풀릴 것이다.
CCTV 의 종류별로 경우의 수가 있다.
1번은 상하좌우 4가지 경우, 2번은  2가지 경우 3번은 4가지 4번 4가지 경우 5번은 1가지 라서 상관을 안해도 된다.
CCTV 의 정보들을 저장해놓고 DFS 로 모든 경우의 수를 확인해야 한다.
각 CCTV 마다 방향에 대한 표시를 해줘야 한다.

귀찮아서 패스.
 */
public class Bj15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowNum, colNum;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        mainLogic();
    }

    private static void mainLogic() {
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                switch (map[i][j]) {
                    case 1:
                        System.out.println("1");
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("5");
                        break;
                    case 6:
                        System.out.println("6");
                        break;
                }
            }
        }
    }

    private static void mapSetting(int number, int row, int col) {
        if (number == 5) {
            while(true){
                if(map[row][col]==0){
                    map[row][col]=7;
                }

            }
        } else if (number == 4) {

        }
    }

    private static void init() throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);
        map = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < colNum; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
}
