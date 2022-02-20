package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, p, q, t;
    static direction state = direction.RIGHTDOWN;
    public static void main(String[] args) throws IOException {
        // input
        String[] s = br.readLine().split(" ");
        w = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        p = Integer.parseInt(s2[0]);
        q = h-Integer.parseInt(s2[1]);
        t = Integer.parseInt(br.readLine());
        mainLogic();
        System.out.println(p+" "+q);
    }

    static void mainLogic(){
        while(t>0){
            move();
            t--;
        }
    }
    static void move(){

    };

    enum direction {
        RIGHTUP, RIGHTDOWN, LEFTUP, LEFTDOWN
    }
}

