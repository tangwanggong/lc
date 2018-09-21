package easy.tree;

import structure.TreeNode;

import javax.transaction.TransactionRequiredException;

/**
 * @author: Tang
 * @create: 2018/9/18 10:15
 **/
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *  利于递归一一创建左右子树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = toBeTree(nums,0,nums.length-1);
        return treeNode;
    }
    public TreeNode toBeTree(int[] nums,int l,int r){
        if(l>r)
            return null;
        int mid = (l+r)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = toBeTree(nums,l,mid-1);
        treeNode.right = toBeTree(nums,mid+1,r);
        return treeNode;
    }
}