package com.ssafy.algorithm.newDay10ComThink2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static List<String> cardNumList = new ArrayList<>();
    static List<String> cardPatternList = new ArrayList<>();
    static List<Card> cardList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int testCaseNum = Integer.parseInt(br.readLine());
        cardNumList = Arrays.asList("A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A", "1", "2", "3");
        cardPatternList = Arrays.asList("S", "D", "H", "C");
        cardList.add(new Card("", "A", 0));
        for (int i = 2; i <= 9; ++i) {
            cardList.add(new Card("", Integer.toString(i), 0));
        }
        cardList.add(new Card("", "T", 0));
        cardList.add(new Card("", "J", 0));
        cardList.add(new Card("", "Q", 0));
        cardList.add(new Card("", "K", 0));

        /*
        S D H C
        A 2 3 4 5 6 7 8 9 T J Q J K
        1.Straight Flush : 모두 동일한 슈트에 랭크가 모두 연속적이다.
        */
        for (int testCaseIndex = 1; testCaseIndex <= testCaseNum; ++testCaseIndex) {
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < s.length; ++i) {
                cardList.add(new Card(s[0], s[1], 1));
            }
            System.out.print("#" + " " + testCaseIndex + " ");

            if (isStraightFlush(s)) System.out.println("Straight Flush");
            else if (isFourOfAKind(s)) System.out.println("Four of a Kind");
            else if (isFullHouse(s)) System.out.println("Full House");
            else if (isFlush(s)) System.out.println("Flush");
            else if (isStraight(s)) System.out.println("Straight");
            else if (isThreeOfAKind(s)) System.out.println("Three of a kind");
            else if (isTwoPair(s)) System.out.println("Two pair");
            else if (isOnePair(s)) System.out.println("One pair");
            else System.out.println("High card");
        }
    }

    /*
    하나의 종류

     */
    private static boolean isStraightFlush(String[] s) {
        boolean ret = false;

        // 여기서 같은 무늬인지 확인
        char tmp = s[0].charAt(0);
        for (int i = 0; i < s.length; ++i) {
            if (s[i].charAt(0) != tmp) {
                ret = false;
                return false;
            }
        }
        // 10 j q k a // j q k a 2 // q k a 2 3 //k a 2 3 4 // a 2 3 4 5
        for (int i = 0; i < cardList.size(); ++i) {
            if (s[i].charAt(1) != tmp) {
            }
        }
        return ret;
    }

    private static boolean isFourOfAKind(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isFullHouse(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isFlush(String[] s) {
        char tmp = s[0].charAt(0);
        for (int i = 0; i < s.length; ++i) {
            if (s[i].charAt(0) != tmp) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraight(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isThreeOfAKind(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isTwoPair(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isOnePair(String[] s) {
        boolean ret = false;

        return ret;
    }

    private static boolean isHighCard(String[] s) {
        boolean ret = false;

        return ret;
    }

    static class Card {
        String num;
        String pattern;
        int count;

        public Card(String num, String pattern, int count) {
            this.num = num;
            this.pattern = pattern;
            this.count = count;
        }
    }
}
