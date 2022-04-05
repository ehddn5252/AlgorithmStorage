package com.ssafy.algorithm.newDay4Dp2LIS.assignment;
// 수정중
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 1767. 프로세서 연결하기
public class Solution_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map, d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int ans, globalCnt;

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {
            // 초기화
            ans = 999999;
            globalCnt = 0;
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            Queue<Pos> q = new LinkedList<Pos>();
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        q.offer(new Pos(i, j));
                    }
                }
            }
            DFS(cloneQ(q), 0);
            System.out.println("#" + testCaseIndex + " " + ans);
        }
    }

    private static Queue<Pos> cloneQ(Queue<Pos> q) {
        Queue<Pos> newQ = new LinkedList<Pos>();
        for (Pos p : q) newQ.offer(p);
        return newQ;
    }

    private static void DFS(Queue<Pos> q, int cnt) {
        //백트레킹으로 중간에 잘라야 할듯
        // 모두 다 돌았을 경우
        if (q.isEmpty() && globalCnt <= cnt) {
            int count = counting();
            if (count < ans) ans = count;

            if (globalCnt < cnt) {
                globalCnt = cnt;
                ans = count;
            }
            return;
        }
        if (!q.isEmpty()) {
            Pos polled = q.poll();
            for (int direction = 0; direction < 5; ++direction) {
                // 동 서 남 북 안잇기
                // 전선을 이어준다.
                if (!markingMap(polled.i, polled.j, direction, false)) continue;
                if (direction != 4) DFS(cloneQ(q), cnt + 1);
                else DFS(cloneQ(q), cnt);
                // 전선 이은걸 다시 풀어준다.
                markingMap(polled.i, polled.j, direction, true);
            }
        }
    }

    private static int counting() {
        // 전선을 지도에 2로 마킹을 했었다. 따라서 2의 개수가 전선의 길이이다.
        int ret = 0;
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map.length; ++j) {
                if (map[i][j] == 2) ret += 1;
            }
        }
        return ret;
    }

    private static boolean markingMap(int polledI, int polledJ, int direction, boolean unMarking) {
        int markingValue = 2;
        if (unMarking) markingValue = 0;
        // 동쪽으로 이어주기
    
        int nextI = d[direction][0];
        int nextJ = d[direction][0];
        if(!unMarking){
            for (int j = polledJ + 1; j < map.length; ++j) {
                if (map[polledI][j] == 1 || map[polledI][j] == 2) {
                    return false;
                }
            }
        }
        for (int j = polledJ + 1; j < map.length; ++j) map[polledI][j] = markingValue;
        return true;
    }

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
