package com.greatlearning.btconverter.service;

import com.greatlearning.btconverter.model.Node;


/**
 * BST Services provides operations that operates on BST like
 * 1. InOrder Traversal
 * 2. Conversion from BST to RightSkewedBST
 * */
public class BSTServices {

    Node skewedTreeNode = null;
    Node tempPrevNode = null;

    //InOrder tree traversal
    public void inOrder(Node root) {
        if (root == null) return;
        else {
            inOrder(root.left);
            System.out.print(root.getData() + " ");
            inOrder(root.right);
        }
    }

    /**
     * Algo Comment Start
     *
     * Declare 2 nodes as skewedTreeNode and tempPrevNode
     *
     * if root == null (empty tree/subtree)
     *   then return
     *
     * Recursive call to left subtree of the root to convert BST into RightSkewed BST
     *
     * if skewedTreeNode == null (i.e. if skewedTree is not yet initialised)
     *   then set skewedTreeNode = node
     * else
     *   set right of tempPrevNode = root
     *
     * set tempPrevNode = root (make current node as previous node)
     * set left of root = null
     *
     * Recursive call to right subtree of the root to convert BST into RightSkewed BST
     *
     * Algo comment End
     * */
    public Node convertBSTIntoRightSkewedBST(Node root) {

        if (root == null) {
            return skewedTreeNode;
        }

        convertBSTIntoRightSkewedBST(root.left);

        if (skewedTreeNode == null) {
            skewedTreeNode = root;
        } else {
            tempPrevNode.right = root;
        }
        tempPrevNode = root;
        root.left = null;

        convertBSTIntoRightSkewedBST(root.right);

        return skewedTreeNode;
    }
}
