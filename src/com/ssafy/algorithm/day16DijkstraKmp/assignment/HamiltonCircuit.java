package com.ssafy.algorithm.day16Dijkstra.assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamiltonCircuit {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] visit;
    static int[] nums;
    static int[] nums_sample;
    static int globalSum = Integer.MAX_VALUE;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().strip());
        matrix = new int[N][N];
        nums_sample = new int[N - 1];
        nums = new int[N - 1];
        visit = new boolean[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            nums_sample[i] = i + 1;
        }

        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        permu(0, 0);
        System.out.println(globalSum);
    }

    static void permu(int cnt, int sum) {
        if (globalSum < sum) return;
        if (cnt == N - 1) {
            if(matrix[nums[N-2]][0]==0)return;
            sum+=matrix[nums[N-2]][0];
            if(globalSum>sum){
                globalSum=sum;
            }
//            System.out.println(Arrays.toString(nums));
//            System.out.println(globalSum);
        }

        for (int i = 0; i < N - 1; ++i) {
            if (visit[i]) continue;
            nums[cnt] = nums_sample[i];
            if (cnt == 0 ){
                if(matrix[0][nums[cnt]]==0)continue;
                visit[i] = true;
                permu(cnt + 1, sum + matrix[0][nums[cnt]]);
            }
            else{
                if(matrix[nums[cnt-1]][nums[cnt]]==0)continue;
                visit[i] = true;
                permu(cnt + 1, sum + matrix[nums[cnt-1]][nums[cnt]]);
            }
            visit[i] = false;
        }
    }
}
