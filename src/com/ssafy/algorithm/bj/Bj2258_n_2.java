package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2258_n_2 {
    // 일정 가격 미만의 고기들은 덤으로 얻을 수 있다.
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
        if (checkMaxValue < M) {
            System.out.println(-1);
            return;
        } else if (M == 0) {
            System.out.println(0);
            return;
        }
        Collections.sort(l);

        int totalWeight = 0;
        long result = 0;
        long maxResult = Long.MAX_VALUE;
        long before = 0;
        int times = 1;
        for (int i = 0; i < l.size(); ++i) {

            Meat tmp = l.get(i);
            if (before == tmp.price) {
                times += 1;
            }
            else{
                times=1;
            }
            totalWeight += tmp.weight;
            if (totalWeight >= M) {
                result = tmp.price*times;
                if(maxResult>result){
                    maxResult=result;
                }
            }
            before = tmp.price;
        }
        System.out.println(maxResult);
    }

    static long checkMaxWeight() {
        long retWeight = 0;
        for (int i = 0; i < size; ++i) {
            Meat tmp = l.get(i);
            retWeight += tmp.weight;
        }
        return retWeight;
    }

    static class Meat implements Comparable<Meat> {
        long weight;
        long price;

        public Meat(long weight, long price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Meat o) {
            if(this.price==o.price){
                return (int)(o.weight-this.weight);
            }
            return (int) (this.price - o.price);
        }
    }
}
