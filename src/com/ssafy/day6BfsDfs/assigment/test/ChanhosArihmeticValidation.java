package com.ssafy.day6BfsDfs.assigment.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChanhosArihmeticValidation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        for(int t=1; t<=10; t++) {
            int len = Integer.parseInt(br.readLine());
            boolean[] tree = new boolean[len+1];
            String[] input;
            String temp;
            for(int i=0; i<len; i++) {
                input = br.readLine().split(" ");
                temp = input[1];
                if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")) {
                    tree[i+1] = false;
                }else {
                    tree[i+1] = true;
                }
            }
            boolean search= true;
            for(int i=len;i>=3;i-- ) {
                if(tree[i]&&tree[i-1]&&!tree[i/2]) {
                    tree[i/2] = true;
                    i--;
                }else {
                    search = false;
                    break;
                }
            }
            if(search && tree[1]) {
                System.out.println("#"+t+" 1");
            } else {
                System.out.println("#"+t+" 0");
            }
        }
    }
}