package com.ssafy.day7SolvingProb.assignment;

import java.io.*;
import java.util.ArrayList;

public class PerfectShuffle {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        //bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex=0;testCaseIndex<testCaseNum;++testCaseIndex){
            N = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            printTestCaseNum(testCaseIndex+1);
            mainLogic(strs);
        }
    }
    static void mainLogic(String[] str){
        ArrayList<String> s = new ArrayList<>();
        for(int i=0;i<Math.ceil((double)str.length/2);++i){
            s.add(str[i]);
        }
        int inputIndex = 1;
        for(int i=(int)Math.ceil((double)str.length/2);i<str.length;++i){
            if (inputIndex>=str.length){
                inputIndex=str.length-1;
            }
            s.add(inputIndex,str[i]);
            inputIndex+=2;
        }
        printArrayList(s);
    }

    static <E> void printArrayList(ArrayList<E> _array){
        for(E i:_array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void printTestCaseNum(int testCaseIndex){
        System.out.print("#"+testCaseIndex+" ");
    }

}

