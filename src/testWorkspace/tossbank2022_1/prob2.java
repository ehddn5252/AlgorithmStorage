package testWorkspace.tossbank2022_1;

import java.util.*;

class prob2 {
    public int[] solution(int[][] contests, int k, int p) {
        int[] answer = new int[k];
        List<An> solveProbNumSorted= new ArrayList<An>(30000);
        int maxValue = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<contests.length;++i){
            int solveCount = 0;
            for(int j=0;j<contests[0].length;++j){
                if(contests[i][j]<=p){
                    solveCount+=1;
                }
            }
            solveProbNumSorted.add(new An(solveCount,i));
        }
        Collections.sort(solveProbNumSorted);
        for(int i=0;i<k;++i){
            answer[i]=solveProbNumSorted.get(i).index;
        }
        Arrays.sort(answer);
        return answer;
    }

    static class An implements Comparable<An>{
        int solveNum;
        int index;

        public An(int solveNum, int index) {
            this.solveNum = solveNum;
            this.index = index;
        }

        @Override
        public int compareTo(An o) {
            if(solveNum==o.solveNum){
                return index-o.index;
            }
            return o.solveNum-solveNum;
        }
    }

}