package fileIO;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class stringTokenizerTest1 {
    public static void main(String[] args){
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("2022/02/03","/");
        while(st.hasMoreElements()){
            System.out.println(st.nextElement());
        }
    }
}

