package medium.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * @date 2021/5/31
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root, int i) {
        if(root == null){
            return 0;
        }
        int temp = i * 10 + root.val;
        if(root.left == null && root.right == null){
            return temp;
        }
        return helper(root.left,temp) + helper(root.right,temp);
    }
}
