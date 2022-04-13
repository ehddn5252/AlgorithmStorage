package com.ssafy.algorithm.newDay10ComThink2.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


public class BJ1708_4 {
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
        Arrays.sort(arr, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                if(o1.y!=o2.y) {
                    return (int)(o1.y-o2.y);
                }
                else{
                    return (int)(o2.x-o1.x);
                }
            }
        });

        for(Vector v:arr) {
            System.out.println(v.x+" "+v.y);
        }

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