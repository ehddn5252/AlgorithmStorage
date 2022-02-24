package com.ssafy.algorithm.day15SolvingProb.othersCode;
/* 반례
12
1 2
1 3
2 4
3 5
3 6
4 7
7 8
7 11
8 9
9 10
11 12

 */
import java.io.*;
import java.util.*;

public class sujin_Bj2533_n {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> map = new ArrayList<List<Integer>>();

        //0:방문 안함, 1:no얼리, 2:얼리
        int[] visited = new int[N + 1];
        int answer = 0;

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }
        //리프노드찾기
        Queue<Integer[]> leapN = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (map.get(i).size() == 1) {
                leapN.add(new Integer[]{i, 0});
                visited[i] = 1;
            }
        }
        while (!leapN.isEmpty()) {
            Integer[] a = leapN.poll();

            for (int i : map.get(a[0])) {
                if (visited[i] == 0) {
                    if (a[1] % 2 == 1) visited[i] = 1;
                    else {
                        visited[i] = 2;
                    }
                    leapN.add(new Integer[]{i, a[1] + 1});
                }
                if (visited[a[0]] == 1) {
                    if (visited[i] == 1) {
                        visited[i] = 2;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 2) answer++;
        }
        System.out.print(answer);
    }
}