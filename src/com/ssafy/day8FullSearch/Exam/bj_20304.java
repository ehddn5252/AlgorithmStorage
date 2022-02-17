package com.ssafy.day8FullSearch.Exam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1. N은 비밀번호 max값
2. 비밀번호의 안전거리는 이진법으로 표현한 두 비밀번호의 서로 다른 자리의 개수.
3. 안전도는 지금까지 로그인 시도에 사용된 모든 비밀번호와의 안전 거리 중 최솟값.

 */
public class bj_20304 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int maxDigit, maxBinary;
    static int[] passwords;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        passwords = new int[M];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; ++i) {
            passwords[i] = Integer.parseInt(s[i]);
        }
        mainLogic();
    }

    static int getOneNumber(int k) {
        int sum = 0;
        while (k > 0) {
            sum += k % 2;
            k/=2;
        }
        return sum;
    }

    // check clear
    static void findMax() {
        int tmp = N;
        int sum = 0;
        while (tmp > 0) {
            sum += 1;
            tmp /= 2;
        }
        maxDigit = sum;
        maxBinary = (int) Math.pow(2, sum - 1);
    }


    static void mainLogic() {
        // 0. N은 최댓값이므로 나열한 원소들보다 항상 크다.
        // 1. 나열된 원소들을 순서대로 정렬한다.
        // 2. 각 원소들을 최댓값과 이를 뺀 수부터의 값 사이 바로 아래 역수와 비트마스크 연산을 하고 xor 하고 난 수의 1의 개수 최소를 찾는다.
        // 3.

        // 여기에서 maxDigit 과 maxBinary 를 찾는다.
        findMax();

        int maxDistance = 99999;
        int minDistance = 0;
        int saveNum=0;
        int x = passwords[0];
        Arrays.sort(passwords);
        for (int i = 1; i < passwords.length; ++i) {
            x ^= passwords[i];
        }
        int oneNumber;

        for(int i=1;i<N;++i){
            oneNumber = getOneNumber(x^i);
            if(oneNumber>minDistance){
                minDistance = oneNumber;
                saveNum = i;
            }
        }
        for(int i=0;i<passwords.length;++i){
            int tmp = getOneNumber(saveNum^passwords[i]);
            if(maxDistance>tmp){
                maxDistance = tmp;
            }
        }
        System.out.println(maxDistance);
    }

}
