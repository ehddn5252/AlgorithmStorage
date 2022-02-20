package com.ssafy.algorithm.day12SolvingProb.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        Integer []i = {50,54,67,99,100,45};
        System.out.println(Arrays.toString(i));
        Arrays.sort(i);
        System.out.println(Arrays.toString(i));

        List<Integer> numList = Arrays.asList(i);
        Collections.sort(numList);
        Collections.reverse(numList);
    }
}
