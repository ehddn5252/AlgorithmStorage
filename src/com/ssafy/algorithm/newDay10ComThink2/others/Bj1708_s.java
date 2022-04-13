package com.ssafy.algorithm.newDay10ComThink2.others;

import java.io.*;
import java.util.*;


public class Bj1708_s {
    static Vector origin;

    static class Vector {
        long x, y;

        Vector(long x, long y) {
            this.x = x;
            this.y = y;
        }

        double abs() {
            return Math.sqrt(this.x * this.x + this.y * this.y);
        }

        double cross(Vector o) {
            return (this.x * o.y - this.y * o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long maxY = -40001;
        long maxX = 0;
        Vector[] arr = new Vector[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i] = new Vector(x, y);
            if (y > maxY) {
                origin = arr[i];
                maxY = y;
                maxX = x;
            } else if (y == maxY) {
                if (x > maxX) {
                    maxX = x;
                    origin = arr[i];
                }
            }
        }

        Arrays.sort(arr, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                Vector aV = new Vector(o1.x - origin.x, o1.y - origin.y);
                Vector bV = new Vector(o2.x - origin.x, o2.y - origin.y);
                if (aV.cross(bV) < 0 || aV.abs() == 0) return -1;
                if (bV.abs() == 0) return 1;
                if (aV.cross(bV) == 0) {
                    if (aV.abs() < bV.abs()) return 1;
                    else return -1;
                } else return 1;
            }
        });

        Stack<Vector> s = new Stack<>();
        s.add(arr[0]);
        s.add(arr[1]);

        for (int i = 2; i <= N; i++) {
            while (true) {
                Vector p2 = s.elementAt(s.size() - 1);
                Vector p1 = s.elementAt(s.size() - 2);
                Vector prevV = new Vector(p2.x - p1.x, p2.y - p1.y);
                Vector nowV = new Vector(arr[i % N].x - p1.x, arr[i % N].y - p1.y);
                if (prevV.cross(nowV) < 0) {
                    s.add(arr[i % N]);
                    break;
                } else if (prevV.cross(nowV) == 0) {
                    if (nowV.abs() > prevV.abs()) {
                        s.pop();
                        s.add(arr[i % N]);
                        break;
                    } else break;
                } else s.pop();
            }
        }

        System.out.print(s.size() - 1);
    }
}