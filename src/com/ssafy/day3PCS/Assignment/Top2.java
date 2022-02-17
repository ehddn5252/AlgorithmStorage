package com.ssafy.day3PCS.Assignment;
/*
내용:
만약 오른쪽에 있는 타워가 왼쪽에 있는 타워의 높이보다 작거나 같으면 오른쪽 타워에 왼쪽 타워 index를 바로 대입한다.
아니라면 stack 다 뒤져보고 왼쪽에 있는 타워 중에 자신보다 큰 애를 찾는데, 없으면 0을 할당해준다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Top2 {
    static int N;
    static int[] receiveInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] tops = strArray2intArray(br.readLine().split(" "));
        receiveInfo = new int[N];
        printAll(mainLogic(tops));
    }

    static int[] mainLogic(int[] tops) {
        Stack<int[]> s = new Stack<>();
        for(int i=0; i < N ; ++i){
            while (s.isEmpty()==false){
                if(s.peek()[0]>=tops[i]) {
                    break;
                }
                else{
                    s.pop();
                }
            }
            if(s.isEmpty()){
                receiveInfo[i]=0;
            }
            else{
                receiveInfo[i]=s.peek()[1];
            }
            s.push(new int[] {tops[i],i+1});
        }
        return receiveInfo;
    }


    static int[] strArray2intArray(String[] str) {
        int[] intArray = new int[str.length];
        for(int i = 0; i < str.length; ++i) {
            intArray[i] = Integer.parseInt(str[i]);
        }
        return intArray;
    }

    static void printAll(int[] result){
        for(int i =0;i<result.length;++i){
            if (i==result.length-1){
                System.out.print(result[i]);
            }
            else{
                System.out.print(result[i]+" ");
            }
        }
    }

}
