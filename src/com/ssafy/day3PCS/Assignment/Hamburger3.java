package com.ssafy.day3PCS.Assignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hamburger3 {
    public static int maxCalorie;
    public static int maxTasteScore = 0;
    public static void main(String[] args) throws IOException {
        ArrayList<int[]> hamburgerInfo = new ArrayList<>();
        // 정보 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=1;testCaseIndex<=testCaseNum;++testCaseIndex) {

            int[] ingredientNumAndMaxCalorie = strArray2intArray(br.readLine().split(" "));
            int ingredientNum = ingredientNumAndMaxCalorie[0];
            maxCalorie = ingredientNumAndMaxCalorie[1];
            for (int i = 0; i < ingredientNum; ++i) {
                int[] tasteAndCalorie = strArray2intArray(br.readLine().split(" "));
                hamburgerInfo.add(tasteAndCalorie);
            }

            // 구현
            powerSet(hamburgerInfo,0,0,0);
            System.out.println("#"+testCaseIndex+" "+maxTasteScore);
            maxTasteScore=0;
        }
    }

    static void powerSet(ArrayList<int[]> hamburgerInfo,int currentCalorie, int currentScore, int cnt){

        if (currentCalorie>maxCalorie) return;
        if(cnt==hamburgerInfo.size()){
            if( currentScore>maxTasteScore){
                maxTasteScore = currentScore;
            }
            return;
        }

        powerSet(hamburgerInfo,currentCalorie+ hamburgerInfo.get(cnt)[1],currentScore+hamburgerInfo.get(cnt)[0],cnt+1);
        powerSet(hamburgerInfo,currentCalorie, currentScore,cnt+1);
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for(int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }
}
