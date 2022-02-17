package com.ssafy.day9Greedy.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
/*
1. N 개의 화학물질 C1, C2, C3, Cn 이 있다.
2. 이들 각각 보관되어야 할 온도가 각기 다른데, 각 Ci 마다 최저 보관 온도 Xi와 최고 보관 온도 Yi가 정해져 있다.
3. Ci는 온도 Xi 이상 Yi 이하의 온도에서 보관되어야만 안전하다.
4. 냉장고는 임의의 정해진 온도를 일정하게 유지할 수 있고, 냉장고는 아주 크다고 가정한다.

필요한 냉장고의 수를 출력하시오.
 */

// 최소, 최대 값을 찾는
public class JungOl1828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Tmp> chemicalMaterials = new ArrayList<Tmp>(100);

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            Tmp t = new Tmp(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            chemicalMaterials.add(t);
        }
        // 구현
        mainLogic();
    }
    // 1. 최저 온도 기준으로 내림차순으로 정렬한다.
    // 2. 이전 인덱스의 최대 온도 값이 지금 인덱스에 있는 최대 온도보다 낮으면 pass 해준다.
    // 2-1. 이전 인덱스의 최대 온도 값이 지금 인덱스에 있는 최대 온도보다 높으면 count+=1 하고 다음 인덱스를 maxIndex 로 한다.

    // Comparable은 자기 자신과 매개변수 객체를 비교한다.

    static void mainLogic() {
        Collections.sort(chemicalMaterials);
        int count = 1;
        int[] tmpList = new int[100];
        int beforeMaxTemp =chemicalMaterials.get(0).maxTemp;
        int beforeMinTemp =chemicalMaterials.get(0).minTemp;
        for(int i=1;i<chemicalMaterials.size();++i){
            int nowMaxTemp =chemicalMaterials.get(i).maxTemp;
            int nowMinTemp =chemicalMaterials.get(i).minTemp;
            // 현재 인덱스의 최대온도가 이전 인덱스의 최저온도보다 작으면 count +=1;
            // 이전온도의 최대 온도를 현재 온도의 최대로 설정해줌.
            if(nowMaxTemp < beforeMinTemp){
                beforeMaxTemp = nowMaxTemp;
                beforeMinTemp = nowMinTemp;
                count+=1;
            }
//            else if(nowMaxTemp<beforeMaxTemp && nowMaxTemp>beforeMinTemp){
//
//            }
            // 현재 인덱스의 최대 온도가 이전 온도의 최대온도보다 크면 pass
        }
        System.out.println(count);
        // 처음부터 끝까지 확인하는데,
        //printAll(chemicalMaterials);
    }

    static void printAll(ArrayList<Tmp> t) {
        System.out.println("===========");
        for (int i = 0; i < t.size(); ++i) {
            System.out.println("minTmp: " + t.get(i).minTemp + "maxTmp: " + t.get(i).maxTemp);
        }
        System.out.println("===========");

    }

    static class Tmp implements Comparable<Tmp> {
        int minTemp;
        int maxTemp;

        public Tmp(int minTemp, int maxTemp) {
            this.maxTemp = maxTemp;
            this.minTemp = minTemp;
        }

        // minTemp 기준 내림차순 정렬
        @Override
        public int compareTo(Tmp o) {
            if (this.minTemp > o.minTemp) {
                return -1;
            } else {
                return 1;
            }
            //return this.minTemp(compareTo(o.minTemp));
        }
    }
}
