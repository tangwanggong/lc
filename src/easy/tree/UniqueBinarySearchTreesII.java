package easy.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * @date 2021/12/28
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> result = new ArrayList<>();
        if(l>r){
            result.add(null);
            return result;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTreeNodes = helper(l, i - 1);
            List<TreeNode> rightTreeNodes = helper(i+1, r);
            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTreeNode;
                    treeNode.right= rightTreeNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
