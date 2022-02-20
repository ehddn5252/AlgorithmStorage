package com.ssafy.algorithm.day12SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Scale {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] weights;
    static int N, ans, sum;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 1; testCaseIndex < testCaseNum + 1; ++testCaseIndex) {
            initInput();
            int s = sum;
            mainLogic(0,0,0,s);
            printAnswer(testCaseIndex);
            resetInput();
        }
    }

    public static int factorial(int number){
        int ret = 1;
        for(int i=1;i<=number;++i){
            ret *= i;
        }
        return ret;
    }

    public static void mainLogic(int cnt,int leftWeight,int rightWeight, int rest){
        if(rest+leftWeight<rightWeight)return;
        if(cnt==N){
            ans+=1;
            return;
        }

        if(leftWeight>=sum/2+1){
            int visitCount = 0;
            for(int i=0;i<visit.length;++i){
                if(!visit[i]){
                    visitCount+=1;
                }
            }
            ans+=Math.pow(2,visitCount)*factorial(visitCount);
            //ans+=1>>visitCount*factorial(visitCount);
            return;
        }

        for(int i=0;i<N;++i){
            if(visit[i])continue;
            visit[i]=true;
            if(leftWeight>=rightWeight+weights[i]){
                mainLogic(cnt+1,leftWeight,rightWeight+weights[i],rest-weights[i]);
            }
            mainLogic(cnt+1,leftWeight+weights[i],rightWeight,rest -weights[i]);
            visit[i]=false;
        }
    }


    public static void initInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        visit = new boolean[N];
        weights = new Integer[N];
        for(int i=0;i<N;++i){
            weights[i] = Integer.parseInt(s[i]);
            sum+=weights[i];
        }
        Arrays.sort(weights, Collections.reverseOrder());
    }

    private static void printAnswer(int testCaseIndex){
        System.out.println("#"+testCaseIndex+" "+ans);
    }
    private static void resetInput(){
        ans=0;
        sum=0;
    }
}
