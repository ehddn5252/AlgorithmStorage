package com.ssafy.algorithm.day3PCS.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
순열 논리
1. 숫자를 만들어 준다.
2. 처음 숫자부터 시작한다.
3. 방문했는 지 확인한다.
4. 방문하지 않았다면 들어간다.
5. 방문했다면 continue
 */

public class NAndM {
    static int[] input,select;
    static boolean[] isCheck;
    public static void main(String[] args) throws IOException {

        // input 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM=strArray2intArray(br.readLine().split(" "));
        input = new int[NM[0]];
        select = new int[NM[1]];
        isCheck = new boolean[NM[0]];
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<input.length ; ++i){
            numbers.add(i);
        }
        perm(numbers, 0 );
    }

    static void perm(ArrayList<Integer> numbers, int cnt){
        if(cnt==select.length){
            for(int i=0;i<cnt;++i)
                if (i==cnt-1) {
                    System.out.println(numbers.get(i)+1);
                }
                else{
                    System.out.print(numbers.get(i)+1+" ");
                }
            return;
        }

        for(int i=0;i< isCheck.length;++i){
            if (isCheck[i]==true)continue;
            isCheck[i] = true;
            numbers.set(cnt,i);
            perm(numbers,cnt+1);
            isCheck[i] = false;
        }
    }

    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }
}
