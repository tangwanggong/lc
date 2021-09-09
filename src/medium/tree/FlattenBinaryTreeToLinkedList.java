package medium.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @date 2021/5/28
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null){
            if(root.left == null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    public void flatten2(TreeNode root) {
        if(root == null){
            return;
        }
        flatten2(root.left);
        flatten2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode tmp = root;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = right;
    }

}
