package com.ssafy.algorithm.newDay10ComThink2.assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5604_sol {
    static long eachArr[], res, start, end, place;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = Long.parseLong(st.nextToken()); // 0
            end = Long.parseLong(st.nextToken()); // 10

            eachArr = new long[10];
            res = 0;
            place = 1; // 1의자리 수 부터

            // 0은 더해도 의미가 없으니까 + 밑에 조건에 안 걸리게 하려고
            if (start == 0) start = 1; // 1

            while (start <= end) {
                while (start % 10 != 0 && start <= end) {
                    putFirstPlaceNum(start);
                    start++; // 2 3 4 5 6 7 8 9 10
                }
                if (start > end) break;
                while (end % 10 != 9 && start <= end) {
                    putFirstPlaceNum(end);
                    end--; // 9
                }
                // 0~9만큼 나오는게 한 세트니까 10으로 나눴을때의 차이를 넣는다.
                long setDiff = (end / 10) - (start / 10) + 1; // 0
                for (int i = 0; i <= 9; i++) {
                    eachArr[i] += setDiff * place;
                }
                place *= 10;
                start /= 10;
                end /= 10;
            }

            for (int i = 1; i <= 9; i++) {
                res += (i * eachArr[i]);
            }
            sb.append(res).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void putFirstPlaceNum(long l) {
        for (long i = l; i > 0; i /= 10) {
            String s = Long.toString(i);
            // 맨 오른쪽 즉, 1의 자리수를 t에 저장해서 eachArr에 해당되는 숫자에 기존 숫자 기준 자리수만큼 넣어준다
            int t = s.charAt(s.length() - 1) - '0';
            eachArr[t] += place;
        }
    }
}