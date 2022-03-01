package com.ssafy.algorithm.test;
// 다익스트라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visit;
    static int[] distance;
    static ArrayList<Edge>[] adjList;
    static int V, E, start;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        start = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V+1];
        visit = new boolean[V+1];
        distance = new int[V+1];
        for(int i=1;i<V+1;++i){
            adjList[i]=new ArrayList<>();
        }

        for (int i = 0; i < E; ++i) {
            s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            Edge e = new Edge(to, weight);
            adjList[from].add(e);
        }
        dijkstra(start);

        for(int i=1;i<V+1;++i){
            if(distance[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(distance[i]);
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.offer(new Edge(start,0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int destination = edge.destination;
            if (visit[destination]) continue;
            visit[edge.destination] = true;

            for (Edge next : adjList[destination]) {
                if (distance[next.destination] >= distance[destination]+ next.weight) {
                    distance[next.destination] = distance[destination]+ next.weight;
                    pq.add(new Edge(next.destination,distance[next.destination]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // 오름차순
            return this.weight - o.weight;
        }
    }
}
