package com.ssafy;

import java.util.ArrayList;

public class myLibrary {

    static int[] str2intArray(String str){
        String[] strList=str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }

    static void printTestCaseNum(int testCaseIndex){
        System.out.print("#"+testCaseIndex+" ");
    }

    private static void debuging(int index, int currentBiggerLength,int currentSmallerLength,int maxLength){
        System.out.println("index: "+index);
        System.out.println("currentBiggerLength: "+currentBiggerLength);
        System.out.println("currentSmallerLength: "+currentSmallerLength);
        System.out.println("maxLength: "+ maxLength);
        System.out.println("==================");
    }


    static int[][] arrayCloning(int[][] array2D){
        int[][] newArray = new int[array2D.length][array2D[0].length];
        for(int i=0;i<array2D.length;++i){
            newArray[i]=array2D[i].clone();
        }
        return newArray;
    }

    static void print2ArrayInt(int[][] _array){
        for(int[] i:_array){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static <E> void printArrayList(ArrayList<E> _array, String str){
        System.out.println(str);
        for(E i:_array){
            System.out.print(i+" ");
        }
    }

}
