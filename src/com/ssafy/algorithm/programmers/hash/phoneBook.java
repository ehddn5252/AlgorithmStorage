package com.ssafy.algorithm.programmers.hash;

import static java.util.Arrays.sort;

class phoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        sort(phone_book);
        for(int i=0;i<phone_book.length-1;++i){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            };
        }
        return answer;
    }
}