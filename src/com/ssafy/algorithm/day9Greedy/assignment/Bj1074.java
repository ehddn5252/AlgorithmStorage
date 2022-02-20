package com.ssafy.algorithm.day9Greedy.assignment;
// 문제명: z

import java.io.*;

public class Bj1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer, r, c;

    public static void main(String[] args) throws IOException {
        String[] inputStringArray = br.readLine().split(" ");

        // input
        int N;
        N = Integer.parseInt(inputStringArray[0]);
        int powN = (int) Math.pow(2, N);
        r = Integer.parseInt(inputStringArray[1]);
        c = Integer.parseInt(inputStringArray[2]);

        //구현
        int size = powN * powN;
        mainLogic(0, 0, 0, size);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static void mainLogic(int row, int col, int value, int size) {
        if (size == 4) {
            if (r == row && c == col) answer = value;
            else if (r == row && c == col + 1) answer = value + 1;
            else if (r == row + 1 && c == col) answer = value + 2;
            else if (r == row + 1 && c == col + 1) answer = value + 3;
            return;
        }

        size /= 4;
        int addLocation = (int) Math.sqrt(size);

        if (r < addLocation + row && c < addLocation + col)
            mainLogic(row, col, value, size);
        else if (r < addLocation + row && c >= col + addLocation)
            mainLogic(row, col + addLocation, value + size, size);
        else if (r >= addLocation + row && c < col + addLocation)
            mainLogic(row + addLocation, col, value + 2 * size, size);
        else if (r >= addLocation + row && c >= addLocation + col)
            mainLogic(row + addLocation, col + addLocation, value + 3 * size, size);
    }
}