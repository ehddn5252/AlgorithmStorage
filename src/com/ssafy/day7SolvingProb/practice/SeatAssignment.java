package com.ssafy.day7SolvingProb.practice;

import java.io.*;

public class SeatAssignment {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int colNum,rowNum, N;
    static int[][] map;
    static char direction ='u'; // U D L R
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        colNum=Integer.parseInt(s[0]);
        rowNum=Integer.parseInt(s[1]);
        map = new int[rowNum][colNum];
        N = Integer.parseInt(br.readLine());

        if(colNum*rowNum<N){
            bw.write(String.format("0"));
            bw.flush();
            bw.close();
            return;
        }
        int nowCol = 0;
        int nowRow = rowNum-1;
        int nowNumber=1;

        while(true){
            //printAll(nowCol,nowRow,nowNumber);
            if(nowNumber==N){
                bw.write(String.format("%d %d",nowCol+1,rowNum-nowRow));
                bw.flush();
                bw.close();
                return;
            }

            map[nowRow][nowCol] = nowNumber;
            if(direction=='u'){

                if(nowRow-1<0 || map[nowRow-1][nowCol]!=0 ){
                    direction='r';
                    nowCol+=1;
                }
                else{
                    nowRow-=1;
                }
            }
            else if(direction=='r'){

                if(nowCol+1>=colNum || map[nowRow][nowCol+1]!=0 ){
                    direction='d';
                    nowRow+=1;
                }
                else{
                    nowCol+=1;
                }
            }
            else if(direction=='d'){

                if(nowRow+1>=rowNum || map[nowRow+1][nowCol]!=0 ){
                    direction='l';
                    nowCol-=1;
                }
                else{
                    nowRow+=1;
                }
            }
            else if(direction=='l'){
                if(nowCol-1<0 || map[nowRow][nowCol-1]!=0 ){
                    direction='u';
                    nowRow-=1;
                }
                else{
                    nowCol-=1;
                }
            }
            nowNumber += 1;
        }
    }
    public static void printAll(int col, int row,int nowNumber){
        System.out.println("col,row, nowNumber");
        System.out.println(col+" "+row+" "+nowNumber);
    }
}
