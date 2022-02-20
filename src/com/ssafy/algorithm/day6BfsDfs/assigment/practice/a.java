package com.ssafy.algorithm.day6BfsDfs.assigment.practice;

//왼쪽 자식노드로 가기위해서 부모노드index*2
//오른쪽 자식노드로 가기위해서 부모노드 index*2+1
public class a {
    public static void preOrder(int x) {
        if(x>7)return;
        System.out.printf("%3d",x);
        preOrder(x*2);
        preOrder(x*2+1);
    }
    public static void inOrder(int x) {
        if(x>7)return;
        inOrder(x*2);
        System.out.printf("%3d",x);
        inOrder(x*2+1);
    }
    public static void postOrder(int x) {//후위
        if(x>7)return;
        postOrder(x*2);
        postOrder(x*2+1);
        System.out.printf("%3d",x);
    }
    public static void main(String[] args) {
        //preOrder(1);
        //inOrder(1);
        postOrder(1);

    }

}
