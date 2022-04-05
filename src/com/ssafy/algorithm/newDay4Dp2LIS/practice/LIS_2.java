package com.ssafy.algorithm.newDay4Dp2LIS.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LIS_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<numDp> l = new ArrayList<numDp>();
            for(int i=0;i<N;++i){
                l.add(new numDp(Integer.parseInt(st.nextToken()),1));
            }
            System.out.println("#"+testCaseIndex+" "+mainLogic(l));
        }
    }

    static long mainLogic(ArrayList<numDp> nums) {
        long answer=0;
        // dp 배열에 있는 수를 전체 살펴본다.
        for (int i = 1; i < nums.size(); ++i) {
            numDp gettedI =  nums.get(i);
            int maxLisSize=0;
            for(int j=0;j<i;++j){
                numDp gettedJ =  nums.get(j);
                if(gettedI.num>=gettedJ.num && gettedJ.lisSize>maxLisSize){
                    maxLisSize = gettedJ.lisSize;
                }
            }
//            System.out.println("i: "+i+" gettedI.num:"+gettedI.num+ "lisSize:"+maxLisSize);
            if(answer<maxLisSize+1){
                answer=maxLisSize+1;
            }
                nums.set(i,new numDp(gettedI.num, maxLisSize+1));
        }
        return answer;
    }

    static class numDp{
        long num;
        int lisSize;

        public numDp(long num, int lisSize) {
            this.num = num;
            this.lisSize = lisSize;
        }
    }
}
