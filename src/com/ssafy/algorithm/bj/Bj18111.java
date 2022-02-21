package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 좌표 i,j의 가장 위에 있는 블록을 제거해서 인벤토리에 넣는다. 2초 걸림
// 2. 인벤토리에 넣은 블록 하나를 꺼내어 좌표 i,j의 가장 위에 있는 블록에 놓는다.  1초걸림
public class Bj18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int maxRow, maxCol, B;
    static int map[][];
    static int minTime = Integer.MAX_VALUE;
    static int maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        maxRow = Integer.parseInt(s[0]);
        maxCol = Integer.parseInt(s[1]);
        map = new int[maxRow][maxCol];
        B = Integer.parseInt(s[2]);
        for (int i = 0; i < maxRow; ++i) {
            s = br.readLine().split(" ");
            for (int j = 0; j < maxCol; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        mainLogic();
        System.out.println(minTime+" "+maxHeight);
    }

    /*
     제거하는 데 시간이 2초 걸리고 추가하는 데는 시간이 1초 걸린다.
     초기 블럭의 개수가 주어져 있다.
     가방에 수만큼 없으면 pass
     
     height가 256까지이므로 1~256까지 돌려봄 500 * 500 * 256 = 250000 * 256 = 64,000,000.  1억에 1초 아슬아슬
    */
    private static void mainLogic() {
        // 땅의 높이를 h로 맞춤
        for (int h = 0; h < 256 + 1; ++h) {
            // 인벤토리에 넣을 횟수 
            int popInventory = 0;
            // 제거할 횟수 구함
            int putInventory = 0;


            for (int i = 0; i < maxRow; ++i) {
                for (int j = 0; j < maxCol; ++j) {
                    // h높이
                    if (map[i][j] != h) {
                        int currentHeight = map[i][j] - h;
                        // 만약 땅의 높이가 더 낮다면 인벤에서 꺼내 넣어야 한다.
                        if (currentHeight < 0) {
                            popInventory -= currentHeight;
                            // 만약 땅의 높이가 더 높다면 인벤에 집어 넣어야 한다.
                        } else {
                            putInventory += currentHeight;
                        }
                    }
                }
            }
            // 집어넣은 것과 현재 가진게 인벤에서 꺼낸 것보다 많으면 그 h로 맞출 수 있다.
            if (putInventory + B >= popInventory) {
                int time = 2 * putInventory + popInventory;
                if (minTime >= time) {
                    minTime = time;
                    maxHeight = h;
                }
            }
        }
    }
}
