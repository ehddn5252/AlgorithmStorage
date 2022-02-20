package com.ssafy.algorithm.day8FullSearch.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardGame {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] guYoungCard = new int[9], inYoungCard = new int[9],inYoungCardSample = new int[9];
    static int guYoungWin,guYoungLose;
    static boolean[] isVisited = new boolean[9];
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum+1; ++testCaseIndex) {
            boolean[] mask = new boolean[19];
            String[] strArrayInput = br.readLine().split(" ");
            for(int i=0;i<strArrayInput.length;++i){
                guYoungCard[i] = Integer.parseInt(strArrayInput[i]);
                mask[guYoungCard[i]]=true;
            }
            int count=0;
            for(int i=1;i<mask.length;++i){
                if(mask[i]!=true){
                    inYoungCardSample[count]=i;
                    count+=1;
                }
            }
            permutation(0,9,9);
            System.out.println("#"+testCaseIndex+" "+guYoungWin+" "+guYoungLose);
            guYoungWin=0;
            guYoungLose=0;
        }
    }

    static void findWinner(){
        int inYoungCardSum=0;
        int guYoungCardSum=0;
        for(int i=0;i<9;++i){
            if(inYoungCard[i]>guYoungCard[i]){
                inYoungCardSum+= guYoungCard[i] + inYoungCard[i];
            }
            else if (inYoungCard[i]<guYoungCard[i]){
                guYoungCardSum+= guYoungCard[i] + inYoungCard[i];
            }
        }
        if (inYoungCardSum>guYoungCardSum){
            guYoungLose+=1;
        }
        if(inYoungCardSum<guYoungCardSum){
            guYoungWin+=1;
        }
    }

    static void permutation(int cnt,int n, int r){
        if(cnt==r){
            findWinner();
            return;
        }
        for(int i=0;i<n;++i){
            if (isVisited[i]) continue;
            isVisited[i]=true;
            inYoungCard[cnt] = inYoungCardSample[i];
            permutation(cnt+1,9,9);
            isVisited[i]=false;
        }
    }

}