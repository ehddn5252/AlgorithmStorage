package com.ssafy.algorithm.day5SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
문제명: BJ16926 배열올리기1
작성일자: 2022.02.09

 */

public class RotationArray4 {
    private static int[][] _array;
    private static int[][] _arrayTmp;
    private static int[][] numbers;
    private static boolean[] isVisited;
    static int layerNum;
    private static int globalMin=99999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputInfo = str2intArray(br.readLine());

        _array = new int[inputInfo[0]][inputInfo[1]];
        _arrayTmp = new int[inputInfo[0]][inputInfo[1]];
        for (int rowIndex = 0; rowIndex < _array.length; ++rowIndex) {
            int[] inputs = str2intArray(br.readLine());
            for (int colIndex = 0; colIndex < _array[0].length; ++colIndex) {
                _array[rowIndex][colIndex] = inputs[colIndex];
                _arrayTmp[rowIndex][colIndex] = inputs[colIndex];
            }
        }
        layerNum = Math.min(inputInfo[0], inputInfo[1]) / 2;
        mainLogic(inputInfo[2], br);
    }

    static void print2ArrayInt(int[][] _array) {
        for (int[] i : _array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void mainLogic(int rotationNum, BufferedReader br) throws IOException {
        numbers = new int[rotationNum][3];
        isVisited = new boolean[rotationNum];
        ArrayList<int[]> s = new ArrayList<>();
        for (int rotationIndex = 0; rotationIndex < rotationNum; ++rotationIndex) {
            // 여기서 순열 적용
            int[] rcs = str2intArray(br.readLine());
            for (int i = 0; i < 3; ++i) {
                numbers[rotationIndex][i] = rcs[i];
            }
            //rotate(rcs[0]-rcs[2]-1,rcs[1]-rcs[2]-1, rcs[2]*2+1,rcs[2]*2+1);
        }
        permu(0);
        System.out.println(globalMin);
    }

    static int calcuColSum() {
        int min = 500000;
        for (int i = 0; i < _array.length; ++i) {
            int sum = 0;
            for (int j = 0; j < _array[0].length; ++j) {
                sum += _array[i][j];
            }
            if (min > sum) {
                min = sum;
            }
        }
        return min;
    }

    /*

     */
    static void permu(int cnt) {
        if (cnt == isVisited.length) {
            //print2ArrayInt(numbers);
            for(int i=0;i<numbers.length;++i){
                rotate(numbers[i][0]-numbers[i][2]-1,numbers[i][1]-numbers[i][2]-1, numbers[i][2]*2+1,numbers[i][2]*2+1);
            }
            int currentMin=calcuColSum();
            if(globalMin>currentMin){
                globalMin = currentMin;
            }
            // 다시 리셋
            for (int rowIndex = 0; rowIndex < _array.length; ++rowIndex) {
                for (int colIndex = 0; colIndex < _array[0].length; ++colIndex) {
                    _array[rowIndex][colIndex] = _arrayTmp[rowIndex][colIndex];
                }
            }
            return;
        }

        for (int i = cnt; i < isVisited.length; ++i) {
            int[] tmp0=new int[3];
            if (isVisited[cnt]) continue;
            for(int j=0;j<3;++j){
                tmp0[j] = numbers[cnt][j];
                numbers[cnt][j]=numbers[i][j];
                numbers[i][j] =tmp0[j];
            }
            permu(cnt + 1);
            for(int j=0;j<3;++j){
                tmp0[j] = numbers[cnt][j];
                numbers[cnt][j]=numbers[i][j];
                numbers[i][j] =tmp0[j];
            }
        }
    }

    static void rotate(int startRow, int startCol, int rowLength, int colLength) {
        if (rowLength <= 1 || colLength <= 1) return;

        int setTmp = 0;
        int beforeTmp = 0;
        int changeTmp = 0;
        int changeTmp2 = 0;
        int changeTmp3 = 0;

        // 오른쪽으로 이동
        for (int i = startCol; i <= startCol + colLength - 2; ++i) {
            if (i == startCol) {
                // 두번째 값
                setTmp = _array[startRow][i + 1];
                // startrow의 startRow, 오른쪽끝 값
                changeTmp = _array[startRow][startCol + colLength - 1];
                // 첫번째값을 두번째 값에 넣음
                _array[startRow][i + 1] = _array[startRow][i];
            } else {
                // 3번째값부터 저장
                beforeTmp = _array[startRow][i + 1];
                // 두번째값을 3번째 값에 넣음
                _array[startRow][i + 1] = setTmp;
                // 3번쨰 값 저장
                setTmp = beforeTmp;
            }
        }

        // 아래로 이동
        for (int i = startRow; i <= startRow + rowLength - 2; ++i) {
            if (i == startRow) {
                // 두번째 값
                setTmp = _array[i + 1][startCol + colLength - 1];
                // 맨 끝 값
                changeTmp2 = _array[startRow + rowLength - 1][startCol + colLength - 1];
                // 첫번째 값을  두번째 값에 넣음
                _array[i + 1][startCol + colLength - 1] = changeTmp;
            } else {
                // 세번째 값
                beforeTmp = _array[i + 1][startCol + colLength - 1];
                // 두번째 값 을 3번째 값에 넣음
                _array[i + 1][startCol + colLength - 1] = setTmp;
                // 세번째 값을 저장
                setTmp = beforeTmp;
            }
        }

        // 왼쪽
        for (int i = startCol + colLength - 2; i >= startCol; i--) {
            if (i == startCol + colLength - 2) {
                // 두번째 값 저장
                setTmp = _array[startRow + rowLength - 1][i];
                // 맨 끝값 저장
                changeTmp3 = _array[startRow + rowLength - 1][startCol];
                // 첫번째 값 두번째 에 넣음
                _array[startRow + rowLength - 1][i] = changeTmp2;
            } else {
                // 세번째 값 저장
                beforeTmp = _array[startRow + rowLength - 1][i];
                // 세번째 값에 두번째 값 넣음
                _array[startRow + rowLength - 1][i] = setTmp;
                setTmp = beforeTmp;
            }
        }

        // 위로
        for (int i = startRow + rowLength - 2; i >= startRow; --i) {
            if (i == startRow + rowLength - 2) {
                // 두번째 값 저장
                setTmp = _array[i][startCol];
                // 두번째 값에 첫번째 값 저장
                _array[i][startCol] = changeTmp3;
            } else {
                // 세번째 값 저장
                beforeTmp = _array[i][startCol];
                _array[i][startCol] = setTmp;
                setTmp = beforeTmp;
            }
        }
        // 재귀호출
        rotate(startRow + 1, startCol + 1, rowLength - 2, colLength - 2);
    }

    static int[] str2intArray(String str) {
        String[] strList = str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }
}
