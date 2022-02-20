package com.ssafy.algorithm.day3PCS.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hamburger2 {
    private static int maxCalorie;
    private static int maxTasteScore = 0;
    private static int[] scores;
    private static int[] calories;
    public static void main(String[] args) throws IOException {
        // 정보 입력
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1; testCaseIndex<=testCaseNum; ++testCaseIndex) {
            String[] ingredientAndMaxCalorie = br.readLine().split(" ");
            int ingredientNum = Integer.parseInt(ingredientAndMaxCalorie[0]);
            scores = new int[ingredientNum];
            calories = new int[ingredientNum];
            maxCalorie =  Integer.parseInt(ingredientAndMaxCalorie[1]);
            for (int i = 0; i < ingredientNum; ++i) {
                int[] scoresAndCalories = strArray2intArray(br.readLine().split(" "));
                scores[i]= scoresAndCalories[0];
                calories[i]=scoresAndCalories[1];
            }

            // 구현
            powerSet(0,0,0);
            System.out.println("#"+testCaseIndex+" "+maxTasteScore);
            maxTasteScore=0;
        }
    }

    static void powerSet(int currentCalorie, int currentScore, int cnt){
        if (currentCalorie>maxCalorie) return;
        if(cnt==scores.length){
            if( currentScore>maxTasteScore){
                maxTasteScore = currentScore;
            }
            return;
        }
        powerSet(currentCalorie+ calories[cnt],currentScore+scores[cnt],cnt+1);
        powerSet(currentCalorie, currentScore,cnt+1);
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for(int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }
}
