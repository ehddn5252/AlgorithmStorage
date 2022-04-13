package com.ssafy.algorithm.newDay11WebXPractice3.assignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 집을 q에 넣는다.
1. p poll 해서 나온 것과 festival 사이의 거리가 1000이하면 happy 이다.
1. p poll 해서 나온 편의점의 인덱스 visit 를 true 로 바꿔준다. (맨 처음은 집이 poll 되므로 제외해준다.)
1. 집에서 부터 출발해서 거리가 1000이하인 편의점을 q에 넣는다.
 */
public class Bj9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testcaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcaseNum; ++i) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            Pos housePos = new Pos(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            ArrayList<Pos> convPos = new ArrayList<Pos>();
            for (int j = 0; j < N; ++j) {
                s = br.readLine().split(" ");
                convPos.add(new Pos(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
            }
            s = br.readLine().split(" ");
            Pos festivalPos = new Pos(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            mainLogic(N,festivalPos,housePos,convPos);
        }
    }

    static void mainLogic(int N,Pos festivalPos,Pos housePos, ArrayList<Pos> convPos){
        // 편의점이 0개인 경우 집과 패스티벌 사이만 확인한다.
        if(N==0) {
            if (getDistance(festivalPos, housePos) <= 1000) System.out.println("happy");
            else System.out.println("sad");
            return;
        }
        boolean[] visit = new boolean[N];
        Queue<Pos> q = new LinkedList<Pos>();
        q.offer(housePos);
        while (!q.isEmpty()) {
            Pos currentPos = q.poll();
            // 현재위치와 festival 사이 거리가 1000이하면 happy를 출력한다.
            if(getDistance(festivalPos, currentPos)<=1000){
                System.out.println("happy");
                return;
            }
            // 모든 편의점을 돌아본다.
            for (int j = 0; j < N; ++j) {
                // 만약 방문했으면 pass
                if (visit[j]) continue;
                // 다른 편의점과 현재 위치 사이의 거리를 구한다.
                int dis = getDistance(currentPos, convPos.get(j));
                // 현재 위치와 다른 편의점 사이 거리가 1000이하면 q에 넣는다.
                if (dis <= 1000) {
                    q.offer(convPos.get(j));
                    // 현재 위치를 방문 표시한다.
                    visit[j]=true;
                }
            }
        }
        // 해피가 아니면 sad 를 출력한다.
        System.out.println("sad");
    }

    static int getDistance(Pos p1, Pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
