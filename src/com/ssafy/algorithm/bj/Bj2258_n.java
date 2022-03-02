package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj2258_n {
    // 일정 가격 이하의 고기들은 덤으로 얻을 수 있다.
    // 원하는 양의 고기를 구매하기 위해 필요한 최소 비용을 구하시오
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long M;
    static long size;
    static ArrayList<Meat> l = new ArrayList<Meat>(100000);

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for (int i = 0; i < N; ++i) {
            s = br.readLine().split(" ");
            long weight = Integer.parseInt(s[0]);
            long price = Integer.parseInt(s[1]);
            l.add(new Meat(weight, price));
        }
        size = l.size();

        long checkMaxValue = checkMaxWeight();
        if(checkMaxValue<M){
            System.out.println(-1);
            return;
        }

        long calcWeight =0;
        long result =-1;
        long start = 0;
        long end = 2147483647;
        long mid=0;
        while (start <= end) {
            mid = (start + end) / 2;
            calcWeight = checkWeight(mid);

//            System.out.println("calcWeight");
//            System.out.println(calcWeight);
//            System.out.println("mid");
//            System.out.println(mid);

            // 계산한 weight 가 원하는 M보다 크거나 같으면 가격을 낮춰야 한다.
            if(calcWeight>=M){
                end= mid-1;
                result = mid;
            }
            // 계산한 weight 가 원하는 M 보다 작으면 가격을 높여야 한다.
            else if(calcWeight<M){
                start= mid+1;
            }
        }
        System.out.println(result);
    }

    static long checkWeight(long mid) {
        long retWeight = 0;
        for (int i = 0; i < size; ++i) {
            Meat tmp = l.get(i);
            if (tmp.price <= mid) {
                retWeight += tmp.weight;
            }
        }
        return retWeight;
    }

    static long checkMaxWeight() {
        long retWeight = 0;
        for (int i = 0; i < size; ++i) {
            Meat tmp = l.get(i);
            retWeight += tmp.weight;
        }
        return retWeight;
    }

    static class Meat {
        long weight;
        long price;

        public Meat(long weight, long price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
