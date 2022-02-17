package com.ssafy.day10SovingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] bList;
    static int check=0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        bList = new int[N][N];
        int[] inputArray = new int[N];
        for (int i = 0; i < N; ++i) {
            inputArray = str2IntArray(br.readLine());
            for (int j = 0; j < N; ++j) {
                bList[i][j] = inputArray[j];
            }
        }
        int size = N * N;
        mainLogic(0, 0, size);
    }

    static void mainLogic(int row, int col, int size) {
        //printAll(row,col,size);
        if (check(row, col, size, 0)) {
            System.out.print("0");

            return;
        }
        else if (check(row, col, size, 1)){
            System.out.print("1");
            return;
        }
        else{
            System.out.print("(");
        }

        size /= 4;
        int addLocation = (int) Math.sqrt(size);
        check+=1;
        //1사분면
        mainLogic(row, col, size);
        //2사분면
        mainLogic(row, col + addLocation, size);
        //3사분면
        mainLogic(row + addLocation, col, size);
        //4사분면
        mainLogic(row + addLocation, col + addLocation, size);
        System.out.print(")");
    }

    static void printAll(int row, int col, int size){
        System.out.println("==============");
        for (int i = row; i < row + Math.sqrt(size); ++i) {
            for (int j = col; j < col + Math.sqrt(size); ++j) {
                System.out.print(bList[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    static boolean check(int row, int col, int size, int c) {
        int cNum = 0;

        for (int i = row; i < row + Math.sqrt(size); ++i) {
            for (int j = col; j < col + Math.sqrt(size); ++j) {
                if (bList[i][j]==c) {
                    cNum += 1;
                }
                else{
                    return false;
                }
            }
        }

        if (cNum == Math.sqrt(size)*Math.sqrt(size)) {
            return true;
        }else{
            return false;
        }
    }

    static int[] str2IntArray(String str) {
        int[] intArray = new int[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            intArray[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return intArray;
    }

}
