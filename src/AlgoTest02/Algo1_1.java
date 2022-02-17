package AlgoTest02;

import java.io.IOException;
import java.util.Scanner;

// 종이컵을 여러개 놓고 간식이 있는 종이컵 자리를 바꾼다.
// 첫줄엔 testCaseNum 두번쨰 줄에는 종이컵의 수와 간식이 들어있는 종이컵이 왼쪽에서 몇번째인지 그리고 컵의 위치를 맞바꾸는 횟수 
// 바꾼 두 컵의 위치 A,B가 공백으로 구분

public class Algo1_1 {
    static int paperCupNum, answerLocation, changeNum;
    static int first, second;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // testcase수
        // test Case 만큼 돈다.
        // 컵의 수
        paperCupNum = sc.nextInt();
        //정답 위치
        answerLocation = sc.nextInt();
        // 변경 수
        changeNum = sc.nextInt();
        // 위치 변경 야바위 시작.
        for (int j = 0; j < changeNum; ++j) {
            // 변경 대상이 되는 컵의 위치
            first = sc.nextInt();
            second = sc.nextInt();
            // 만약 첫번째에 컵의 위치가 정답 위치라면 두번째로 정답 위치를 변경한다.
            if (first == answerLocation) {
                answerLocation = second;
            }
            // 만약 두번째의 컵의 위치가 정답 위치라면 첫번째로 정답 위치를 변경한다.
            else if (second == answerLocation) {
                answerLocation = first;
            }
        }
        // 정답
        System.out.println(answerLocation);
    }
}
