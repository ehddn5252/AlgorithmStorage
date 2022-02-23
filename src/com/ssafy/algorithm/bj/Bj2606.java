package com.ssafy.algorithm.bj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// virus set으로 풀기
public class Bj2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            parents[i] = i;
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            String[] s = br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            union(a,b);
        }
        HashSet<Integer> set = new HashSet<Integer>(){};
        int ans=-1;
        for(int i=1;i<parents.length;++i){
            parents[i]=findSet(i);
            if(parents[i]==parents[1]){
                ans+=1;
            }
        }
        System.out.println(ans);
    }

    static int findSet(int a){
        if (parents[a]==a){
            return a;
        }
        return parents[a] =findSet(parents[a]);
    }

    static boolean union(int a,int b){
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA==rootB)
            return false;
        else{
            parents[rootA] = rootB;
            return true;
        }
    }
}
