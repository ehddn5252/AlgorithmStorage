package com.ssafy.day6BfsDfs.assigment.assignment;

import java.io.*;
import java.util.StringTokenizer;

// 문제명: BJ_2578
public class BingGo {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] map;
    static int[] callingNum;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[5][5];
        for (int i = 0; i < 5; ++i) {
            int[] inputs = str2intArray(br.readLine());
            for (int j = 0; j < 5; ++j) {
                map[i][j] = inputs[j];
            }
        }
        callingNum = new int[25];
        for (int i = 0; i < 5; ++i) {
            int[] inputs = str2intArray(br.readLine());
            for (int j = 0; j < 5; ++j) {
                callingNum[i * 5 + j] = inputs[j];
            }
        }
        mainLogic();
    }

    static void mainLogic() throws IOException {
        for (int callingIndex = 0; callingIndex < callingNum.length; ++callingIndex) {

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; ++j) {
                    if (callingNum[callingIndex]==map[i][j]){
                        map[i][j]=0;
                    }
                }
            }
            if(checkBinggo()){
                bw.write(String.format("%d",callingIndex+1));
                bw.flush();
                bw.close();
                return;
            }
        }
    }

    static boolean checkBinggo(){
        int binggoCount=0;
        // 가로
        for (int i = 0; i < 5; i++) {
            int checkRow = 0;
            for (int j = 0; j < 5; ++j) {
                if(map[i][j]==0){
                    checkRow+=1;
                }
            }
            if (checkRow==5){
                binggoCount+=1;
            }
        }
        // 세로
        for (int i = 0; i < 5; i++) {
            int checkCol = 0;
            for (int j = 0; j < 5; ++j) {
                if(map[j][i]==0){
                    checkCol+=1;
                }
            }
            if (checkCol==5){
                binggoCount+=1;
            }
        }

        // 대각선
        if(map[0][0]==0 && map[1][1]==0 && map[2][2]==0 && map[3][3]==0 && map[4][4]==0){
            binggoCount+=1;
        }
        if(map[4][0]==0 && map[3][1]==0 && map[2][2]==0 && map[1][3]==0 && map[0][4]==0){
            binggoCount+=1;
        }
        if (binggoCount>=3) {
            return true;
        }
        else{
            return false;
        }
    }

    static int[] str2intArray(String str){
        String[] strList=str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }
}
