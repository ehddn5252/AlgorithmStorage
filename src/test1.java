import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 1. 목적이 무엇인지 생각하기.
// 2.
class test1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s =br.readLine();
        for(int i=0;i<s.length();++i){
            System.out.println("hh");
        }
    }
}