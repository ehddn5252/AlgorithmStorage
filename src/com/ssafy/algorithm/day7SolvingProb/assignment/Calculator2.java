package com.ssafy.algorithm.day7SolvingProb.assignment;
// 계산기2 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 계산식이 주어질 때, 이를 후위 표기식으로 수정해서 문제를 풀어라.
// 방법1: 그냥 *만 먼저 다 쓰고 + 다 쓰면 될듯 일단 쉬운 방법 먼저 ㄱㄱ
// 방법2: tree 생성해서 후위 방식으로 만들기
public class Calculator2 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private final static int TESTCASE_NUM = 10;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<TESTCASE_NUM;++i){
            int num = Integer.parseInt(br.readLine());
            String str  = br.readLine();
            String[] ss = new String[str.length()];
            for(int j=0;j<str.length();++j){
                ss[j] = Character.toString(str.charAt(j));
            }
            printTestCaseNum(i+1);
            mainLogic(ss);
        }
    }
    static void mainLogic(String[] str){
        ArrayList<String> al = new ArrayList<>();

        //setting
        for(int i=0;i<str.length;++i){
            al.add(str[i]);
        }
        int currentIndex = 1;
        int size = al.size()-1;

        while(true){
            if(currentIndex>=size)break;
            if (al.get(currentIndex).equals("*")){
                al.remove(currentIndex);
                int num = Integer.parseInt(al.remove(currentIndex));
                 al.set(currentIndex-1,Integer.toString((Integer.parseInt(al.get(currentIndex-1)) * num)));
                size-=2;
            }
            else{
                currentIndex+=1;
            }
        }
        size = al.size()-1;
        currentIndex=0;
        while(true){
            if(size<=1)break;
            if (al.get(currentIndex).equals("+")){
                al.remove(currentIndex);
                int num = Integer.parseInt(al.remove(currentIndex));
                al.set(currentIndex-1,Integer.toString((Integer.parseInt(al.get(currentIndex-1)) + num)));
                size-=2;
            }
            else{
                currentIndex+=1;
            }
        }
        System.out.println(Integer.parseInt(al.get(0)));
    }

    static <E> void printArrayList(ArrayList<E> _array){
        for(E i:_array){
            System.out.print(i+" ");
        }
    }
    static void printTestCaseNum(int testCaseIndex){
        System.out.print("#"+testCaseIndex+" ");
    }
}
