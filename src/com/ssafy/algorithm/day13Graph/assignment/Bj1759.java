// 암호 만들기
package com.ssafy.algorithm.day13Graph.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L,C;
    static String[] alphabets;
    static String[] result;
    static String[] vowel= new String[]{"a","e","i","o","u"};

    /*
    L길이의 암호, C가지 알파벳 소문자일때 증가하는 순서로 암호가 구성되어 있다.
     */

    public static void main(String[] args) throws IOException {
        String[] s =br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        result = new String[r];
        alphabets = new String[C];
        for(int i=0;i<s2.length;++i){
            alphabets[i]=s2[i];
        }
        Arrays.sort(alphabets);
        mainLogic(0,0,r);
    }

    static void mainLogic(int cnt,int start, int r){
        if(cnt==r){
            int vowelCount=0;
            for(int i=0;i<result.length;++i){
                for(int j=0;j<vowel.length;++j){
                    if(vowel[j].equals(result[i])){
                        vowelCount+=1;
                        break;
                    }
                }
            }
            if(vowelCount>=1 && r-vowelCount>=2){
                for(int i=0;i<result.length;++i){
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i=start;i<alphabets.length;++i){
            result[cnt] = alphabets[i];
            mainLogic(cnt+1,i+1,r);
        }
    }
}