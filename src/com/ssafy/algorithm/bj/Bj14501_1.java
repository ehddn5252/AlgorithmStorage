package com.ssafy.algorithm.bj;
/*
// 퇴사
21:06
N+1일에 퇴사하기 위해서
N일 동안 최대한 많은 상담
비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아 놓았다. 
각각의 상담은 상담을 완료하는 데 걸리는 시간 Ti와 상담을 할 때 받을 수 있는 금액 Pi로 이루어져 있다. 
상담을 했을 때 받을 수 있는 금액을 고르시오.
남은 날짜는 최대 15일이고 하나의 상담은 1 ~ 5일 걸린다. 보수는 1 ~ 1000이다.

해결방법:
모든 경우를 다 구한다음
날짜가 겹치는 경우 제거하기.

부분집합 시간복잡도 : N * 2^ N
15 * 2^ 15 = 50만.


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bj14501_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Days> l = new ArrayList<>();
    static boolean[] visit, dayVisit;
    static int maxValue=0;
    static int count=0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        dayVisit = new boolean[N];

        for(int i=0;i<N;++i){
            String[] s =br.readLine().split(" ");
            l.add(new Days(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        mainLogic(0,0);
        System.out.println(maxValue);
        System.out.println(count);
    }
    /*
    모든 경우의 수를 확인한다.

     */
    static void mainLogic(int cnt,int money){

        if(cnt==N){
            if(maxValue<money){
                maxValue=money;
            }
            return;
        }

        for(int i=cnt;i<N;++i){
            if (visit[i]) continue;
            count+=1;
            Days d = l.get(i);
            if(checkReservation(i,d.day)){
                visit[i]=true;
                mainLogic(cnt+1,money+d.pay);
            };
            if(visit[i]) {
                visit[i] = false;
                resetCheckReservation(i, d.day);
            }
            mainLogic(cnt+1,money);
        }
    }

    static boolean checkReservation(int start,int day){
        int checkDays = start+day;
        if(checkDays>N)return false;
        for(int i=start;i<checkDays;++i){
            count+=1;
            if(dayVisit[i]) return false;
        }

        for(int i=start;i<checkDays;++i){
            count+=1;
            dayVisit[i]=true;
        }
        return true;
    }

    static void resetCheckReservation(int start,int day){
        int checkDays = start+day;
        if(checkDays>N) return;
        for(int i=start;i<checkDays;++i) {
            count+=1;
            dayVisit[i]=false;
        }
    }

    static class Days{
        int day;
        int pay;

        public Days(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
}
