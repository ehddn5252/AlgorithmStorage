package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 메모리 초과
public class Bj9019_n {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 0; testCaseIndex < testCaseNum; ++testCaseIndex) {
            int A = 0, B = 0;
            String[] s = br.readLine().split(" ");
            A = Integer.parseInt(s[0]);
            B = Integer.parseInt(s[1]);
            // BFS 로 푼다.
            BFS(A, B);
        }
    }

    private static void BFS(int a, int b) {
        Queue<Register> q = new LinkedList<Register>();
        q.offer(new Register(a, ""));
        while (!q.isEmpty()) {
            Register r = q.poll();

            if (r.num == b) {
                System.out.println(r.resultString);
                break;
            }
            q.offer(new Register(D(r.num), r.resultString + "D"));
            q.offer(new Register(S(r.num), r.resultString + "S"));
            q.offer(new Register(L(r.num), r.resultString + "L"));
            q.offer(new Register(R(r.num), r.resultString + "R"));
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
