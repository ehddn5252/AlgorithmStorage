package com.ssafy.algorithm.newDay9ComThink1.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1708 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Pos> l = new ArrayList<Pos>(100000);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        /* 맨 처음 x,y를 저장한다.
        1. x,y를 입력받는다.
        2. 첫번째하고 두번째는 순서대로 stack 에 넣는다.
        3. 첫번째와 두번째의 벡터를 구한다. (x2-x1,y2-y1)
        4. 그 다음 오는 것의 벡터를 구한다. (x3-x3, y3-y2)
        5.
         */
        Stack<Pos> s = new Stack<>();
        Pos tmpPos = new Pos();
        for (int i = 0; i < N+1; ++i) {
            int x,y;
            if(i!=N) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                if(i==0) tmpPos = new Pos(x, y);
            }
            else{
                x= tmpPos.x;
                y= tmpPos.y;
            }
            if (i == 0 || i == 1) s.push(new Pos(x, y));
            else {
                Pos secondPos = s.pop();
                Pos firstPos = s.pop();
                s.push(firstPos);
                Pos getV = getVector(firstPos.x, firstPos.y, secondPos.x, secondPos.y);
                Pos getV2 = getVector(secondPos.x, secondPos.y, x, y);
                if (externalProduct(getV.x, getV.y, getV2.x, getV2.y)) {
                    s.push(secondPos);
                    s.push(new Pos(x, y));
                } else s.push(new Pos(x, y));
            }
        }
        System.out.println(s.size());
    }

    private static Pos getVector(int x, int y, int x1, int y1) {
        return new Pos(x1 - x, y1 - y);
    }

    private static boolean externalProduct(int x, int y, int x1, int y1) {
        if ((x * y1) - (x1 * y) > 0) return true;
        else return false;
    }

    static class Pos {
        int x;
        int y;
        public Pos() {}
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
