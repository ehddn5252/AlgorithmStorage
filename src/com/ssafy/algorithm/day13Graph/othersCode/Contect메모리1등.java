package com.ssafy.algorithm.day13Graph.othersCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Contect메모리1등 {

    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            super();
            this.vertex = vertex;
            this.next = next;
        }

    }

    static int visited[];
    static Node[] nList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            String line = in.readLine();
            st = new StringTokenizer(line);
            int L = Integer.parseInt(st.nextToken()); // 다음줄에 입력받을 숫자 갯수
            int V = Integer.parseInt(st.nextToken()); // 시작 노드
            Queue<Integer> queue = new LinkedList<Integer>();
            visited = new int[101];
            nList = new Node[101];

            line = in.readLine();
            st = new StringTokenizer(line);//******토크나이저실험 얘 없애보자
            for (int k = 0; k < L / 2; k++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nList[a] = new Node(b, nList[a]);//생성자에 추가한 nList는 null이었을 것이다.

            }
            int lastcnt = 0;
            int current = V;
            queue.offer(V);
            Stack<Integer> aq = new Stack<>();
            aq.push(V);
            visited[V] = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                //System.out.println(queue);
                lastcnt = queue.size();

                while (--size >= 0) {
                    current = queue.poll();
                    for (Node temp = nList[current]; temp != null; temp = temp.next) {
                        if (visited[temp.vertex] == 0) {
                            queue.offer(temp.vertex);
                            aq.push(temp.vertex);
                            visited[temp.vertex] = 1;
                        }
                    }
                }

            }
            //System.out.println(lastcnt);
            int max = 0;
            for (int i = 0; i < lastcnt; i++) {
                int tmp = aq.pop();
                //System.out.print(tmp+" ");
                if (tmp > max) {
                    max = tmp;
                }
            }
            //System.out.println();
            System.out.println("#" + tc + " " + max);

        }
    }

}