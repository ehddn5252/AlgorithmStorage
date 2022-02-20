package com.ssafy.algorithm.day7SolvingProb.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JiwonCodeCalcurator2 {

    public static void main(String[] args) throws IOException {

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len;
        String calc;
        for (int j = 1; j <= 10; j++) {
            len = Integer.parseInt(br.readLine());
            calc = br.readLine();
            int rs = 0;
            for (int i = 0; i < len; i++) {
                Character c = calc.charAt(i);
                if ('0' <= c && c <= '9') {
                    nums.push(c - '0');
                    if (!ops.isEmpty() && ops.peek() == '*') {
                        nums.push(nums.pop() * nums.pop());
                    }
                } else {
                    ops.push(c);
                }
            }
            while (!nums.isEmpty()) {
                rs += nums.pop();
            }
            System.out.println("#" + j + " " + rs);
            ops.clear();
        }

    }

}