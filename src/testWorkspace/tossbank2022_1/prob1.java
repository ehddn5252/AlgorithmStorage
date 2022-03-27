package testWorkspace.tossbank2022_1;
// 송금 성공횟수와 실패횟수 max 10억
class prob1 {
    public int[] solution(int money, int limit) {
        int[] answer = {};
        // 성공 횟수
        int submitCount = 0;
        int successNum = 0;
        int failNum = 0;
        // 1. 맨 처음 송금 성공시 return
        if(money>=limit){
            successNum+=1;
            answer=new int[]{successNum,failNum};
            return answer;
        }

        while(limit>0){
            if (submitCount==2){
                break;
            }
            if(money<limit){
                limit/=2;
                submitCount=0;
                failNum+=1;
            }
            else{
                successNum+=1;
                submitCount+=1;
                money-=limit;
            }
        }
        answer= new int[]{successNum,failNum};
        return answer;
    }
}