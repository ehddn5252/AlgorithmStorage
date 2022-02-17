package AlgoTest02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algo2_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int N, teamMin, personMin;
    static int answerNum = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] passPerson = new int[15000000];

    public static void main(String[] args) throws IOException {
        // 신청 그룹 수
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        // 팀 최소
        teamMin = Integer.parseInt(s[1]);
        // 개인 최소
        personMin = Integer.parseInt(s[2]);
        // 통과한 사람들의 점수를 ArrayList 로 만든다.
        int currentNum=0;
        for(int i=0;i<N;++i){
            String[] sArray = br.readLine().split(" ");
            // 만약 개인의 최소를 넘기고
            int a = Integer.parseInt(sArray[0]);
            int b = Integer.parseInt(sArray[1]);
            int c = Integer.parseInt(sArray[2]);

            if(a>=personMin && b>=personMin && c>= personMin){
                // 팀 최소를 넘기면 list 에 추가합니다.
                if(a+b+c>=teamMin){
                    answerNum+=1;
                    passPerson[currentNum]=a;
                    currentNum+=1;
                    passPerson[currentNum]=b;
                    currentNum+=1;
                    passPerson[currentNum]=c;
                    currentNum+=1;
                }
            }
        }
        // 정답 개수 print
        bw.write(Integer.toString(answerNum)+"\n");
        // pass한 사람 점수들을 print합니다.

        for(int i = 0; i< currentNum; ++i){
            if (i!= currentNum-1){
                bw.write(passPerson[i]+" ");
            }
            else{
                bw.write(Integer.toString(passPerson[i]));
            }
        }
        bw.flush();
        bw.close();
    }
}
