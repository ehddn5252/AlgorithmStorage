package com.ssafy.day11Backtracking.practice;

import java.util.Scanner;

public class NQueenBackTrackingTest {


    static int N,ans;
    static int col[];
    public static void main(String[] args){

        ans=0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];
        setQueen(1);
        System.out.println(ans);
    }

    public static void setQueen(int rowNo){ // rowNo : 퀸을 두어야하는 현재 행

        if(!isAvailable(rowNo-1)) return; //직전까지의 상황이 유망하지 않으면

        
        // 기본 파트: 퀸을 모두 놓았다면
        if(rowNo>N){
            ans++;
            return;

        }

        for(int i=1;i<=N;++i){
            col[rowNo] = i;
            setQueen(rowNo+1);
        }
    }

    public static boolean isAvailable(int rowNo){ // rowNo : 놓여진 마지막 퀸
        for(int i=1;i<rowNo;++i) {
            if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) return false;
        }
        return true;
    }


}
