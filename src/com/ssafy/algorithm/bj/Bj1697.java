package com.ssafy.algorithm.bj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
/*

문제
1. 수빈이는 X -1 또는 X +1 또는 2 * X 로 갈 수 있다.
2. 동생은 K 위치에 가만히 있는다.

문제 해결 (백트레킹 생각)
0. 준비물: queue q, visit을 생성
1. 수빈이를 +1, -1, x2 한 경우의 수를 모두 넣어준다.

 */

public class Bj1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        visit = new boolean[100001];
        N = Integer.parseInt(s[0]); // 수빈이 위치
        K = Integer.parseInt(s[1]); // 동생 위치
        BFS();
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] popped = q.poll();
            if (popped[0] == K) {
                System.out.println(popped[1]);
                return;
            }
            int case1 = popped[0] + 1;
            int case2 = popped[0] - 1;
            int case3 = popped[0] * 2;

            if (case1 <= 100000 && !visit[case1]) {
                visit[case1] = true;
                q.offer(new int[]{case1, popped[1] + 1});
            }

            if (case2 <= 100000 && case2>=0 && !visit[case2]) {
                visit[case2] = true;
                q.offer(new int[]{case2, popped[1] + 1});
            }

            if (case3 <= 100000 && !visit[case3]) {
                visit[case3] = true;
                q.offer(new int[]{case3, popped[1] + 1});
            }
        }
    }
}

