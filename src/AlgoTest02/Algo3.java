package AlgoTest02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Algo3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int secureMin = 99999;

    // 관리자의 패스워드는 0이상 N이하의 범위
    // 보안 척도는 이진법으로 표현한 두 패스워드의 서로 다른 자리의 개수
    // check했을 때
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s);
        for(int i=0;i<M;++i) {
            int beforePasword = Integer.parseInt(st.nextToken());
            checkMin(beforePasword);
        }
        System.out.println(secureMin);
    }

    static void checkMin(int password) {
        password = N ^ password;
        int sumValue = 0;
        List s = new LinkedList<Character>();
        // 2진수로만들어서 개수 확인하는 로직

        while(password > 0){
            s.add(password % 2);
            password=password / 2;
        }

        String newS = s.toString();
        //최소값이면 0
        for(int i=0;i<newS.length();++i){
            if(newS.charAt(i)=='1'){
                sumValue+=1;
            }
        }
        if (sumValue < secureMin) {
            secureMin = sumValue;
        }
    }

    // 바이너리로 만드는 함수입니다. 이는 역순으로 저장이 됩니다.
}
