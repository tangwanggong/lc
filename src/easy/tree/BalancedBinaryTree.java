package easy.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @date 2021/5/26
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left,right;
        if((left = helper(root.left)) == -1 || (right = helper(root.right)) == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }

}
