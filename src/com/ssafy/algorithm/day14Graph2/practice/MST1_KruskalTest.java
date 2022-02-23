package com.ssafy.algorithm.day14Graph2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(st.nextToken());
        edgeList = new Edge[E];

        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(in.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList);
        makeSet();

        int result = 0;
        int cnt = 0;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if(++cnt==N-1)break;
            }
        }
        System.out.println(result);
    }
}
