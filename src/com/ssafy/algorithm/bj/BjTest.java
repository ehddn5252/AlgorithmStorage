package com.ssafy.algorithm.bj;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Test
public class BjTest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Test
    public static void find(){
        System.out.println("hi");
    }

    @Test
    public static void main(String[] args) throws IOException {
        br.readLine();
        find();
    }
}
