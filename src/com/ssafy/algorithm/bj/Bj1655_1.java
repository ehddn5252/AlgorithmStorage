package com.ssafy.algorithm.bj;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Bj1655_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i) {
            int input = Integer.parseInt(br.readLine());
            if (pqMin.size()==pqMax.size()){
                pqMax.offer(input);
            }
            else{
                pqMin.offer(input);
            }
            if(!pqMin.isEmpty() && !pqMax.isEmpty()){
                if(pqMax.peek()>pqMin.peek()){
                    int t1 = pqMax.poll();
                    int t2 = pqMin.poll();
                    pqMax.offer(t2);
                    pqMin.offer(t1);
                }
            }
            bw.write(pqMax.peek()+" ");
        }
        bw.flush();
        bw.close();
    }
}
