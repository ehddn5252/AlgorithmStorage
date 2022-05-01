package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. 첫째 줄에는 V와 E가 빈칸을 사이에 두고 주어진다.
2. a번 마을에는 b번 마을로 가는 거리가 c인 도로가 있다.
V는 400이다. 최대 크기는 400 * 400 이라 int[][]로 해도 메모리 초과는 안날 듯
 */

public class Bj1956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V,E, map[][];
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        V = sToI(s[0]);
        E = sToI(s[1]);
        map = new int[V][V];
        for(int i=0;i<E;++i){
            s = br.readLine().split(" ");
            map[sToI(s[0])][sToI(s[1])]= sToI(s[2]);
        }
        mainLogic();
    }

    // 사이클을 찾는 것이다. 모든 좌표를 확인해서 각 좌표의 부모값이 같으면
    private static void mainLogic() {

    }

    static int sToI(String s){
        return Integer.parseInt(s);
    }
}
