package com.ssafy.algorithm.newDay9ComThink1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj1708_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Pos> l = new ArrayList<Pos>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            l.add(new Pos(x,y));
        }
        Collections.sort(l);

    }
    static class Pos implements Comparable<Pos>{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o) {
            if(o.x>x){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
