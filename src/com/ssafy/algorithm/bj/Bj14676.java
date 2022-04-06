package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 입력을 받는다. 입력 받을때에는 start end가 있는데
map[end][start]= 1 로 표시해서 2번과 3번이 있으면 4번을 지을 수 있다라는 것을 4번이 있으면 2번과 3번을 확인한다로 의존 관계를 map 에 설정한다.
그리고 지어져 있는 지 확인하는 int[] build 라는 변수를 만든다. build 배열의 0은 미생성, 1은 생성, 2는 생성 + 기반 시설 모두 생성(더이상 확인할 필요 없음), 3은 확인 중 으로 둔다.
2. 생성하는 커멘드(1 a)가 주어진다면 이를 q에 넣고  while(!q.isEmpty) 로 돌리고 맨 처음에 q pop을 한다. (처음 pop한 것은 build 배열 확인 x)
   for 문으로 map[a][0~ N] 를 확인해 값이 1인(a 번호를 만들기 위한 기초시설) 있는 것을 q에 넣는다.
3. q pop 을 하고 build 배열에서 생성되어 있는 지 확인한다. 생성되어 있으면 build[popped] 를 3으로 두고, 다시 그것의 기반 시설을 확인한다.
4-1. 만약 기반시설에 build가 안된 것이 있다면 바로 Lier!를 출력
4-2. while(!q.isEmpty())을 빠져나와 모든 기반 시설 을 확인했다면 build 에서 3인 값을 모두 2로 바꿔준다. // 이렇게보면 1이 필요없넹
5. 만약 destory 명령어(2 a) 라면 build 에서 확인한다.

 */
public class Bj14676 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 건물 종류의 개수
        int M = Integer.parseInt(s[1]); // 건물 사이의 관계의 개수
        int K = Integer.parseInt(s[2]); // 영우의 게임 정보의 개수 1은 건설 2는 파괴

        map = new int[N][N];
        // 2차원 배열을 1차원으로 바꿔주기 -> linkedList,
        // 중복 건설
        for (int i = 0; i < M; ++i) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]) - 1;
            int end = Integer.parseInt(s[1]) - 1;
            map[end][start] = 1;
        }

        for (int i = 0; i < K; ++i) {
            s = br.readLine().split(" ");
            int command = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]) - 1;
            if (command == 1) {
                for (int j = 0; j < map.length; ++j) {
                    // 의존관계에서 기존에 생성해야 할 게 있다.
                    if (map[end][j] == 1) {
                        System.out.println("Lier!");
                        return;
                    }
                }
                // 여기로 가는 것들은 모두 ok라는 뜻
                for (int j = 0; j < map.length; ++j) {
                    if (map[j][end] == 1) {
                        map[j][end] = 2;
                    }
                }
            }else if (command == 2) {
                boolean isNotLier = true;
                for (int j = 0; j < map.length; ++j) {
                    if (map[j][end] == 1) {
                        isNotLier = false;
                    }
                }
                if (!isNotLier) {
                    System.out.println("Lier!");
                    return;
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}
