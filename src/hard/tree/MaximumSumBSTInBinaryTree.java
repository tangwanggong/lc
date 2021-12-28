package hard.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 * @date 2021/10/12
 */
public class MaximumSumBSTInBinaryTree {
    int result = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return result;
    }

    private int[] helper(TreeNode root) {
        if(root == null){
            // 0-> 0,非搜索树 1,bst  1->子树最小的值 2->子树最大的值 3->加和
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int val = root.val;
        int[] resultArray = new int[4];
        if(left[0] == 1 && right[0] == 1 && val>left[2] && val<right[1]){
            resultArray[0] = 1;
            resultArray[1] = Math.min(val,left[1]);
            resultArray[2] = Math.max(val,right[2]);
            resultArray[3] = val + left[3] + right[3];
            result = Math.max(result,resultArray[3]);
        }else {
            resultArray[0] = 0;
        }
        return resultArray;
    }
}
