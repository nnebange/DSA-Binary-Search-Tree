package com.neba.bst.util;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BST {

    private BSTNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode node, int value) {
        if (node == null) return new BSTNode(value, null, null);
        if (value < node.getValue())
            node.setLeft(insertRec(node.getLeft(), value));
        else
            node.setRight(insertRec(node.getRight(), value));
        return node;
    }

    public List<Integer> inOrderTraversal(BSTNode node) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(node, result);
        return result;
    }

    private void inOrderHelper(BSTNode node, List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.getLeft(), result);
            result.add(node.getValue());
            inOrderHelper(node.getRight(), result);
        }
    }

    public BSTNode buildBalancedTree(List<Integer> sortedList, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(sortedList.get(mid), null, null);
        node.setLeft(buildBalancedTree(sortedList, start, mid - 1));
        node.setRight(buildBalancedTree(sortedList, mid + 1, end));
        return node;
    }
}
