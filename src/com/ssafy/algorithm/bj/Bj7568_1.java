package com.ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bj7568_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Person> p = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            p.add(new Person(Integer.parseInt(s[0]), Integer.parseInt(s[1]), i, 1));
        }
        Collections.sort(p);
        int rank = 1;
        int duplicateStack = 1;
        int size = p.size();
        for (int i = 0; i < size - 1; ++i) {
            int count = 1;
            Person np = p.get(i);
            for (int j = i + 1; j < size; ++j) {
                Person np2 = p.get(j);
                if (np.height < np2.height && np.weight < np2.weight) {
                    count += 1;
                }
            }
            np.rank = count;
            p.set(i, np);
        }

        Collections.sort(p, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.index-o2.index;
            }
        });
        for(int i=0;i<size;++i){
            if(i!=size-1){
                System.out.print(p.get(i).rank+" ");
            }
            else{
                System.out.print(p.get(i).rank);
            }
        }
    }

    static class Person implements Comparable<Person>{
        int weight;
        int height;
        int index;
        int rank;

        public Person(int weight, int height,int index, int rank) {
            this.weight = weight;
            this.height = height;
            this.index = index;
            this.rank = rank;
        }

        @Override
        public int compareTo(Person o) {
            if(weight==o.weight){
                return height-o.height;
            }
            return weight-o.weight;
        }
    }
}
