package com.ssafy.algorithm;

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

    /*
    시간초 구하기
     */
    static void findTime(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println(secDiffTime);
    }

    // print하기.
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


    // Collections.sort() 사용 가능.
    static class Tmp implements Comparable<Tmp> {
        int minTemp;
        int maxTemp;

        public Tmp(int minTemp, int maxTemp) {
            this.maxTemp = maxTemp;
            this.minTemp = minTemp;
        }

        // minTemp 기준 내림차순 정렬
        @Override
        public int compareTo(Tmp o) {
            if (this.minTemp > o.minTemp) {
                return -1;
            } else {
                return 1;
            }
            //return this.minTemp(compareTo(o.minTemp));
        }
    }

    static void memoryTest(){
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");

    }
}
