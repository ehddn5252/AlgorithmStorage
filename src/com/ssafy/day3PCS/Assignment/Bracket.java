package com.ssafy.day3PCS.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Bracket {
    static final int TESTCASE_NUM = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int testCaseIndex = 1; testCaseIndex< TESTCASE_NUM+1; ++testCaseIndex){
            br.readLine();
            String str = br.readLine();
            System.out.println("#"+testCaseIndex+" "+ mainLogic(str));
        }
    }
    static int mainLogic(String str){
        int ans=1;
        Stack<Character> stackInstance = new Stack<Character>();
        for(int i =0; i<str.length();++i){
            // ( { [ < 를 넣고 ) } ] > 을 발견하면 제거하는 형식으로 한다.
            if(str.charAt(i)=='('){
                stackInstance.add(('('));
            }
            else if(str.charAt(i)=='{'){
                stackInstance.add(('{'));
            }
            else if(str.charAt(i)=='['){
                stackInstance.add(('['));
            }
            else if(str.charAt(i)=='<'){
                stackInstance.add(('<'));
            }

            if(str.charAt(i)==')'){
                if (stackInstance.isEmpty()){
                    return 0;
                }
                if(stackInstance.pop()!='('){
                    return 0;
                };
            }
            else if(str.charAt(i)=='}'){
                if (stackInstance.isEmpty()){
                    return 0;
                }
                if(stackInstance.pop()!='{'){
                    return 0;
                };
            }
            else if(str.charAt(i)==']'){
                if (stackInstance.isEmpty()){
                    return 0;
                }
                if(stackInstance.pop()!='['){
                    return 0;
                };
            }
            else if(str.charAt(i)=='>'){
                if (stackInstance.isEmpty()){
                    return 0;
                }
                if(stackInstance.pop()!='<'){
                    return 0;
                }
            }
        }
        return ans;
    }
}
