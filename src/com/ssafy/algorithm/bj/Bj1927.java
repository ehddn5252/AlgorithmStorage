package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bj1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int commandNum = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(commandNum);

        for(int i = 0; i< commandNum; ++i ){
            int currentNum = Integer.parseInt(br.readLine());
            if(currentNum!=0) q.offer(currentNum);
            else{
                if(!q.isEmpty()) System.out.println(q.poll());
                else System.out.println(0);
            }
        }
    }
}
