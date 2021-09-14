package medium.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * @date 2021/9/14
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if(l>r){
            return null;
        }
        int max = Integer.MIN_VALUE,index = -1;
        for (int i = l; i <= r; i++) {
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums,l,index-1);
        root.right = helper(nums,index+1,r);
        return root;
    }
}
