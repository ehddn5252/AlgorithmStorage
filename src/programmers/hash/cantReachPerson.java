package programmers.hash;

import java.util.HashMap;
class cantReachPerson {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hashMapInstance = new HashMap<>();
        for(int i=0;i< participant.length;++i){
            hashMapInstance.put(participant[i],0);
        }
        for(int i=0;i< participant.length;++i){
            int value = hashMapInstance.get(participant[i]);
            hashMapInstance.put(participant[i],value+1);
        }
        for(int i=0;i< completion.length;++i){
            int value = hashMapInstance.get(completion[i]);
            hashMapInstance.put(completion[i],value-1);
        }

        for(int i=0;i< participant.length;++i){
            if(hashMapInstance.get(participant[i])==1){
                return participant[i];
            };
        }
            return null;
    }
}