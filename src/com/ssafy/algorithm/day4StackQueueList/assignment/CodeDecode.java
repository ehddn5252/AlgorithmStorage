package com.ssafy.algorithm.day4StackQueueList.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
두 번째 줄 : 원본 암호문
세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
네 번째 줄 : 명령어
 */

public class CodeDecode {
    static final int TESTCASE_NUM=10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> l;
        for(int testCaseIndex=1; testCaseIndex<TESTCASE_NUM+1; ++testCaseIndex){
            br.readLine();
            String[] str = br.readLine().split(" ");
            // string[] to linked list;
            l = new LinkedList<String>(Arrays.asList(str));
            int commanderNum = Integer.parseInt(br.readLine());
            String[] commands = br.readLine().split(" ");
            printTestCaseNum(testCaseIndex);
            printList(mainLogic(l, commanderNum,commands));
        }
    }

    static void printTestCaseNum(int testCaseIndex){
        System.out.print("#"+testCaseIndex+" ");
    }

    static void printList(List<String> l){

        for(int i=0;i<10;++i){
            System.out.print(l.get(i)+" ");
        }
        System.out.println();
    }

    static void printStringList(String[] str){
        for(int i=0;i<str.length;++i){
            System.out.print(str[i]+" ");
        }
        System.out.println();
    }

    static List<String> mainLogic(List<String> l, int commanderNum,String[] commands){
        //printStringList(commands);
        int nowIndex =0;
        int commanderIndex=0;
        while(commanderIndex <commanderNum) {
            if (commands[nowIndex].equals("I")){
                nowIndex += 1;
                int position = Integer.parseInt(commands[nowIndex]);
                nowIndex += 1;
                int inputNum = Integer.parseInt(commands[nowIndex]);
                for(int i=0;i<inputNum;++i){
                    nowIndex +=1;
                    l.add(position,commands[nowIndex]);
                    position+=1;
                }
                nowIndex +=1;
                commanderIndex+=1;
            }
        }
        return l;
    }
}
