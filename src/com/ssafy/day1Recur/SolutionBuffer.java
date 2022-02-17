/*
 * 문제명: 1289. 원재의 메모리 복구하기
 * 작성일자: 2022.02.03
 * 작성자: 김동우
 * 풀이 방법: 맨 처음 firstNum을 1로 설정하여 찾고
 * 그 다음부터 firstNum이 1이면 0일때 ret+1, firstNum이 0이면 1일때 ret+1로 해서 return 했습니다.
 *
 */

package com.ssafy.day1Recur;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolutionBuffer {
    public static void main(String[] args) throws Exception{
        //버퍼를 통해서 입력값을 받아올 버퍼리더 인스턴스 선언.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // 버퍼리더로 테스트 케이스 값 가져오기
        int testCaseNum = Integer.parseInt(in.readLine());

        for(int testCaseIndex=1;testCaseIndex<testCaseNum+1;++testCaseIndex){
            String str = in.readLine();
            Solution.printAnswer(testCaseIndex, Solution.findOne(str));
        }
    }

    public static int findOne(String str){
        int ret = 0;
        char firstNum='1';
        for(int i=0;i<str.length();++i){
            if (str.charAt(i)==firstNum){
                ret+=1;
                if (firstNum=='1'){
                    firstNum='0';
                }
                else{
                    firstNum='1';
                }
            }
        }
        return ret;
    }
    public static void printAnswer(int testCase,int findNum){
        System.out.println("#"+testCase+" "+findNum);
    }
}
