package com.pqq.test;

/**
 * @author pqq
 * @create ${year}-12-16 15:48
 */

class Node{
    Node upLeavel[] = new Node[100];
    Node sameLeavel[] = new Node[100];
    Node downLeavel[] = new Node[100];

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CompanyStructure {
    public static void main(String[] args) {
        Node node = new Node();
        node.downLeavel[0].setName("haha");
        node.downLeavel[1].setName("haha1");
        node.downLeavel[2].setName("haha2");

        System.out.println(node.downLeavel[0].getName());
    }
}
