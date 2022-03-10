package com.ssafy.test.DevMatching2022;
/*
각 등급별 유효기간을 확인
*/

import java.util.ArrayList;

class Solution2 {
    static int[][] map;
    public int solution(int h, int w, int n, String[] board) {
        int answer = 0;
        map = new int[h][w];
        for(int i=0;i<h;++i){
            for(int j=0;j<w;++j){
                map[i][j] = board[i].charAt(j)-'0';
            }
        }

        //3개를 알아봐야 한다.

        for(int i=0;i<h;++i){
            for(int j=0;j<w;++j){
                answer+=find(i,j,n);
            }
        }
        return answer;
    }

    private int find(int i, int j, int n) {
        int ans=0;
        int counti=0;
        int countj=0;
        int countk=0;
        int countk2=0;


        for(int k=0;k<n;++k){
            if(i+k>=map.length) break;
            if(map[i+k][j]==1){
                counti+=1;
            }
        }
        // 세로
        if(counti==n){
            if((i+n)==map.length || (i+n<map.length && map[i+n][j]==0)){
                ans+=1;
                if(i-1>=0){
                    if(map[i-1][j]==1){
                        ans-=1;
                    }
                }
            }
        }

        // 가로
        for(int k=0;k<n;++k){
            if(j+k>=map[0].length) break;
            if(map[i][j+k]==1){
                countj+=1;
            }
        }

        if(countj==n){
            if((j+n<map[0].length && map[i][j+n]!=1) ||(j+n)==map[0].length){
                ans+=1;
                if(j-1>=0){
                    if(map[i][j-1]==1){
                        ans-=1;
                    }
                }
            }

        }

        //아래대각
        for(int k=0;k<n;++k){
            if(i+k>=map.length || j+k>=map[0].length) break;
            if(map[i+k][j+k]==1){
                countk+=1;
            }
        }
        if(countk==n){
            if(i+n<map.length && j+n<map[0].length && map[i+n][j+n]==0){
                ans+=1;
                if(j-1>=0 && i-1>=0){
                    if(map[i-1][j-1]==1){
                        ans-=1;
                    }
                }
            }
            else if (i+n>=map.length || j+n>= map[0].length){
                ans+=1;
                if(j-1>=0 && i-1>=0){
                    if(map[i-1][j-1]==1){
                        ans-=1;
                    }
                }
            }

        }
        //윗대각
        for(int k=0;k<n;++k){
            if(i-k<0 || j+k>=map[0].length) break;
            if(map[i-k][j+k]==1){
                countk2+=1;
            }
        }
        if( countk2==n){
            if(i-n>=0 && j+n<map[0].length && map[i-n][j+n]!=1){
                ans+=1;
                if(i+1< map.length && j-1>=0){
                    if(map[i+1][j-1]==1){
                        ans-=1;
                    }
                }
            }
            else if(i-n<0 || j+n>= map[0].length){
                ans+=1;
                if(i+1< map.length && j-1>=0){
                    if(map[i+1][j-1]==1){
                        ans-=1;
                    }
                }
            }
        }
        return ans;
    }
}