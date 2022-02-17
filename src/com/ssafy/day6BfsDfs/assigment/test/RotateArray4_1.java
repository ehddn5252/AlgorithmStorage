package com.ssafy.day6BfsDfs.assigment.test;

//조건에 따라 해야할 것들 체크리스트 만들고, 체크를 다 했는 지 확인하면서 풀기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateArray4_1{
    static int N;
    static int M;
    static int K;
    static int globalRowSumMin = Integer.MAX_VALUE;
    static int[][] _array;
    static int[][] _arrayTmp;
    static int[][] commands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        _array = new int[N][M];
        _arrayTmp = new int[N][M];
        commands = new int[K][3];
        for(int i=0;i<N;++i){
            int[] inputI =str2intArray(br.readLine());
            for(int j=0;j<M;++j){
                _array[i][j] = inputI[j];
                _arrayTmp[i][j] = inputI[j];
            }
        }
        for(int i=0;i<K;++i){
            int[] inputI =str2intArray(br.readLine());
            for(int j=0;j<3;++j)
                commands[i][j]=inputI[j];
            }
        mainLogic();
    }

    static void mainLogic(){

        boolean[] isVisted= new boolean[commands.length];
        permutation(0,isVisted);
        System.out.println(globalRowSumMin);
    }

    static void permutation(int cnt,boolean[] isVisited){
        if (cnt == commands.length){

            _array=arrayDeepCopy(_arrayTmp);
            for(int commandIndex=0;commandIndex<commands.length;++commandIndex){
                int r = commands[commandIndex][0];
                int c = commands[commandIndex][1];
                int s = commands[commandIndex][2];
                int depth = (int)s;
                for(int i=0;i<depth;++i){
                    int[][] arraytmp = arrayDeepCopy(_array);
                    rotate(arraytmp,r-s-1+i,c-s-1+i,s*2+1-2*i,s*2+1-2*i);
                }
            }
            getRowSumMin();
            return;
        }

        for(int i=cnt;i<commands.length;++i){
            // 종료조건
            if (isVisited[cnt]) {
                continue;
            }
            //swap
            swap(cnt,i);
            isVisited[cnt]=true;
            //permutation
            permutation(cnt+1,isVisited);
            //swap
            isVisited[cnt]=false;
            swap(cnt,i);
        }
    }

    static void print2ArrayInt(int[][] _array) {
        for (int[] i : _array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] arraytmp,int startRow, int startCol, int rowLength,int colLength){
        if (rowLength<=1)return;
        // 우
        for(int i=0;i<colLength-1;++i){
            _array[startRow][startCol+i+1]= arraytmp[startRow][startCol+i];
        }
        // 하
        for(int i=0;i<rowLength-1;++i){
            _array[startRow+1+i][startCol+colLength-1]= arraytmp[startRow+i][startCol+colLength-1];
        }

        // 좌
        for(int i=0;i<colLength-1;++i){
            _array[startRow+rowLength-1][startCol+i]= arraytmp[startRow+rowLength-1][startCol+i+1];
        }

        // 상
        for(int i=0;i<rowLength-1;++i){
            _array[startRow+i][startCol]= arraytmp[startRow+1+i][startCol];
        }
    }

    static int[][] arrayDeepCopy(int[][] array){
        int[][] newArray= new int[array.length][array[0].length];
        for(int i=0;i<array.length;++i){
            for(int j=0;j<array[0].length;++j){
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }

    static void getRowSumMin(){
        for(int i=0;i<_array.length;++i){
            int sum=0;
            for(int j=0;j<_array[0].length;++j){
                sum+=_array[i][j];
            }
            if(sum<globalRowSumMin){
                globalRowSumMin=sum;
            }
        }
    }

    static void swap(int cnt, int i){
        for(int j=0;j<3;++j){
            int[] tmp = commands[cnt].clone();
            commands[cnt] = commands[i];
            commands[i] = tmp;
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
