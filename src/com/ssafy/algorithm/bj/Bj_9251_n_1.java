package com.ssafy.algorithm.bj;
// LCS
// 메모리초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// LCS 문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
public class Bj_9251_n_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        String s1= br.readLine();
        String s2= br.readLine();
        dp = new int[s1.length()][s2.length()];

        // 기저조건 string1돌고 string2 돌면서 같은거 확인한다.
        for(int i=0;i<s1.length();++i){
            for(int j=0;j<s2.length();++j){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1;
                }
            }
        }
        List<int[]> l = new ArrayList<int[]>(10000);
        l.add(new int[]{-1,-1,0});
        // 같은 줄에 없고 그 전줄에 있다면
        int lcsLength = 0;

        for(int i=0;i<s1.length();++i){
            for(int j=0;j<s2.length();++j){
                if(dp[i][j]>=1){
                    int max = 0;
                    for(int k=0;k<l.size();++k){
                        int[] popped = l.get(k);
                        if(max<popped[2]){
                            max=popped[2];
                        }
                        if(i>popped[0] && j>popped[1] && popped[2]==max){
                            if(lcsLength<max+1){
                                lcsLength=max+1;
                            }
                            l.add(new int[]{i,j,max+1});
                            dp[i][j]=max+1;

                        }
                    }
                }
            }
        }
        System.out.println(lcsLength);
    }
    // 최대 1000자면 O(N^3) 으로 해결해야함. 그럼 dp 3차원?
    // check 를 하는 방법 중 시간이 적게 걸리는 방법을 찾아야 한다.
    // 일단 check 는 패스
}
