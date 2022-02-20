package com.ssafy.algorithm.day3PCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int []> rest = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int j = 0; j < N; j++) {
            int h = Integer.parseInt(st.nextToken());

            while (!rest.isEmpty()) {
                if (rest.peek()[1]<h) {
                    rest.pop();
                }
                else {
                    System.out.printf("%d ",rest.peek()[0]+1);
                    break;
                }
            }

            if (rest.isEmpty()) {
                System.out.printf("0 ");
            }
            rest.push(new int[] {j,h});
        }

    }
}