package com.ssafy.algorithm.bj;

public class MakeTestCase {

    static int CaseNum;
    static int randomValue;
    public static void main(String[] args) {
        int date = (int)(Math.random()*20);
        int max=10;
        while(date<=max && max>0){
            max = (int)(Math.random()*20);
        }
        System.out.println(date+" "+max);
        for(int i=0;i<date;++i){
            randomValue = (int)(Math.random()*500);
            System.out.println(randomValue);
        }
    }
}
