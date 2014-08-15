package com.leetcode.onlinejudge.common;

import java.util.Arrays;

/**
 * Created by Who on 2014/6/29.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public static final long N = Long.MIN_VALUE;
    private int size = 0;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTreeNode(long... values) {
        if (values.length == 0) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[values.length + 1];
        for (int i = 0; i < values.length; i++) {
            long value = values[i];
            if (value == N) {
                continue;
            }
            treeNodes[i + 1] = new TreeNode((int) value);
        }
        for (int i = 1; i < treeNodes.length; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            TreeNode left = i * 2 >= treeNodes.length ? null : treeNodes[i * 2];
            TreeNode right = i * 2 + 1 >= treeNodes.length ? null : treeNodes[i * 2 + 1];
            treeNodes[i].left = left;
            treeNodes[i].right = right;
        }
        return treeNodes[1];
    }

    public int size() {
        size = 0;
        size(this);
        return size;
    }

    private void size(TreeNode node) {
        if (node == null) {
            return;
        }
        size++;
        size(node.left);
        size(node.right);
    }

    public int getDepth() {
        return getDepth(this, 0);
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
    }

    public long[] toLongArray() {
        int depth = getDepth();
        long[] nodes = new long[(int) Math.pow(2, depth) + 1];
        fillLongArray(nodes, this, 1);
        int nullCounter = 0;
        int index = nodes.length - 1;
        while (index > 0 && nodes[index] == N) {
            nullCounter++;
            index--;
        }
        return Arrays.copyOfRange(nodes, 1, nodes.length - nullCounter);
    }

    private void fillLongArray(long[] nodes, TreeNode node, int index) {
        if (node == null) {
            if (index < nodes.length) {
                nodes[index] = N;
            }
            return;
        }
        nodes[index] = node.val;
        fillLongArray(nodes, node.left, index * 2);
        fillLongArray(nodes, node.right, index * 2 + 1);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
