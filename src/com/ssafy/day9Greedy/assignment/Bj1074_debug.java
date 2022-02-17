package com.ssafy.day9Greedy.assignment;
// 문제명: z

import java.io.*;

public class Bj1074_debug {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    public static void main(String[] args) throws IOException {
        String[] inputStringArray = br.readLine().split(" ");
        // input
        int N,r,c;

        N= Integer.parseInt(inputStringArray[0]);
        int powN = (int)Math.pow(2,N);
        map = new int[powN][powN];
        r= Integer.parseInt(inputStringArray[1]);
        c= Integer.parseInt(inputStringArray[2]);

        //구현
        int size = powN * powN;
        mainLogic(0,0,0,size);
        System.out.println(map[r][c]);
        //mapPrint();
    }

    static void printAll(int row, int col, int value, int size){
        System.out.println("=================");
        System.out.println("row: "+row);
        System.out.println("col: "+col);
        System.out.println("value: "+value);
        System.out.println("size: "+size);
        System.out.println("=================");
    }

    static void mainLogic(int row, int col, int value, int size){
        printAll(row,col,value,size);
        /*
        구역을 아래와 같이 4부분으로 잘라서 생각한다.
        1 2
        3 4
        1번은 기본 위치이고,
        (0,0), (N,0), (0,N), (N,N) 을
         N 2N
        3N 4N
        으로 표현할 수 있고,
        (0,0,N,size), (N,0,2N,size), (0,N,3N,size) (N,N,4N,size) 을 준다.
        이를 N의 사이즈가 1이될 때까지 값을 준다.
        만약 1이되면
        그럼 좌표를 1 2 와 같은 형식으로 설정해준다.
                  3 4
         */

        if( size == 4 ){
            map[row][col]=value;
            map[row][col+1]=value+1;
            map[row+1][col]=value+2;
            map[row+1][col+1]=value+3;
            mapPrint();
            return;
        }
        size/=4;
        int addLocation = (int)Math.sqrt(size);
        //System.out.println("1사분면");
        mainLogic(row,col,value,size);
        //System.out.println("2사분면");
        mainLogic(row,col+addLocation,value+size,size);
        //System.out.println("3사분면");
        mainLogic(row+addLocation,col,value+2*size,size);
        //System.out.println("4사분면");
        mainLogic(row+addLocation,col+addLocation,value+3*size,size);

    }

    static void mapPrint(){
        for(int i=0;i<map.length;++i){
            for(int j=0;j<map[0].length;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
