package com.ssafy.algorithm.day13Graph.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
public class AdjNodeTest {
    static int N;

    static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex =vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int C = sc.nextInt();
        Node[] adjList = new Node[N];


        for (int i = 0; i < C; ++i) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }


        for (Node head : adjList) {
            System.out.println(head.toString());
        }

        bfs(adjList,0);
    }

    public static void bfs(Node[] adjList, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char) (current + 65));

            for (Node temp = adjList[current];temp != null; temp=temp.link) {
                if (!visited[temp.vertex]) {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }
}
