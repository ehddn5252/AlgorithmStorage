package com.ssafy.day4StackQueueList.live;

public class Node {
    String data;
    Node link;
    public Node(String data, Node link){
        super();
        this.data=data;
        this.link=link;
    }
    public Node(String data){
        super();
        this.data=data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", link=" + link +
                '}';
    }
}
