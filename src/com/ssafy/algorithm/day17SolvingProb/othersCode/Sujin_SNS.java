package com.ssafy.algorithm.day17SolvingProb.othersCode;

import java.io.*;
import java.util.*;

public class Sujin_SNS {
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

        int[] size = new int[N + 1];
        //리프노드찾기
        Queue<Integer> leapN = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            size[i] = map.get(i).size();
            if (map.get(i).size() == 1) {
                leapN.add(i);
                visited[i] = 1;
            }
        }

        while (!leapN.isEmpty()) {
            int a = leapN.poll();

            for (int i : map.get(a)) {
                size[i]--;

                if (visited[i] == 1) {
                    visited[a] = 2;
                    break;
                }

                if (visited[i] == 0) {
                    if (size[i] <= 1) {
                        leapN.add(i);
                    }
                }
            }
            if (visited[a] == 0) {
                visited[a] = 1;
            }
        }


        for (int i = 1; i <= N; i++) {
            if (visited[i] == 2) answer++;
        }
        System.out.print(answer);
    }
}