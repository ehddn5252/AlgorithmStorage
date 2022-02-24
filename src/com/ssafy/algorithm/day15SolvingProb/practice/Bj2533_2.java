package com.ssafy.algorithm.day15SolvingProb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2533_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<LinkedList<Info>> map;
    static int N;
    static boolean[] earlyAdopterList;
    static int[] findLeafNode;
    static int count;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new ArrayList<>(N+1);
        findLeafNode = new int[N+1];
        earlyAdopterList = new boolean[N+1];
        for(int i=0;i<N+1;++i){
            map.add(new LinkedList<>());
        }

        for (int i = 0; i < N - 1; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            LinkedList<Info> tmpA = map.get(a);
            tmpA.add(new Info(false,b,false));
            LinkedList<Info> tmpB = map.get(b);
            tmpB.add(new Info(false,a,false));
            map.set(a,tmpA);
            map.set(b,tmpB);
        }
        // 1차원 배열로 연결관계
        Queue<Info> q= new LinkedList<Info>();
        for(int i=1;i<N+1;++i){
            if(map.get(i).size()==1){
                q.add(new Info(false,i,true));
            }
        }
        BFS(q);
        int count=0;
        for(int i=0;i<earlyAdopterList.length;++i){
            if(earlyAdopterList[i]){
                count+=1;
            }
        }
        System.out.println(count);
    }

    // 그 다음 BFS 시전해서 얼리어답터면 아니라고 해놓고 아니면 맞다고 취급해줌.
    static void BFS(Queue<Info> q){
        while(!q.isEmpty()){
            Info nowFriend =q.poll();
            LinkedList<Info> l = map.get(nowFriend.number);
            for(int i=0;i<l.size();++i){
                Info nextFriend = l.get(i);
                if(nextFriend.visit && !nextFriend.isEalryAdapter) continue;
                nextFriend.visit=true;
                l.set(i, nextFriend);
                if(nowFriend.isEalryAdapter){
                    q.offer(new Info(false, nextFriend.number,true));
                }
                else{
                    earlyAdopterList[nextFriend.number]=true;
                    q.offer(new Info(true, nextFriend.number,true));
                }
            }
        }
    }

    static class Info {
        public Info(boolean isEalryAdapter, int number, boolean visit) {
            this.isEalryAdapter = isEalryAdapter;
            this.number = number;
            this.visit = visit;
        }
        boolean isEalryAdapter;
        int number;
        boolean visit;
    }
}