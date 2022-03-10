package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bj10282_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visit;
    static int[][] adjMatrix;


    public static void main(String[] args) throws IOException {

        int testCaseNum = Integer.parseInt(br.readLine());
        for (int testCaseIndex = 0; testCaseIndex < testCaseNum; ++testCaseIndex) {
            String[] s = br.readLine().split(" ");
            int computerNum = Integer.parseInt(s[0]) + 1;
            int dependency = Integer.parseInt(s[1]);
            int hackedComputer = Integer.parseInt(s[2]);
            adjMatrix = new int[computerNum][computerNum];

            visit = new boolean[computerNum];
            //visit = new boolean[computerNum][computerNum];
            for (int i = 0; i < dependency; ++i) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                adjMatrix[b][a] = time;
            }
            int[] distance = new int[computerNum];
            distance[hackedComputer] = 0;

            for (int i = 0; i < computerNum; ++i) {
                int min = Integer.MAX_VALUE, current = 0;
                for (int j = 0; j < computerNum; ++j) {
                    if (!visit[j] && min > distance[j]) {
                        min = distance[j];
                        current = j;
                    }
                }

                visit[current] = true;
                for (int j = 0; j < computerNum; ++j) {
                    if (!visit[j] && adjMatrix[current][j] != 0 && distance[j] > distance[current] + adjMatrix[current][j]) {
                        distance[j] = distance[current] + adjMatrix[current][j];
                    }
                }
            }

            for(int i=0;i<adjMatrix.length;++i){
                for(int j=0;j<adjMatrix[0].length;++j){
                    System.out.print(adjMatrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}