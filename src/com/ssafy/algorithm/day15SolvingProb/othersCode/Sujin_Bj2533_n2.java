package com.ssafy.algorithm.day15SolvingProb.othersCode;

import java.io.*;
import java.util.*;

public class Sujin_Bj2533_n2 {
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
        //0:방문 안함, 1:no 얼리, 2:얼리
        total:
        while (!leapN.isEmpty()) {
            Integer[] a = leapN.poll();
            Integer[] tmp = null;
            int sum = 0;

            for (int i : map.get(a[0])) {
                if (visited[i] == 1) visited[a[0]] = 2;

                if (visited[i] == 0) {
                    sum++;
                    if (sum >= 2) {
                        visited[a[0]] = 0;
                        continue total;
                    }
                    if (a[1] % 2 == 1) visited[a[0]] = 2;
                    else visited[a[0]] = 1;

                    tmp = new Integer[]{i, a[1] + 1};
                }
            }
            if (sum == 1) leapN.add(tmp);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 2) answer++;
        }
        System.out.print(answer);
    }
}