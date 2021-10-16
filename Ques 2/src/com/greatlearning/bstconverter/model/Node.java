package com.greatlearning.bstconverter.model;

/**
 * node of a tree with data, left node and right node
 * */
public class Node {
    private int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public int getData() {
        return data;
    }
}
