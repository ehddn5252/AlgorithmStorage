package com.ssafy.day7SolvingProb.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SungbinCodeCalcurator2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static char[] infix;
    static StringBuilder postfix;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            bw.write(String.format("#%d ", tc));
            N = Integer.parseInt(br.readLine());
            infix = new char[N];
            infix = br.readLine().toCharArray();
            postfix = new StringBuilder();

            makePostfix();
            bw.write(calculator() + "\n");

        }
        bw.flush();
        bw.close();
    }

    public static int calculator() {
        char[] postfixArr = postfix.toString().toCharArray();
        Stack<Integer> calStack = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            if (postfixArr[i] == '+') {
                int a = calStack.pop();
                int b = calStack.pop();
                calStack.push(a + b);
            } else if (postfixArr[i] == '*') {
                int a = calStack.pop();
                int b = calStack.pop();
                calStack.push(a * b);
            } else {
                calStack.push((int) (postfixArr[i] - '0'));
            }
        }

        return calStack.pop();
    }

    public static void makePostfix() {
        for (int i = 0; i < N; i++) {
            switch (infix[i]) {
                case '*':
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '*') {
                            while (!stack.isEmpty() && stack.peek() == '*') {
                                postfix.append(stack.pop());
                            }
                        }
                    }
                    stack.push(infix[i]);
                    break;

                case '+':
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '*' || stack.peek() == '+') {
                            while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '+')) {
                                postfix.append(stack.pop());
                            }
                        }
                    }
                    stack.push(infix[i]);
                    break;

                default:
                    postfix.append(infix[i]);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
    }
}