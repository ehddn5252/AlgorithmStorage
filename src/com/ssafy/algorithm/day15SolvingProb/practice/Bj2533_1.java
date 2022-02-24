package com.ssafy.algorithm.day15SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2533_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] map;
    static int N;
    static boolean visit[];
    static final int EARLY_ADOPTER=1;
    static final int NORMAL_ADOPTER=0;
    static boolean[] earlyAdopterList;
    static int count;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < N - 1; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map[a][b] = true;
            map[b][a] = true;
        }

        earlyAdopterList= new boolean[N+1];
        checkEarlyAdopter();
        Queue<Info> q= new LinkedList<Info>();
        q.offer(new Info(earlyAdopterList[1], 1));
        count=1;
        visit = new boolean[N+1];

        BFS(q);
        int count=0;
        for(int i=0;i<earlyAdopterList.length;++i){
            if(earlyAdopterList[i]){
                count+=1;
            }
        }
        System.out.println(count);
    }
    // 일단 3개 연결되면 얼리어답터, 얼리어답터 체크해줌

    static void checkEarlyAdopter(){
        for(int i=1;i<N+1;++i){
            int check=0;
            for(int j=1;j<N+1;++j){
                if(map[i][j]==true){
                    check+=1;
                }
            }
            if(check>=3){
                earlyAdopterList[i]=true;
            }
        }
    }


    // 그 다음 BFS 시전해서 얼리어답터면 아니라고 해놓고 아니면 맞다고 취급해줌.
    static void BFS(Queue<Info> q){
        visit[1]=true;
        while(!q.isEmpty()){
            Info popped = q.poll();
            for(int i=1;i<N+1;++i){
                if(!map[popped.number][i])continue;
                if (visit[i]) continue;
                visit[i]=true;
                if(popped.isEalryAdapter){
                    if(!earlyAdopterList[i]){
                        q.offer(new Info(false,i));
                    }
                    else{
                        q.offer(new Info(true,i));
                    }
                }
                else{
                    earlyAdopterList[i]=true;
                    q.offer(new Info(true,i));
                }
            }
        }
    }

    static class Info {
        public Info(boolean isEalryAdapter, int number) {
            this.isEalryAdapter = isEalryAdapter;
            this.number = number;
        }

        boolean isEalryAdapter;
        int number;
    }
}
