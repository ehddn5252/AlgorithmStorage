package com.ssafy.algorithm.newDay10ComThink2.others;

import java.io.*;
import java.util.*;

public class BJ1708_3 {
    static Vector origin;
    static class Vector{
        long x,y;
        Vector(long x,long y){
            this.x=x;
            this.y=y;
        }

        double abs() {
            return Math.sqrt(this.x*this.x+this.y*this.y);
        }

        double cross(Vector o) {
            return (this.x*o.y-this.y*o.x);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long maxY=-40001;
        long maxX=0;
        Vector[] arr=new Vector[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x=Long.parseLong(st.nextToken());
            long y=Long.parseLong(st.nextToken());
            arr[i]=new Vector(x,y);
            // y값이 제일 큰 것을 origin으로 잡는다.
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
        // origin 점과 벡터연산한 점을 기준으로 두 점 외적시 0보다 작으면 둔각, 0이면 직각 0보다 크면
        // 외적은 세 점이 반 시계 방향이면 0보다 크고 시계방향이면 0보다 작다.

        Arrays.sort(arr, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                //(o1.y==o2.y?o1.x<o2.x:o1.y<o2.y)==true

                if(o1.y==o2.y){
                    if((o1.x<o2.x)) return -1;
                    else return 1;
                }
                else{
                    if(o1.y<o2.y) return -1;
                    else return 1;
                }
            }
        });

        Arrays.sort(arr, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                // origin 은 y 최댓 값, 그 다음 x 최댓 값으로 설정한다.
                /*
                y 최댓값 기준으로
                 */
                Vector aV=new Vector(o1.x-origin.x,o1.y-origin.y);
                Vector bV=new Vector(o2.x-origin.x,o2.y-origin.y);
                if (aV.cross(bV)<0||aV.abs()==0) return -1;
                if (bV.abs()==0) return 1;
                if (aV.cross(bV)==0) return 0;
                else return 1;
            }
        });

//        for(Vector v:arr) {
//            System.out.println(v.x+" "+v.y);
//        }

        Stack<Vector> s = new Stack<>();
        s.add(arr[0]);
        s.add(arr[1]);

        for (int i = 2; i <= N; i++) {
//         System.out.println(i);
            while(true) {
                Vector p2 = s.elementAt(s.size()-1);
                Vector p1 = s.elementAt(s.size()-2);
                Vector prevV = new Vector(p2.x-p1.x,p2.y-p1.y);
                Vector nowV = new Vector(arr[i%N].x-p1.x,arr[i%N].y-p1.y);
//            if (prevV.cross(nowV)>0)System.out.println("랄라");
                if(prevV.cross(nowV)<0)  {
                    s.add(arr[i%N]);
                    break;
                }
                else if (prevV.cross(nowV)==0) {
                    if(nowV.abs()>prevV.abs()) {
                        s.pop();
                        s.add(arr[i%N]);
                        break;
                    } else break;
                } else s.pop();
            }
        }
//
//      System.out.println();
//      for(Vector v:s) {
//         System.out.println(v.x+" "+v.y);
//      }

        System.out.print(s.size()-1);
    }
}