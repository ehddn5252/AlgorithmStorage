package com.ssafy.algorithm.day13Graph.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Contact {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int TESTCASENUM = 10;

    public static void main(String[] args) throws IOException {

        for(int testCaseIndex=1;testCaseIndex<TESTCASENUM+1;++testCaseIndex){
            String[] s = br.readLine().split(" ");
            int start= Integer.parseInt(s[1]);
            String[] s2 = br.readLine().split(" ");
            int[][] adjMatrix = new int[101][101];
            for(int i=0;i<s2.length-1;i+=2){
                adjMatrix[Integer.parseInt(s2[i])][Integer.parseInt(s2[i+1])]=1;
            }
            System.out.println("#"+testCaseIndex+" "+mainLogic(start,adjMatrix));
        }
    }

    private static int mainLogic(int start,int[][] adjMatrix) {
        Queue<int[]> q = new LinkedList<int[]>();

        ArrayList<int[]> checkList = new ArrayList<>(100);
        boolean[] visit = new boolean[101];
        // 마지막 리스트만 깔쌈하게 저장하는 방법. 토큰사용
        // depth 사용 -> depth를 다른 방법으로 사용해야 한다. 이전 친구들 가꼬오면 안됨
        int depth=0;
        int[] firstToken = {start,depth};
        q.offer(firstToken);
        while(!q.isEmpty()){
            int[] popped = q.poll();
            depth = popped[1];
            for (int i = 1; i < visit.length; i++) {
                if(visit[i]) continue;
                if(adjMatrix[popped[0]][i]==1){
                    visit[i]=true;
                    q.offer(new int[]{i,popped[1]+1});
                    checkList.add(new int[]{i,popped[1]+1});
                }
            }
        }
        int max=0;
        for(int i=0;i<checkList.size();++i){
            int[] currentNum = checkList.get(i);
            if(currentNum[1]==depth && currentNum[0]>max){
                max=currentNum[0];
            }
        }
        return max;
    }
}

