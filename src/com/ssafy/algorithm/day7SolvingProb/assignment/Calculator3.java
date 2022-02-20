package com.ssafy.algorithm.day7SolvingProb.assignment;
// 계산기3 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Calculator3 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private final static int TESTCASE_NUM = 10;
    private static Stack<Character> postfix = new Stack<Character>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < TESTCASE_NUM; ++i) {
            br.readLine();
            char[] formula = br.readLine().toCharArray();
            printTestCaseNum(i + 1);
            System.out.println(mainLogic(formula));
        }
    }

    private static int mainLogic(char[] formula) {
        makePostfix(formula);
        return calcurate();
    }


    private static void makePostfix(char[] formula) {
        Stack<Character> operators = new Stack<Character>();
    /*
    1. 피연산자는 스택에 넣지 않고 바로 postfix에 넣는다.
    2. 연산자는 스택이 비어 있으면 스택에 push한다.
    3. 연산자는 스택이 비어있지 않으면 스택에 있는 연산자와의 우선순위를 비교해 스택에 있는 연산자의
    우선순위가 같거나 크다면 스택에 있는 연산자를 pop을 한 후 postfix에 넣고 현재 연산자는 stack에 push
    4. 만약 현재 연산자의 우선순위가 더 크면 현재 연산자를 바로 push한다.
     */
        for (int i = 0; i < formula.length; ++i) {
            switch (formula[i]) {
                case '(':
                    operators.push(formula[i]);
                    break;
                case '*':
                    if(!operators.isEmpty()){
                        if(operators.peek()=='*'){
                            while(!operators.isEmpty() && operators.peek()=='*'){
                                if(operators.peek()=='('){
                                    operators.pop();
                                }
                                else{
                                    postfix.push(operators.pop());
                                }
                            }
                        }
                    }
                    operators.push(formula[i]);
                    break;
                case '+':
                    if(!operators.isEmpty()){
                        if(operators.peek()=='+' || operators.peek()=='*'){
                            while(!operators.isEmpty() && (operators.peek()=='+' || operators.peek()=='*')){
                                if(operators.peek()=='('){
                                    operators.pop();
                                }
                                else{
                                    postfix.push(operators.pop());
                                }
                            }
                        }
                    }
                    operators.push(formula[i]);
                    break;
                case ')':
                    while (!operators.isEmpty() && (operators.peek() !='(')) {
                        postfix.push(operators.pop());
                    }
                    operators.pop();
                    break;
                default:
                    postfix.push(formula[i]);
            }
        }
        while(!operators.isEmpty()){
            postfix.push(operators.pop());
        }

        //printArrayList(postfix);
    }

    private static int calcurate(){
        Stack<Integer> numStack= new Stack<Integer>();
        int num1,num2;
        for(int i=0;i< postfix.size();++i){
            if(postfix.get(i)=='*') {
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num1*num2);
            }
            else if(postfix.get(i)=='+'){
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num1+num2);
                }
            else{
                numStack.push((int)postfix.get(i)-'0');
            }
        }
        return numStack.pop();
    }

    private static <E> void printArrayList(List<E> _array) {
        for (E i : _array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printTestCaseNum(int testCaseIndex) {
        System.out.print("#" + testCaseIndex + " ");
    }
}
