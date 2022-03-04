package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj9019_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 0; testCaseIndex < testCaseNum; ++testCaseIndex) {
            int A = 0, B = 0;
            String[] s = br.readLine().split(" ");
            A = Integer.parseInt(s[0]);
            B = Integer.parseInt(s[1]);
            // BFS 로 푼다.
            boolean[] visit = new boolean[10000];

            BFS(A, B,visit);
        }
    }

    private static void BFS(int a, int b,boolean[] visit) {
        Queue<Register> q = new LinkedList<Register>(){};
        q.offer(new Register(a, ""));
        while (!q.isEmpty()) {
            Register r = q.poll();
            if (r.num == b) {
                System.out.println(r.resultString);
                break;
            }
            int calcL = L(r.num);
            if(!visit[calcL]){
                visit[calcL]=true;
                q.offer(new Register(calcL, r.resultString + "L"));
            }
            int calcR = R(r.num);
            if(!visit[calcR]){
                visit[calcR]=true;
                q.offer(new Register(calcR, r.resultString + "R"));
            }
            int calcS = S(r.num);
            if(!visit[calcS]){
                visit[calcS]=true;
                q.offer(new Register(calcS, r.resultString + "S"));
            }
            int calcD = D(r.num);
            if(!visit[calcD]){
                visit[calcD]=true;
                q.offer(new Register(calcD, r.resultString + "D"));
            }

        }
    }

    private static int D(int num) {
        return (num * 2) % 10000;
    }

    private static int S(int num) {
        int ret = num - 1;
        if (ret == -1) ret = 9999;
        return ret;
    }

    private static int L(int num) {
        String s = Integer.toString(num);
        while(s.length()!=4){
            s="0"+s;
        }
        String ret = Integer.toString(s.charAt(1) - '0') + s.charAt(2) + s.charAt(3) + s.charAt(0);
        return Integer.parseInt(ret);
    }

    private static int R(int num) {
        String s = Integer.toString(num);
        while(s.length()!=4){
            s="0"+s;
        }
        String ret = Integer.toString(s.charAt(3) - '0') + s.charAt(0) + s.charAt(1) + s.charAt(2);
        return Integer.parseInt(ret);
    }

    static class Register {
        int num;
        String resultString;

        public Register(int num, String result) {
            this.num = num;
            this.resultString = result;
        }
    }
}
