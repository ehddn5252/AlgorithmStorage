package com.ssafy.algorithm.day14Graph2.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class setOfEachOther {
    static int N,M;
    static int[] parents;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testcaseIndex=1;testcaseIndex<testCaseNum+1;++testcaseIndex){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            System.out.print("#"+testcaseIndex+" ");
            makeSet();
            for(int i=0;i<M;++i){
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);
                if(s[0].equals("0")){
                    union(a,b);
                }
                else{
                    System.out.print(isSameParents(a,b));
                }
            }
            System.out.println();
        }
    }

    public static int isSameParents(int a, int b){
        if(findSet(a)==findSet(b)) return 1;
        else return 0;
    }

    public static void makeSet(){
        parents = new int[N+1];

        for(int i=0;i<N+1;++i){
            parents[i] = i;
        }
    }

    private static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot==bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    private static int findSet(int a){
        if(a==parents[a])return a;
        return parents[a] = findSet(parents[a]);
    }
}
