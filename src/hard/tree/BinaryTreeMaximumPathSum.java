package hard.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @date 2021/5/31
 */
public class BinaryTreeMaximumPathSum {
    Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        max = Math.max(max,root.val+left+right);
        return root.val + Math.max(left,right);
    }
}
