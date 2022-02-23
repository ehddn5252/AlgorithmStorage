package com.ssafy.algorithm.difficultProblems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
근처 빵집의 가스관에 몰래 파이프를 설치해서 훔쳐서 사용하기로 했다.

첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집이다.

원웅이는 가스관과 빵집을 연결하는 파이프를 설치하려고 한다. 건물이 있는 경우에는 파이프를 놓을 수 없다.
가스관과 빵집을 연결하는 모든 파이프라인은 첫째 열에서 시작해야 하고, 마지막 열에서 끝나야 한다. 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있고, 각 칸의 중심끼리 연결하는 것이다.

0. 파이프는 오른쪽 위, 오른쪽, 오른쪽 아래로 이동할 수 있다.
0. x가 있는 곳은 갈 수 없다.
0. 다른 파이프가 지나간 곳은 지나갈 수 없다.

1. 맨 앞에서부터 시작해서 오른쪽 위, 오른쪽, 오른쪽 아래로 이동하게 한다.
2. 그다음 3칸 중 하나를 선택하게 한다.

 */
public class BreadHouse {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map;
    static int rowNum, colNum;
    static int answer;
    static boolean[][] visit;
    static int[][] d = new int[][]{{-1, 1}, {0, 1}, {1, 1}};


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);
        colNum = Integer.parseInt(s[1]);

        visit = new boolean[rowNum][colNum];
        map = new char[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < rowNum; ++i)
            if (mainLogic(i, 0)) {
                answer += 1;
            }
        System.out.println(answer);
    }

    static boolean mainLogic(int row, int col) {
        if (col == colNum - 1) return true;
        for (int i = 0; i < 3; ++i) {
            int movedRow = row + d[i][0];
            int movedCol = col + d[i][1];

            if (movedRow >= 0 && movedRow <= rowNum - 1 && movedCol >= 0 && movedCol <= colNum - 1) {
                if (visit[movedRow][movedCol]) {
                    continue;
                }
                visit[movedRow][movedCol] = true;
                if (map[movedRow][movedCol] == '.') {
                    map[movedRow][movedCol] = 'x';
                    if (mainLogic(movedRow, movedCol)){
                        return true;
                    }
                    map[movedRow][movedCol] = 'x';
                }
                visit[movedRow][movedCol] = false;
            }
        }
        return false;
    }
}
