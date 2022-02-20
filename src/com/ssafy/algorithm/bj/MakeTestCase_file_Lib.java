package com.ssafy.algorithm.bj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MakeTestCase_file_Lib {

    public static void main(String[] args) {
        try {
            int rowNum = 10;//makeRandomNumber(1,10);
            int colNum = 4;//makeRandomNumber(1,10);
            int minData = makeRandomNumber(0,1);
            int maxData = makeRandomNumber(2,2);
            int[][] data = makeData(rowNum,colNum,minData,maxData);
            OutputStream output = openFile("src/com/ssafy/bj/Output.txt");
            writeSingleData(output, rowNum);
            writeIntArrayData(output,data);
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    static OutputStream openFile(String fileName) throws FileNotFoundException {
        OutputStream output = new FileOutputStream(fileName);
        return output;
    }

    static int makeRandomNumber(int nMin, int nMax) {
        return (int) (Math.random() * (nMax - nMin+1) + nMin);
    }

    static int[][] makeData(int row, int col, int minData, int maxData) {
        int[][] datas = new int[row][col];
        int data;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                data = makeRandomNumber(minData, maxData);
                datas[i][j] = data;
            }
        }
        return datas;
    }

    static void writeIntArrayData(OutputStream output, int[][] datas) throws IOException {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<datas.length;++i){
            for(int j=0;j<datas[0].length;++j){
                if(j!=datas[0].length-1){
                    str.append(datas[i][j]+" ");
                }
                else{
                    str.append(datas[i][j]);
                }
            }
            str.append("\n");
        }
        byte[] by = String.valueOf(str).getBytes();
        output.write(by);
    }
    static<E> void  writeSingleData(OutputStream output,E data) throws IOException {
        String newString = String.valueOf(data)+"\n";
        byte[] by = newString.getBytes();
        output.write(by);
    }
}
