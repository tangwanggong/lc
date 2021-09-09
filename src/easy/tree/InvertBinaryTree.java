package easy.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * @date 2021/6/3
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
