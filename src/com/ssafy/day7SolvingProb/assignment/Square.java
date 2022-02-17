package com.ssafy.day7SolvingProb.assignment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square {
    public static int N;
    public static int testCaseNum;
    public static int maxCount=0;
    public static int currentCount=1;
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int tmp=99999;
    public static int[][] _array;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCaseNum = Integer.parseInt(br.readLine());
        for(int testCaseIndex = 0; testCaseIndex <testCaseNum; ++testCaseIndex){
            N = Integer.parseInt(br.readLine());
            _array = new int[N][N];
            for(int rowIndex=0;rowIndex<N;++rowIndex){
                st = new StringTokenizer(br.readLine());
                for(int colIndex=0;colIndex<N;++colIndex){
                    _array[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write("#"+(testCaseIndex+1)+" ");
            mainLogic();
            bw.write(tmp+" "+maxCount+"\n");
            maxCount=0;
        }
        bw.flush();
        bw.close();
    }

    public static void mainLogic(){
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                currentCount=1;
                find(i,j,_array[i][j],1);
                if(currentCount>=maxCount){
                    if(currentCount==maxCount){
                        if (_array[i][j]<tmp){
                            tmp = _array[i][j];
                        }
                    }
                    else{
                        tmp = _array[i][j];
                    }
                    maxCount = currentCount;
                }
            }
        }
    }

    public static void find(int nowRowIndex, int nowColindex, int nowNum, int count){
        if(nowNum==N*N) return;
        for(int i=0;i<4;++i){
            // 주변 수 확인
            int aroundRow = nowRowIndex+dy[i];
            int aroundCol = nowColindex+dx[i];

            if (aroundRow>=0 && aroundRow<N && aroundCol>=0 && aroundCol<N){
                if(_array[aroundRow][aroundCol]==nowNum+1){
                    // 다음수 찾으면 다음수 저장
                    if(currentCount<count+1){
                        currentCount=count+1;
                    }
                    // 다음수 다시 확인
                    find(aroundRow,aroundCol,nowNum+1,count+1);
                    break;
                }
            }
        }
    }
}
