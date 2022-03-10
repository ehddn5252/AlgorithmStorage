package com.ssafy.test.DevMatching2022;
/*
각 등급별 유효기간을 확인
*/

import java.util.ArrayList;

class Solution {
    static int[] monthList = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,0};
    static int money;
    static int[] grade= new int[]{0,0,0,0,0};
    static ArrayList<int[]> l= new ArrayList<int[]>(13);

    public static void main(String[] args) {
        String[] s ={"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
        String[] s1 = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        int[] ans = solution(s);
    }

    public static int[] solution(String[] purchase) {
        // 브론즈는 최근 30일간 1만원 이하,
        // 실버: 최근 30일간 1만~ 2만 구매
        // 골드: 최근 30일간 5만 미만
        // 플래: 최근 30일간 10만 미만
        // 다이아: 최근 30일간 10만 이상 구매
        // 12월 달력을 그냥 만든다. 구매를 하면 값을 적어 놓는다.

        int[] answer = {};
        for(int i=0;i<=13;++i){
            int[] tmp = new int[monthList[i]];
            l.add(tmp);
        }

        int month = 0, day = 0;

        for (int i = 0; i < purchase.length; ++i) {
            int count=30;
            String[] s = purchase[i].split(" ");
            money = Integer.parseInt(s[1]);
            String[] days = s[0].split("/");
            month = Integer.parseInt(days[1]);
            day = Integer.parseInt(days[2]);
            int[] tmp= l.get(month);
            int[] tmp2= l.get(month+1);
            boolean flag = false;
            while(count>0){
                if(day==tmp.length){
                    flag=true;
                    day=1;
                }
                if(!flag){
                    tmp[day] += money;
                    day+=1;
                    count--;
                }
                else{
                    if(month+1==13) break;
                    tmp2[day]+=money;
                    day+=1;
                    count--;
                }
            }
            l.set(month,tmp);
            l.set(month+1,tmp2);
        }

        for(int i=1;i<13;++i){
            int[] retMonth = l.get(i);

            for(int j=0;j<retMonth.length;++j){
                if(retMonth[j]<10000){
                    grade[0]+=1;
                }
                else if(retMonth[j]<20000){
                    grade[1]+=1;
                }
                else if(retMonth[j]<50000){
                    grade[2]+=1;
                }
                else if(retMonth[j]<100000){
                    grade[3]+=1;
                }
                else {
                    grade[4]+=1;
                }
            }
        }

        return grade;
    }

}