package com.ssafy.algorithm.day5SolvingProb;
import java.util.ArrayList;
import java.util.Scanner;

// 2605 줄세우기

public class RowSort {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();
        for(int i=0;i<studentNum;++i){
            int studentIndex = sc.nextInt();
            al.add(i-studentIndex,i+1);
        }

        for(int i=0;i<al.size();++i){
            System.out.print(al.get(i)+" ");
        }
    }
}
