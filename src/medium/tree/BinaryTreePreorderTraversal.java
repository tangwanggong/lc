package medium.tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 递归
        // helper(root,res);
        // 迭代
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if(root==null){
            return res;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()){
            TreeNode treeNode = arrayDeque.removeLast();
            res.add(treeNode.val);
            if(treeNode.right!=null){
                arrayDeque.add(treeNode.right);
            }
            if(treeNode.left!=null){
                arrayDeque.add(treeNode.left);
            }
        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root==null){
            return;
        }
        res.add(root.val);
        if(root.left!=null){
            helper(root.left,res);
        }
        if(root.right!=null){
            helper(root.right,res);
        }
    }

}
