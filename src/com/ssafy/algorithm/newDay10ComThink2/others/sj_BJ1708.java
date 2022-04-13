package com.ssafy.algorithm.newDay10ComThink2.others;


import java.io.*;
import java.util.*;

public class  sj_BJ1708{
    static testC origin;
    static class testC {
        long x,y;
        testC(long x, long y){
            this.x=x;
            this.y=y;
        }

        double abs() {
            return Math.sqrt(this.x*this.x+this.y*this.y);
        }

        double cross(testC o) {
            return (this.x*o.y-this.y*o.x);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long maxY=-40001;
        long maxX=0;
        testC[] arr=new testC[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x=Long.parseLong(st.nextToken());
            long y=Long.parseLong(st.nextToken());
            arr[i]=new testC(x,y);
            if(y>maxY) {
                origin=arr[i];
                maxY=y;
                maxX=x;
            } else if (y==maxY) {
                if (x>maxX) {
                    maxX=x;
                    origin=arr[i];
                }
            }
        }
        Arrays.sort(arr, new Comparator<testC>() {
            @Override
            public int compare(testC o1, testC o2) {
                testC aV=new testC(o1.x-origin.x,o1.y-origin.y);
                testC bV=new testC(o2.x-origin.x,o2.y-origin.y);
                if (aV.cross(bV)<0||aV.abs()==0) return -1;
                else return 1;
            }
        });

        Stack<testC> s = new Stack<>();
        s.add(arr[0]);
        s.add(arr[1]);

        for (int i = 2; i <= N; i++) {
            while(true) {
                testC p2 = s.pop();
                testC p1 = s.pop();
                testC prevV = new testC(p2.x-p1.x,p2.y-p1.y);
                testC nowV = new testC(arr[i%N].x-p1.x,arr[i%N].y-p1.y);
                s.add(p1);
//            if (prevV.cross(nowV)>0)System.out.println("랄라");
                if(prevV.cross(nowV)<0)  {
                    s.add(p2);
                    s.add(arr[i%N]);
                    break;
                }
                else if (prevV.cross(nowV)==0) {
                    if(nowV.abs()>prevV.abs()) {
                        s.add(arr[i%N]);
                        break;
                    } else {
                        s.add(p2);
                        break;
                    }
                }
            }
        }

        System.out.println();
        for(testC v:s) {
            System.out.println(v.x+" "+v.y);
        }
        System.out.print(s.size()-1);
    }
}