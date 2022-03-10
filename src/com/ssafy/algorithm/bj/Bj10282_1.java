package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bj10282_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<LinkedList<s>> computerRelations;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 0; testCaseIndex < testCaseNum; ++testCaseIndex) {
            String[] s = br.readLine().split(" ");
            int computerNum = Integer.parseInt(s[0]) + 1;
            int dependency = Integer.parseInt(s[1]);
            int hackedComputer = Integer.parseInt(s[2]);
            computerRelations = new ArrayList<LinkedList<s>>(computerNum);
            for (int i = 0; i < computerNum; ++i) {
                computerRelations.add(new LinkedList<s>());
            }

            visit = new boolean[computerNum];
            //visit = new boolean[computerNum][computerNum];
            for (int i = 0; i < dependency; ++i) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                LinkedList l = computerRelations.get(b);
                l.add(new s(a,time));
                computerRelations.set(b, l);
            }
            mainLogic(hackedComputer);
        }
    }

    private static void mainLogic(int hackedComputer) {
        Queue<int[]> q = new LinkedList<int[]>();
        // 해킹당한 컴퓨터, 시간, 대수
        int[] init = new int[]{hackedComputer, 0, 1};
        q.offer(init);
        int maxTime = 0;
        int beforePopped = 0;
        while (!q.isEmpty()) {
            int[] popped = q.poll();

            if (popped[2] == beforePopped) {
                if (maxTime > popped[1]) ;
                maxTime = popped[1];
            }
            else{
                maxTime = popped[1];
            }
            if (visit[popped[0]]) continue;
            visit[popped[0]] = true;
            LinkedList tmp = computerRelations.get(popped[0]);
            for(int i=0;i<tmp.size();++i){
                s getted = (s)tmp.get(i);
                q.offer(new int[]{getted.destination, popped[1] + getted.time, popped[2] + 1});
            }
            beforePopped = popped[2];
        }
        int count = 0;
        for (int i = 0; i < visit.length; ++i) {
            if (visit[i]) {
                count += 1;
            }
        }
        System.out.println(count + " " + maxTime);
    }
    static class s{

        int destination;
        int time;

        public s(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }
}
