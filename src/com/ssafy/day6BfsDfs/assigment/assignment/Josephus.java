package com.ssafy.day6BfsDfs.assigment.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 백준 1158 요세푸스 문제.
// 입력: N,K
public class Josephus {
    static int N,K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<Integer> l = new LinkedList<Integer>();
        mainLogic(l);
    }

    static void mainLogic(List<Integer> l){
        List<Integer> newL = new LinkedList<Integer>();

        for(int i=1;i<N+1;++i){
            l.add(i);
        }
        int nowIndex = 0;

        while(true){
            if(l.isEmpty()) {
                break;
            }
            nowIndex = (nowIndex+K-1)% l.size();
            newL.add(l.remove(nowIndex));
        }
        printAll(newL);
    }

    static void printAll(List<Integer> l){
        System.out.print("<");
        for(int i=0;i<l.size();++i){
            if(i!=l.size()-1){
                System.out.print(l.get(i)+", ");
            }
            else{
                System.out.print(l.get(i));

            }
        }
        System.out.print(">");
    }
}
