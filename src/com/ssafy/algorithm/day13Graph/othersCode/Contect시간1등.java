package com.ssafy.algorithm.day13Graph.othersCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Contect시간1등 {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 0; test_case < 10; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[101][101];
            int[] check = new int[101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }
            int max = 0;
            int max1 = 0;


            Queue<Member> queue = new LinkedList<>();

            queue.add(new Member(M, 0));
            check[M] = 1;

            while (!queue.isEmpty()) {
                Member n = queue.poll();
                //System.out.println(""+n.toString());

                Boolean flag = false;
                for (int i = 1; i <= 100; i++) {
                    if (map[n.getN()][i] == 1 && check[i] != 1) {
                        check[i] = 1;
                        queue.add(new Member(i, n.getD() + 1));
                        flag = true;
                        //System.out.print(" "+i);

                    }
                }
                //System.out.println("");
                if (max1 < n.getD() && !flag) {
                    max1 = Math.max(max1, n.getD());
                    max = n.getN();
                }
                if (max1 == n.getD() && !flag) {
                    //System.out.println("마지막: "+n.toString());
                    max = Math.max(max, n.getN());

                }
            }


            System.out.println("#" + (test_case + 1) + " " + (max));

        }
    }

}

class Member {
    int n;
    int d;

    @Override
    public String toString() {
        return "Member{" +
                "n=" + n +
                ", d=" + d +
                '}';
    }

    public Member(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public int getN() {

        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}