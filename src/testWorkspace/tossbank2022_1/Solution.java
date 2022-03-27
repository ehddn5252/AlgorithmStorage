package testWorkspace.tossbank2022_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static int N, answer;
    static int[] numsGlobal;
    static int count;

    public static void main(String[] args) {
        solution(new int[]{2, 3, 1});
    }

    static public int solution(int[] nums) {


        N = nums.length;
        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 2;
        }
        numsGlobal = new int[N];
        for (int i = 0; i < N; ++i) {
            numsGlobal[i] = nums[i];
        }
        Deque<Integer> q = new ArrayDeque<Integer>();
        BFS(0, q);
        return answer;
    }


    static void BFS(int cnt, Deque<Integer> dq) {
        System.out.println("cnt: " + cnt);
        if (cnt == 3) {
            System.out.println("afafa");
            if (checkZigzag(dq)) {
                answer += 1;
            }
            return;
        }

        for (int i = cnt; i < N; ++i) {
            count += 1;
            System.out.println("count: " + count);
            System.out.println(numsGlobal[i]);
            dq.offerFirst(numsGlobal[i]);
            BFS(cnt + 1, dq);
            dq.remove();
            dq.offerLast(numsGlobal[i]);
            BFS(cnt + 1, dq);
            dq.removeLast();
        }
    }

    static boolean checkZigzag(Deque<Integer> q) {
        int pollCount = 0;
        int popped=0;
        int popped2=0;
        if(q.size()>=2){
            popped = q.poll();
            popped2 = q.poll();
        }

        boolean isOddBigger = true;
        if (popped > popped2) {
            isOddBigger = false;
        }
        while (!q.isEmpty()) {
            int popped3 = q.pollFirst();
            pollCount += 1;
            if (pollCount % 2 == 1 && isOddBigger) {
                if (popped3 < popped2) {
                    return false;
                }
            }
            if (pollCount % 2 == 0 && !isOddBigger) {
                if (popped3 < popped2) {
                    return false;
                }
            }
            popped2 = popped3;
        }
        return true;
    }
}