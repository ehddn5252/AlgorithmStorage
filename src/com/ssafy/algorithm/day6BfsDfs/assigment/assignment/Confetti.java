package com.ssafy.algorithm.day6BfsDfs.assigment.assignment;
// 색종이 접기
import java.io.*;
import java.util.StringTokenizer;

public class Confetti {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] map;
    static int[] callingNum;

    public static void main(String[] args) throws IOException {
        map = new int[100][100];
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int confettiNum = Integer.parseInt(br.readLine());
        for (int confettiIndex = 1; confettiIndex < confettiNum + 1; ++confettiIndex) {
            int[] inputI = str2intArray(br.readLine());
            attach(inputI[0], inputI[1]);
        }
        bw.write(String.format("%d",calcu()));
        bw.flush();
        bw.close();
    }

    static int calcu(){
        int sum = 0;
        for(int i=0;i<100;++i){
            for(int j=0;j<100;++j){
                if (map[i][j]==1){
                    sum+=1;
                }
            }
        }
        return sum;
    }

    static void attach(int mRow,int mCol) {
        for(int rowIndex=100-mRow-10;rowIndex<100-mRow;++rowIndex){
            for(int colIndex=mCol;colIndex<10+mCol;++colIndex){
                map[rowIndex][colIndex]=1;
            }
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
