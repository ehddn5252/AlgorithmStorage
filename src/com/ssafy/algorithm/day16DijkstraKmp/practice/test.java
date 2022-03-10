package com.ssafy.algorithm.day16DijkstraKmp.practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        // 오름차순
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] parents;
    static Edge[] edgeList;

    public static void makeSet() {
        parents = new int[N];

        for (int i = 0; i < N; ++i) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        edgeList = new Edge[(int)Math.pow(N,2)-N];
        int edgeListIndex=0;
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<N;++j){
                if(i==j) continue;
                int from = i;
                int to = j;
                int weight = Integer.parseInt(s[j]);
                edgeList[edgeListIndex] = new Edge(from, to, weight);
                edgeListIndex+=1;
            }
        }
        Arrays.sort(edgeList);
        makeSet();

        int result = 0;
        int cnt = 0;
        for(Edge edge: edgeList){
            if(union(edge.from,edge.to)){
                result+= edge.weight;
                if(++cnt==N-1)break;
            }
        }
        System.out.println(result);
    }

}
