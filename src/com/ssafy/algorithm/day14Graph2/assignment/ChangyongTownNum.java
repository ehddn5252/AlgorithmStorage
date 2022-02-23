package com.ssafy.algorithm.day14Graph2.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ChangyongTownNum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {

        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 1; testCaseIndex < testCaseNum + 1; ++testCaseIndex) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            makeSet();
            for (int i = 0; i < M; ++i) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                union(a, b);
            }
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i=1;i<parents.length;++i){
                parents[i]=findSet(i);
            }

            for (int i = 1; i < parents.length; ++i) {
                //System.out.print(parents[i]+" ");
                set.add(parents[i]);
            }
            System.out.println("#" + testCaseIndex + " " + set.size());
        }
    }

    public static void makeSet() {
        parents = new Integer[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            parents[i] = i;
        }
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    private static int findSet(int a) {
        //루트값 찾기
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }
}
