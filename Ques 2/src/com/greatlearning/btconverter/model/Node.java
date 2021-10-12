package com.greatlearning.btconverter.model;

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
