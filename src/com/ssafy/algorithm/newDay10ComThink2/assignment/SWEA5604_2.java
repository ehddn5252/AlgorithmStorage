package com.ssafy.algorithm.newDay10ComThink2.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간합
public class SWEA5604_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] eachArr;
    static long start,end, ans, digit;
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex= 1;testCaseIndex<=testCaseNum;++testCaseIndex){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            eachArr = new long[10];
            ans = 0;
            digit = 1; // 자릿수

            if(start==0) start=1;
            while(start<= end){
                while(start % 10 != 0 && start <= end){
                    settingArr(start);
                    start++;
                }
                if(start>end)break;
                while(end % 10 !=9 && start<=end){
                    settingArr(end);
                    end--;
                }

                long diff = (end / 10) -(start/10) +1; //0
                for(int i=0;i<=9;++i) eachArr[i]+=diff* digit;

                digit *=10;
                start /=10;
                end /=10;
            }

            for(int i=1; i<=9;++i) ans += (i * eachArr[i]);
            System.out.println("#"+testCaseIndex+" "+ans);
        }
    }

    private static void settingArr(long l){
        for(long i = l;i>0;i/=10){
            String s = Long.toString(i);
            int t= s.charAt(s.length()-1)-'0';
            eachArr[t]+= digit;
        }
    }
}
