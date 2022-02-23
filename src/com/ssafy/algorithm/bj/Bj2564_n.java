package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2564_n {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int width,height;
    static int myLocation, myDistance;
    static int[][] stores;
    static int ans;
    public static void main(String[] args) throws IOException {
        // 입력: 가로 세로\n 상점의 개수\n 북 남 서 동
        // 남쪽이나 북쪽에 위치한 경우 블록의 왼쪽경계로부터 거리.
        // 서쪽이나 동쪽인 경우 블록의 위쪽 경계로 부터의 거리이다.
        // 각각의 조건 분기에 따라서 계산식을 달리 해주면 된다.
        String[] s=br.readLine().split(" ");
        width = Integer.parseInt(s[0]);
        height = Integer.parseInt(s[1]);
        int times = Integer.parseInt(br.readLine());
        stores = new int[times][2];
        for(int i = 0; i<times;++i){
            s=br.readLine().split(" ");
            int[] store = new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])};
            stores[i]=store;
        }
        s=br.readLine().split(" ");
        myLocation = Integer.parseInt(s[0]);
        myDistance = Integer.parseInt(s[1]);

        for(int i=0;i<stores.length;++i){
            int[] store= stores[i];
            mainLogic(store);
        }
        System.out.println(ans);
    }

    public enum Location{
        X,NORTH,EAST,WEST,SOUTH;
    }

    // 각각의 분기로 안하고 반대편일때 왼쪽 + 왼쪽 사이의 위치 오른쪽 + 오른쪽 사이의 위치를 정해줘도 된다.
    // 1. 왼쪽과의 거리는 그냥 x이고 오른쪽과의 거리는 width - x 이다.
    // 2. 위 와의 거리는 그냥 y이고 아래와의 거리는 height - y 이다.
    static void mainLogic(int[] store){
        // 내 위치가 1일때
        int storeLocation = store[0];
        int storeDistance = store[1];
        
        // 1이 북쪽 2가 남쪽 3이 서쪽 4가 동쪽
        if(myLocation ==1){
            check1(storeLocation,storeDistance);
        }
        else if(myLocation ==2){
            check2(storeLocation,storeDistance);
        }
        else if(myLocation ==3){
            check3(storeLocation,storeDistance);
        }
        else if(myLocation ==4){
            check4(storeLocation,storeDistance);
        }
    }
    // 1이 북쪽 2가 남쪽 3이 서쪽 4가 동쪽
    static void check1(int location, int storeDistance){
        if(location==1){
            ans+= Math.abs(myDistance-storeDistance);
        }
        else if(location==2){
            ans+= Math.min(height+myDistance+storeDistance,height+2*width-myDistance-storeDistance);
        }
        else if(location==3){
            ans+= myDistance+storeDistance;
        }
        else if(location==4){
            ans+= width-myDistance+height-storeDistance;
        }
    }

    // 1이 북쪽 2가 남쪽 3이 서쪽 4가 동쪽
    static void check2(int location, int storeDistance){
        if(location==1){
            ans+= Math.min(height+myDistance+storeDistance,height+2*width-myDistance-storeDistance);
        }
        else if(location==2){
            ans+= Math.abs(myDistance-storeDistance);
        }
        else if(location==3){
            ans+= myDistance + height-storeDistance;
        }
        else if(location==4){
            ans+= width-myDistance+height-storeDistance;
        }
    }

    // 1이 북쪽, 2가 남쪽, 3이 서쪽, 4가 동쪽
    static void check3(int location, int storeDistance){
        if(location==1){
            ans+= myDistance+storeDistance;
        }
        else if(location==2){
            ans+=storeDistance+height-myDistance;
        }
        else if(location==3){
            ans+= Math.abs(myDistance-storeDistance);
        }
        else if(location==4){
            ans+= Math.min(width+storeDistance+myDistance,width+2*height-storeDistance-myDistance);
        }
    }

    // 1이 북쪽, 2가 남쪽, 3이 서쪽, 4가 동쪽
    static void check4(int location, int storeDistance){
        if(location==1){
            ans+= width-storeDistance+myDistance;
        }
        else if(location==2){
            ans+= height - myDistance + width - storeDistance;
        }
        else if(location==3){
            ans+= Math.min(width+storeDistance+myDistance,width+2*height-storeDistance-myDistance);
        }
        else if(location==4){
            ans+= Math.abs(myDistance-storeDistance);
        }
    }
}
