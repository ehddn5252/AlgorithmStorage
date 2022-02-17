package com.ssafy.day5SolvingProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16926_2 {
    static int N,M;
    static String[][] arr;
    static String[][] tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Rn = Integer.parseInt(st.nextToken());

        arr = new String[N][M];

        for (int i=0;i<N;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j=0;j<M;j++) {
                arr[i][j] = st2.nextToken();
            }
        }

        for (int k=0;k<Rn;k++) {
            rotate((int)Math.ceil(Math.min(N/2,M/2)));
        }

        //출력
        for (int x=0;x<N;x++) {
            for (int y=0;y<M;y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.print("\n");
        }
    }

    //돌리는 메서드
    static void rotate(int totalR) {
        tmp = new String[N][M];
        for (int R = 0; R < totalR; R++) {
            for (int i=R;i<N-R-1;i++) {
                tmp[i+1][R] = arr[i][R];
            }
            for (int i=R;i<M-R-1;i++) {
                tmp[N-R-1][i+1] = arr[N-R-1][i];
            }
            for (int i=R+1;i<N-R;i++) {
                tmp[i-1][M-R-1] = arr[i][M-R-1];
            }
            for (int i=R+1;i<M-R;i++) {
                tmp[R][i-1] = arr[R][i];
            }
        }
        arr = tmp;
    }
}