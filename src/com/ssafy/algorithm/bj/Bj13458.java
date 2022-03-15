package com.ssafy.algorithm.bj;

// 시험감독
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj13458 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N=0;
    static StringTokenizer st;
    static long answer=0;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        answer+=N;
        st = new StringTokenizer(br.readLine());
        String[] s = br.readLine().split(" ");
        int superviseMain = Integer.parseInt(s[0]);
        int superviseSub = Integer.parseInt(s[1]);
        for (int i = 0; i < N; ++i) {
            double p = ((Integer.parseInt(st.nextToken()) -superviseMain));
            if(p>0){
                answer+=Math.ceil(p/superviseSub);
            }
        }
        System.out.println(answer);
    }
}
