package com.ssafy.day4StackQueueList.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CodeCreate {
    static final int TESTCASE_NUM = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int testCaseIndex = 1;testCaseIndex < TESTCASE_NUM + 1;testCaseIndex++ ){
            br.readLine();
            int[] intArray = strArray2intArray(br.readLine().split(" "));
            System.out.print("#"+testCaseIndex+" ");
            printAll(businessLogic(queueSetting(intArray)));
        }
    }

    static void printAll(Queue<Integer> q ){
        int qSize = q.size();
        for(int i=0;i<qSize;++i){
            System.out.print(q.poll()+" ");
        }
        System.out.println();
    }

    static Queue<Integer> queueSetting(int[] intArray) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < intArray.length; ++i) {
            q.add(intArray[i]);
        }
        return q;
    }

    static Queue<Integer> businessLogic(Queue<Integer> q){
        int num=1;
        int poppedElement;
        while(true){
            if (num==6){
                num=1;
            }
            poppedElement = q.poll()-num;
            if (poppedElement<=0){
                poppedElement=0;
                q.add(poppedElement);
                return q;
            }
            q.add(poppedElement);
            num+=1;
        }
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }
}
