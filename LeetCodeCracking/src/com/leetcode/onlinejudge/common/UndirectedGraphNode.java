package com.leetcode.onlinejudge.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/6/29.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
