package medium.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @date 2021/6/3
 */
public class KthSmallestElementInABst {
    int result = -1;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return result;
        }
        helper(root,k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if(root == null){
            return;
        }
        helper(root.left,k);
        if(++rank == k){
            result = root.val;
            return;
        }
        helper(root.right,k);
    }
}
