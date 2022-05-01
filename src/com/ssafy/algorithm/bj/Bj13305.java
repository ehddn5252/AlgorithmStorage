package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj13305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] edge, node;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 도로의 개수
        String[] s = br.readLine().split(" ");
        edge = new long[N - 1];
        for (int i = 0; i < s.length; ++i) edge[i] = Integer.parseInt(s[i]);
        node = new long[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; ++i) node[i] = Integer.parseInt(s[i]);
        mainLogic();
    }

    private static void mainLogic() {
        long ans = node[0] * edge[0];
        long maxTmp=node[0];
        for(int i=1;i<node.length-1;++i){
            if(node[i]<maxTmp) maxTmp = node[i];
            if(i!=0) ans = maxTmp * edge[i] + ans;
            else ans = maxTmp * edge[i];
        }
        System.out.println(ans);
    }
}
