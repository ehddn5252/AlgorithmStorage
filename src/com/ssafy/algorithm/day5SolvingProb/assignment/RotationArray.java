package com.ssafy.algorithm.day5SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제명: BJ16926 배열올리기1
작성일자: 2022.02.09

 */

public class RotationArray {
    private static int[][] _array;

    static int layerNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputInfo = str2intArray(br.readLine());

        _array = new int[inputInfo[0]][inputInfo[1]];
        for(int rowIndex=0;rowIndex<_array.length;++rowIndex){
            int[] inputs = str2intArray(br.readLine());
            for(int colIndex=0;colIndex<_array[0].length;++colIndex){
                _array[rowIndex][colIndex]=inputs[colIndex];
            }
        }
        layerNum = Math.min(inputInfo[0], inputInfo[1]) / 2;
        mainLogic(inputInfo[2]);
        print2ArrayInt(_array);
    }

    static void print2ArrayInt(int[][] _array){
        for(int[] i:_array){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void mainLogic(int rotationNum){
        for(int rotationIndex=0;rotationIndex<rotationNum;++rotationIndex){
            rotate(0,0, _array.length,_array[0].length,0);
            //System.out.println("=========== index: "+rotationIndex+"============");
        }
    }

    static void rotate(int startRow,int startCol,int rowLength, int colLength,int layerIndex){
        if (layerNum==layerIndex)return;
        int setTmp=0;
        int beforeTmp = 0;
        int changeTmp=0;
        int changeTmp2=0;
        int changeTmp3=0;
        // 좌로 이동
        for(int i = startCol+colLength-2;i>=startCol;--i){
            if (i==startCol+colLength-2){
                setTmp = _array[startRow][i];
                changeTmp = _array[startRow][startCol];
                _array[startRow][i] = _array[startRow][i+1];
            }
            else{
                beforeTmp = _array[startRow][i];
                _array[startRow][i] = setTmp;
                setTmp = beforeTmp;
            }
        }

        // 아래로
        for(int i=startRow;i<=startRow+rowLength-2;++i){
            if(i==startRow){
                setTmp = _array[i+1][startCol];
                changeTmp2 = _array[startRow+rowLength-1][startCol];
                _array[i+1][startCol] = changeTmp;
            }
            else{
                beforeTmp = _array[i+1][startCol];
                _array[i+1][startCol] = setTmp;
                setTmp = beforeTmp;
            }
        }
        // 오른쪽
        for(int i=startCol;i<=startCol+colLength-2;i++){
            if (i==startCol){
                setTmp = _array[startRow+rowLength-1][i+1];
                changeTmp3 = _array[startRow+rowLength-1][startCol+colLength-1];
                _array[startRow+rowLength-1][i+1] = changeTmp2;
            }
            else{
                beforeTmp = _array[startRow+rowLength-1][i+1];
                _array[startRow+rowLength-1][i+1] = setTmp;
                setTmp = beforeTmp;
            }
        }
        // 위로
        for(int i=startRow+rowLength-2;i>=startRow;--i){
            if(i==startRow+rowLength-2){
                setTmp = _array[i][startCol+colLength-1];
                _array[i][startCol+colLength-1] = changeTmp3;
            }
            else{
                beforeTmp = _array[i][startCol+colLength-1];
                _array[i][startCol+colLength-1] = setTmp;
                setTmp = beforeTmp;
            }
        }
        rotate(startRow+1, startCol+1, rowLength-2, colLength-2,layerIndex+1);
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
