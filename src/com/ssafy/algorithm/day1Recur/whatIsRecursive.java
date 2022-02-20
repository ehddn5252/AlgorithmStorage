package com.ssafy.algorithm.day1Recur;

/*
문제명: 백준 17478 재귀함수가 뭔가요?
https://www.acmicpc.net/problem/17478
작성일자: 2022.02.03
작성자: 김동우
문제요약:
1. 어느 컴퓨터 공학과 학생이 ....
는 딱 한번만 나온다. firstPrint()로 사용
2. "재귀함수가 뭔가요?"는 입력수 +1 만큼 나온다. 
그리고 반복시마다 ____이 붙는다.
3. 잘 들어보게, ..... 3줄은
입력수만큼 나온다.
4. "재귀 함수는 자기 자신을 호출하는 함수라네" 는
딱 한번 나온다.
5. "라고 답변하였지." 는
입력수 + 1 만큼 나온다.

생각할 해볼 것: string 별로 몇번씩 나오는 지 확인하고, 각각 나오는 것을 분리하여 생각하자.
문제 풀이:
0. num 을 입력으로 받는다
1. 먼저 1번문장은 1번만 나오므로 1번만 써준다.
2. 2번 문장은 num +1번 나온다. 그래서 몇 번 썼는 지 count 하면서 추가해준다.
   추가로 ____가 붙는데, 이는 입력을 i==0부터 i==num 까지 확인하고 return 을 뒤에 하면될 것이다.
3. 3번 문장은 num 만큼 나온다. 그리고 2번 문장 바로 다음에 나오는 데, 만약 num 만큼 print 되었다면 return 한다.
4. 4번문장을 1번만 호출한다. 4번문장에는 ____이 num수만큼 붙어있으므로 parameter로는 num을 준다.
5. 5번 문장은 num +1만큼 나온다. 그리고 값을 i==num 부터 받고 --i를 넣어서 i==0이면 return하게 만들면 된다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class whatIsRecursive {
    static int recurNum=0;
    // 정상 사이클
    // a는 맨 처음 한번만 돈다
    static String a = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String b = "\"재귀함수가 뭔가요?\"";
    // 정상 답변
    static String c = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String d = "라고 답변하였지.";
    // 2 recur 답변 a b e1 e2 e3 b e1 e2 e3 b e1 e2 e3 c d d d
    static String e1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String e2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String e3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        // 1. 맨 처음 한번만 도는 print문
        printFirstText();
        //
        printQuestionText(0,num);
        printAns(num);
        printLastText(num);
    }

    // 
    public static void printFirstText(){
        System.out.println(a);
    }
    //
    public static void printQuestionText(int i,int times){
        String s = spacebar(i);
        System.out.print(s);
        System.out.println(b);
        if (times==i){
            return;
        }
        printRecurText(i++);
        printQuestionText(i++,times);
    }

    public static void printRecurText(int times){
        String s = spacebar(times);
        System.out.print(s);
        System.out.println(e1);
        System.out.print(s);
        System.out.println(e2);
        System.out.print(s);
        System.out.println(e3);
    }
    public static void printAns(int times){
        String s = spacebar(times);
        System.out.print(s);
        System.out.println(c);
    }

    // clear
    public static void printLastText(int times){
        String s = spacebar(times);
        System.out.print(s);
        System.out.println(d);
        if (times==0){
            return;
        }
        printLastText(--times);
    }

    // 반복시마다 ____를 붙여주기 때문에 ____를 return 해주는 함수를 따로 구현.
    public static String spacebar(int times){
        String s = "";
        String spaceNum = "____";
        for(int i = 0;i<times;++i){
            s+=spaceNum;
        }
        return s;
    }
}
