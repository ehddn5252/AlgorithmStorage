package com.ssafy.day8FullSearch.assignment;
// 과제
import java.util.Scanner;

public class SevenLittleBoy {
    static int[] littleBoys = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean stop;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; ++i) {
            littleBoys[i] = sc.nextInt();
        }
        powerSet(0,0,0);
    }

    static void powerSet(int cnt,int sum,int count) {

        if(stop) return;
        if(cnt == 9) {
            if (sum == 100 && count==7) {
                stop=true;
                for (int i = 0; i < 9; ++i) {
                    if (visited[i])
                        System.out.println(littleBoys[i]);
                }
            }
            return;
        }

        visited[cnt] = true;
        powerSet(cnt+1,sum+littleBoys[cnt],count+1);
        visited[cnt] = false;
        powerSet(cnt+1,sum,count);

    }
}
