package com.ssafy.algorithm.day3PCS.Assignment;

import java.io.IOException;
import java.util.Scanner;
public class Hamburger {
    public static int maxCalorie;
    public static int maxTasteScore = 0;
    public static void main(String[] args) throws IOException {
        // 정보 입력
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        for(int testCaseIndex=1; testCaseIndex<=testCaseNum; ++testCaseIndex) {
            int ingredientNum = sc.nextInt();
            int[] scores = new int[ingredientNum];
            int[] calories = new int[ingredientNum];
            maxCalorie = sc.nextInt();
            for (int i = 0; i < ingredientNum; ++i) {
                scores[i]= sc.nextInt();
                calories[i]=sc.nextInt();
            }

            // 구현
            powerSet(0,0,0,scores,calories);
            System.out.println("#"+testCaseIndex+" "+maxTasteScore);
            maxTasteScore=0;
        }
    }

    static void powerSet(int currentCalorie, int currentScore, int cnt,int[] scores,int[] calories){
        if (currentCalorie>maxCalorie) return;
        if(cnt==scores.length){
            if( currentScore>maxTasteScore){
                maxTasteScore = currentScore;
            }
            return;
        }
        powerSet(currentCalorie+ calories[cnt],currentScore+scores[cnt],cnt+1,scores,calories);
        powerSet(currentCalorie, currentScore,cnt+1,scores,calories);
    }
}
