package com.ssafy.test.DevMatching2022;


import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int solution(int[][] grid) {
        int answer = 0;
        int[][] initGrid = {{1,1,2,2},{1,1,2,2},{2,2,1,1},{2,2,1,1}};

        answer = BFS(grid,initGrid);
        return answer;
    }

    int BFS(int[][] grid, int[][] initGrid){
        Queue<tmp> q = new LinkedList<tmp>();
        q.offer(new tmp(grid,0));
        while(true){
            tmp popped = q.poll();
            if(compare(popped.grid,initGrid)){
               return popped.ans;
            }
            tmp t = new tmp(move1(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move2(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move3(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move4(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move5(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move6(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move7(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move8(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move9(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move10(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move11(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move12(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move13(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move14(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move15(grid),popped.ans+1);
            q.offer(t);
            t = new tmp(move16(grid),popped.ans+1);
            q.offer(t);
        }

    }

    static class tmp{
        int[][] grid;
        int ans;

        public tmp(int[][] grid, int ans) {
            this.grid = grid;
            this.ans = ans;
        }
    }
    boolean compare(int[][] grid, int[][] initGrid){
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                if(grid[i][j]!=initGrid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }




    // 첫줄 좌로
    int[][] move1(int[][] grid){
        int tmp = grid[0][0];
        grid[0][0] = grid[1][0];
        grid[1][0] = grid[2][0];
        grid[2][0] = grid[3][0];
        grid[3][0] = tmp;
        return grid;
    }
    int[][] move2(int[][] grid){
        int tmp = grid[0][1];
        grid[0][1] = grid[1][1];
        grid[1][1] = grid[2][1];
        grid[2][1] = grid[3][1];
        grid[3][1] = tmp;
        return grid;
    }

    int[][] move3(int[][] grid){
        int tmp = grid[0][2];
        grid[0][2] = grid[1][2];
        grid[1][2] = grid[2][2];
        grid[2][2] = grid[3][2];
        grid[3][2] = tmp;
        return grid;
    }

    int[][] move4(int[][] grid){
        int tmp = grid[0][3];
        grid[0][3] = grid[1][3];
        grid[1][3] = grid[2][3];
        grid[2][3] = grid[3][3];
        grid[3][3] = tmp;
        return grid;
    }

    // 첫줄 좌로
    int[][] move5(int[][] grid){
        int tmp = grid[3][0];
        grid[3][0] = grid[2][0];
        grid[2][0] = grid[1][0];
        grid[1][0] = grid[0][0];
        grid[0][0] = tmp;
        return grid;

    }

    int[][] move6(int[][] grid){
        int tmp = grid[3][1];
        grid[3][1] = grid[2][1];
        grid[2][1] = grid[1][1];
        grid[1][1] = grid[0][1];
        grid[0][1] = tmp;
        return grid;

    }

    // 첫줄 좌로
    int[][] move7(int[][] grid){
        int tmp = grid[3][2];
        grid[3][2] = grid[2][2];
        grid[2][2] = grid[1][2];
        grid[1][2] = grid[0][2];
        grid[0][2] = tmp;
        return grid;

    }

    int[][] move8(int[][] grid){
        int tmp = grid[3][3];
        grid[3][3] = grid[2][3];
        grid[2][3] = grid[1][3];
        grid[1][3] = grid[0][3];
        grid[0][3] = tmp;
        return grid;

    }

    int[][] move9(int[][] grid){
        int tmp = grid[0][0];
        grid[0][0] = grid[0][1];
        grid[0][1] = grid[0][2];
        grid[0][2] = grid[0][3];
        grid[0][3] = tmp;
        return grid;
    }


    int[][] move10(int[][] grid){
        int tmp = grid[1][0];
        grid[1][0] = grid[1][1];
        grid[1][1] = grid[1][2];
        grid[1][2] = grid[1][3];
        grid[1][3] = tmp;
        return grid;
    }


    int[][] move11(int[][] grid){
        int tmp = grid[2][0];
        grid[2][0] = grid[2][1];
        grid[2][1] = grid[2][2];
        grid[2][2] = grid[2][3];
        grid[2][3] = tmp;
        return grid;
    }


    int[][] move12(int[][] grid){
        int tmp = grid[3][0];
        grid[3][0] = grid[3][1];
        grid[3][1] = grid[3][2];
        grid[3][2] = grid[3][3];
        grid[3][3] = tmp;
        return grid;
    }

    int[][] move13(int[][] grid){
        int tmp = grid[0][3];
        grid[0][3] = grid[0][2];
        grid[0][2] = grid[0][1];
        grid[0][1] = grid[0][0];
        grid[0][0] = tmp;
        return grid;
    }
    int[][] move14(int[][] grid){
        int tmp = grid[1][3];
        grid[1][3] = grid[1][2];
        grid[1][2] = grid[1][1];
        grid[1][1] = grid[1][0];
        grid[1][0] = tmp;
        return grid;
    }
    int[][] move15(int[][] grid){
        int tmp = grid[2][3];
        grid[2][3] = grid[2][2];
        grid[2][2] = grid[2][1];
        grid[2][1] = grid[2][0];
        grid[2][0] = tmp;

        return grid;
    }

    int[][] move16(int[][] grid){
        int tmp = grid[3][3];
        grid[3][3] = grid[3][2];
        grid[3][2] = grid[3][1];
        grid[3][1] = grid[3][0];
        grid[3][0] = tmp;
        return grid;
    }
    // 이동하는 경우의 수는 16가지이다. BFS로 16가지 경우의 수를 모두 queue에 집어넣고, 하나씩 꺼내서 결과 확인한다.
    // 만약에 같은 경우가 나오면 pass
}