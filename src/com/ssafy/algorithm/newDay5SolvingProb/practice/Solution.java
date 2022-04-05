package com.ssafy.algorithm.newDay5SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, W, H;
    static int[][] map,newMap;
    static boolean[] visit;
    static int[] nums, nums_copy;
    static int ans, maxAns;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[1]);
            H = Integer.parseInt(s[2]);
            map = new int[H][W];
            newMap = new int[H][W];
            visit = new boolean[W];
            ans=0;
            maxAns=0;
            nums = new int[N];
            for (int i = 0; i < N; ++i) nums[i] = i;

            nums_copy = new int[W];
            for (int i = 0; i < W; ++i) nums_copy[i] = i;

            for (int i = 0; i < H; ++i) {
                s = br.readLine().split(" ");
                for (int j = 0; j < W; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                    newMap[i][j] = Integer.parseInt(s[j]);
                }
            }
            permutation(0);
            System.out.println("#"+testCaseIndex + " "+maxAns);
        }
    }

    /*
    일반 combination 문제
    1. 구슬을 쏘는 모든 경우를 구한다. 구술의 숫자를 맞았을 경우 그에 맞게 제거한다. 
     */
    private static void print() {
        for (int i = 0; i < nums.length; ++i) System.out.print(nums[i] + " ");
        System.out.println("");
    }

    private static void cloneMap(){
        for(int i=0;i<newMap.length;++i){
            for(int j=0;j< newMap[0].length;++j){
                map[i][j]=newMap[i][j];
            }
        }
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            cloneMap();
            gameStart();
            findAns();
            if(ans<maxAns) maxAns=ans;
            return;
        }
        for (int i = 0; i < W; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            nums[cnt] = nums_copy[i];
            permutation(cnt + 1);
            visit[i] = false;
        }
    }

    private static void gameStart() {
        for (int i = 0; i < nums.length; ++i) shootingMarble(nums[i]);
    }

    private static void shootingMarble(int num) {
        Queue<Pos> q = new LinkedList<Pos>();
        for (int i = 0; i < N; ++i) {
            if (map[i][num] != 0) {
                q.offer(new Pos(i, num,map[i][num]));
                breakBrick(q);
                down();
                break;
            }
        }
    }

    private static void findAns(){
        ans=0;
        for(int i=0;i<map.length;++i){
            for(int j=0;j<map[0].length;++j){
                if(map[i][j]!=0){
                    ans+=1;
                }
            }
        }
    }

    private static void breakBrick(Queue<Pos> q ) {
        while (!q.isEmpty()) {
            Pos polled = q.poll();
            map[polled.i][polled.j] = 0;
            for (int i = 1; i < polled.value;++i) {
                for (int j = 0; j < 4; ++j) {
                    int nextI = polled.i + d[j][0] * i;
                    int nextJ = polled.j + d[j][1] * i;
                    if (nextI >= 0 && nextI < map.length && nextJ >= 0 && nextJ < map[0].length) {
                        if(map[nextI][nextJ]>1){
                            q.offer(new Pos(nextI, nextJ, map[nextI][nextJ]));
                            map[nextI][nextJ] = 0;
                        }
                    }
                }
            }
        }
    }

    static private void down(){
        // 벽돌을 내리게 하는 로직
        for(int j=0;j<map[0].length;++j) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < map.length; ++i) {
                if(map[i][j]!=0){
                    s.push(map[i][j]);
                    map[i][j]=0;
                }
            }
            int count=1;
            while(!s.isEmpty()){
                map[map.length-count][j]= s.pop();
                count++;
            }
        }
    }

    static class Pos {
        int i;
        int j;
        int value;

        public Pos(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
