package com.ssafy.algorithm.newDay5SolvingProb.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> l;
    static int k, c, d, N;

    public static void main(String[] args) throws IOException {
        // input
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 접시의 수
        d = Integer.parseInt(s[1]); // 초밥 가짓수
        k = Integer.parseInt(s[2]); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(s[3]); // 쿠폰 번호
        l = new ArrayList<Integer>(3003000);
        // 초밥을 2번 넣는다.
        for (int i = 0; i < N; ++i) {
            int item = Integer.parseInt(br.readLine());
            l.add(item);
        }
        for (int i = 0; i < k; ++i) l.add(l.get(i));

        // map에 초밥을 새팅해놓고 카운팅
        //
        mainLogic();
    }

    private static void mainLogic() {
        int maxSize = 0;
        for (int i = 0; i < N + 1; ++i) {
            HashSet<Integer> set = new HashSet<>();
            int nowSize = 0;
            for (int j = i; j < i + k; ++j)
                set.add(l.get(j));

            if (set.contains(c)) nowSize = set.size();
            else nowSize = set.size() + 1;

            if (nowSize > maxSize) maxSize = nowSize;
            if(maxSize==d) break;
        }
        System.out.println(maxSize);
    }
}
