package com.ssafy.algorithm.day6BfsDfs.assigment.assignment;

import java.io.*;
import java.util.StringTokenizer;

public class ArithmeticValidation {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final int TESTCASE_NUM = 10;
    static int N;
    /*
    계산은 왼쪽 서브트리의 결과와 오른쪽 서브 트리의 결과를 사용해서 해당 연산자를 적용
    사칙연산 + - * 와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이 식의 유효성을 검사하는 프로그램 작성
    계산이 가능하다면 1 계산이 불가능할 경우 0을 출력한다. 해당 정점에 대한 정보는 해당 정점의 알파벳, 해당 정점의 왼쪽 자식,
    오른쪽 자식의 정점 번호가 차례로 주어진다.
     */

    /*
    문제해결 방법:
    자식 노드가 있다면 맨 앞에 * - / 가 있고 뒤에 두 개의 숫자가 와야 한다
    자식 노드가 없다면 숫자가 와야 한다. 이게 아니라면 0
    맨 처음에
     */
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testcaseIndex = 1; testcaseIndex < TESTCASE_NUM + 1; ++testcaseIndex) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int ret = mainLogic();
            printTestCaseNum(testcaseIndex);
            System.out.println(ret);
        }
    }

    static int mainLogic() throws IOException {
        int ret = 1;
        for (int i = 0; i < N; ++i) {
            String[] stringArray = br.readLine().split(" ");
            if (stringArray.length == 4) {
                if (!stringArray[1].equals("+")  && !stringArray[1].equals("-") && !stringArray[1].equals("*") && !stringArray[1].equals("/")){
                    //System.out.println("case1: "+i);
                    //printAll(stringArray);
                    ret=0;
                }

                if (stringArray[2].equals("+") || stringArray[2].equals("-") || stringArray[2].equals("*") || stringArray[2].equals("/")){
                    //System.out.println("case2: "+i);
                    //printAll(stringArray);
                    ret=0;
                }

                if (stringArray[3].equals("+") || stringArray[3].equals("-") || stringArray[3].equals("*") || stringArray[3].equals("/")){
                    //System.out.println("case3: "+i);
                    //printAll(stringArray);
                    ret=0;
                }

            } else if (stringArray.length == 2) {
                if (stringArray[1].equals("+") || stringArray[1].equals("-") || stringArray[1].equals("*") || stringArray[1].equals("/")) {
                    //System.out.println("case4: "+i);
                    //printAll(stringArray);
                    ret=0;
                }
            }
        }
        return ret;
    }

    static void printAll(String[] stringArray){
        for(String i: stringArray){
            System.out.print(i+" ");
        }
        System.out.println();
    }


    static int[] str2intArray(String str) {
        String[] strList = str.split(" ");
        int[] intArray = new int[strList.length];
        for (int i = 0; i < strList.length; ++i) {
            intArray[i] = Integer.parseInt(strList[i]);
        }
        return intArray;
    }

    static void printTestCaseNum(int testCaseIndex) {
        System.out.print("#" + testCaseIndex + " ");
    }
}
