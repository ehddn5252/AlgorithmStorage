package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, p, q, t;
    public static void main(String[] args) throws IOException {
        // input
        String[] s = br.readLine().split(" ");
        w = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        p = Integer.parseInt(s2[0]);
        q = Integer.parseInt(s2[1]);
        t = Integer.parseInt(br.readLine());
        // p, q에서 출발, w h 사이즈 똑같이 t초 지난 상태이다.
        int x = (p+t)% (2*w);
        int y = (q+t)% (2*h);
        x = w - Math.abs(w-x);
        y = h - Math.abs(h-y);
        System.out.println(x+" "+y);
    }
}

