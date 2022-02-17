package com.ssafy.day4StackQueueList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackBrowserTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> backword = new Stack<String>();
        Stack<String> forword = new Stack<String>();

        String current = "http://www.saffy.com";

        while(true){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");

            switch(st.nextToken()){
                case "V":
                    backword.push(current);
                    forword.clear();
                    current = st.nextToken();
                    break;
                case"B":
                    break;
                case"F":
                    break;
            }
        }
    }
}
