package com.ssafy.algorithm.day5SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제명: BJ16935 배열올리기3
 */

public class RotationArray3 {
    private static int[][] _array;
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
        int[] calcu = str2intArray(br.readLine());
        mainLogic(calcu);
    }

    static void print2ArrayInt(int[][] _array){
        for(int[] i:_array){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void mainLogic(int[] calcu){
        /*
        1. 배열 상하 반전
        2. 배열 좌우 반전
        3. 오른쪽으로 90도 회전
        4. 왼쪽으로 90도 회전
        5. 4구역 시계방향 변경
        6. 4구역 반시계 방향 변경
        */

        for(int i=0;i<calcu.length;++i){
            switch (calcu[i]){
                case 1:
                    reverseUpDown();
                    break;
                case 2:
                    reverseLeftRight();
                    break;
                case 3:
                    rotateRight90();
                    break;
                case 4:
                    rotateLeft90();
                    break;
                case 5:
                    rotateRight();
                    break;
                case 6:
                    rotateLeft();
                    break;
            }
        }
        print2ArrayInt(_array);
    }

    static void rotateLeft(){
        int[][] tmpArray = arrayCloning(_array);
        // 구역 2를 구역 1로
        for(int rowIndex=0;rowIndex<tmpArray.length/2;++rowIndex){
            for(int colIndex = 0; colIndex<tmpArray[0].length/2;++colIndex){
                tmpArray[rowIndex][colIndex] = _array[rowIndex][tmpArray[0].length/2+colIndex];
            }
        }
        // 구역3을 구역 2로
        for(int rowIndex=0;rowIndex<tmpArray.length/2;++rowIndex){
            for(int colIndex = tmpArray[0].length/2; colIndex<tmpArray[0].length;++colIndex){
                tmpArray[rowIndex][colIndex] = _array[tmpArray.length/2+rowIndex][colIndex];
            }
        }

        // 4구역을 구역 3
        for(int rowIndex = tmpArray.length/2;rowIndex<tmpArray.length;++rowIndex){
            for(int colIndex = tmpArray[0].length/2; colIndex<tmpArray[0].length;++colIndex){
                tmpArray[rowIndex][colIndex] = _array[rowIndex][colIndex-tmpArray[0].length/2];
            }
        }

        // 1구역을 구역 4
        for(int rowIndex=tmpArray.length/2;rowIndex<tmpArray.length;++rowIndex){
            for(int colIndex = 0; colIndex<tmpArray[0].length/2;++colIndex){
                tmpArray[rowIndex][colIndex] = _array[rowIndex-tmpArray.length/2][colIndex];
            }
        }
        _array = tmpArray;

    }

    static void rotateRight(){
        int[][] tmpArray = arrayCloning(_array);
        // 구역 1를 구역 2로
        for(int rowIndex=0;rowIndex<tmpArray.length/2;++rowIndex){
            for(int colIndex = 0; colIndex<tmpArray[0].length/2;++colIndex){
                tmpArray[rowIndex][tmpArray[0].length/2+colIndex] = _array[rowIndex][colIndex];
            }
        }
        // 구역2을 구역 3로
        for(int rowIndex=0;rowIndex<tmpArray.length/2;++rowIndex){
            for(int colIndex = tmpArray[0].length/2; colIndex<tmpArray[0].length;++colIndex){
                tmpArray[tmpArray.length/2+rowIndex][colIndex] = _array[rowIndex][colIndex];
            }
        }

        // 3구역을 구역 4
        for(int rowIndex = tmpArray.length/2;rowIndex<tmpArray.length;++rowIndex){
            for(int colIndex = tmpArray[0].length/2; colIndex<tmpArray[0].length;++colIndex){
                tmpArray[rowIndex][colIndex-tmpArray[0].length/2] = _array[rowIndex][colIndex];
            }
        }

        // 4구역을 구역 1
        for(int rowIndex=tmpArray.length/2;rowIndex<tmpArray.length;++rowIndex){
            for(int colIndex = 0; colIndex<tmpArray[0].length/2;++colIndex){
                tmpArray[rowIndex-tmpArray.length/2][colIndex] = _array[rowIndex][colIndex];
            }
        }
        _array = tmpArray;

    }



    static void reverseUpDown(){
        int[][] tmpArray = arrayCloning(_array);
        for(int i=0;i<tmpArray.length;++i){
            tmpArray[i]=_array[tmpArray.length-i-1];
        }
        _array = tmpArray;
    }
    static void reverseLeftRight(){
        int[][] tmpArray = arrayCloning(_array);

        for(int rowIndex=0;rowIndex<tmpArray.length;++rowIndex){
            for(int colIndex=0;colIndex<tmpArray[0].length;++colIndex){
                tmpArray[rowIndex][colIndex]=_array[rowIndex][tmpArray[0].length-colIndex-1];
            }
        }
        _array = tmpArray;
    }

    static void rotateRight90(){
        int[][] tmpArray2 = new int[_array[0].length][_array.length];

        for(int rowIndex=0;rowIndex<_array[0].length;++rowIndex){
            for(int colIndex=0;colIndex<_array.length;++colIndex){
                tmpArray2[rowIndex][colIndex] =_array[_array.length-1-colIndex][rowIndex];
            }
        }
        _array = tmpArray2;
    }

    static void rotateLeft90() {
        int[][] tmpArray2 = new int[_array[0].length][_array.length];
        for (int rowIndex = 0; rowIndex < _array[0].length; ++rowIndex) {
            for (int colIndex = 0; colIndex < _array.length; ++colIndex) {
                tmpArray2[rowIndex][colIndex] = _array[colIndex][_array[0].length - 1 - rowIndex];
            }
        }
        _array = tmpArray2;
    }

    static int[][] arrayCloning(int[][] array2D){
        int[][] newArray = new int[array2D.length][array2D[0].length];
        for(int i=0;i<array2D.length;++i){
            newArray[i]=array2D[i].clone();
        }
        return newArray;
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
