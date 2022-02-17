package AlgoTest02;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Algo2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int N, teamMin, personMin;
    static int answerNum = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 신청 그룹 수
        String s = br.readLine();
        // 팀 최소
        teamMin = Integer.parseInt(br.readLine());
        // 개인 최소
        personMin = sc.nextInt();
        // 통과한 사람들의 점수를 ArrayList 로 만든다.
        List passPerson = new ArrayList<Integer>(1500000);
        int currentNum=0;
        for(int i=0;i<N;++i){
            // 학생 a,b,c 받음
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 만약 개인의 최소를 넘기고

            if(a>=personMin && b>=personMin && c>= personMin){
                // 팀 최소를 넘기면 linkedList에 추가합니다.
                if(a+b+c>=teamMin){
                    answerNum+=1;
                    passPerson.add(currentNum,a);
                    currentNum+=1;
                    passPerson.add(currentNum,b);
                    passPerson.add(currentNum,c);
                }
            }
        }
        // 정답 개수 print
        bw.write(Integer.toString(answerNum)+"\n");
        // pass한 사람 점수들을 print합니다.

        for(int i = 0; i< passPerson.size(); ++i){
            if (i!= passPerson.size()-1){
                bw.write(passPerson.get(i)+" ");
            }
            else{
                bw.write((String)passPerson.get(i));
            }
        }
        bw.flush();
        bw.close();
    }
}
