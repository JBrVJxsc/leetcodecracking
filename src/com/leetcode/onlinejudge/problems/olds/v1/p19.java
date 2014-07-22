package com.leetcode.onlinejudge.problems.olds.v1;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.UndirectedGraphNode;

/**
 * Created by Who on 2014/6/29.
 */
public class p19 extends BaseProblem implements IProblem {

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String getName() {
        return "[UNSOLVED]Clone Graph";
    }

    @Override
    public String getSummary() {
        return "Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.\n" +
                "OJ's undirected graph serialization:\n" +
                "Nodes are labeled uniquely.\n" +
                "We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.\n" +
                "As an example, consider the serialized graph {0,1,2#1,2#2,2}.\n" +
                "The graph has a total of three nodes, and therefore contains three parts as separated by #.\n" +
                "First node is labeled as 0. Connect node 0 to both nodes 1 and 2.\n" +
                "Second node is labeled as 1. Connect node 1 to node 2.\n" +
                "Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.\n" +
                "Visually, the graph looks like the following:\n" +
                "\n" +
                "       1\n" +
                "      / \\\n" +
                "     /   \\\n" +
                "    0 --- 2\n" +
                "         / \\\n" +
                "         \\_/";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return null;
        }
    }
}
