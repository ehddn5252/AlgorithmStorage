package com.ssafy.day5SolvingProb;

import java.util.Arrays;
import java.util.Scanner;
// 2309


public class LittleBoys7 {
    static int[] s;
    static final int ANSWER=100;
    static boolean retFlag=false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = new int[9];
        for(int i=0;i<9;++i){
            s[i] = sc.nextInt();
        }
        Arrays.sort(s);
        boolean[] isCheck = new boolean[9];
        powerSet(0,0,isCheck,0);
    }

    //부분집합
    static void powerSet(int cnt,int sum,boolean[] isCheck,int count){
        if(retFlag)return;
        if (count>7) return;
        if (count==7 && sum==ANSWER){
            for(int i=0;i<isCheck.length;++i){
                if (isCheck[i]==true){
                    System.out.println(s[i]);
                }
            }
            retFlag=true;
            return;
        }
        if (cnt==9)return;

        powerSet(cnt+1, sum, isCheck,count);
        isCheck[cnt]=true;
        powerSet(cnt+1,sum+s[cnt], isCheck,count+1);
        isCheck[cnt]=false;
    }
}
