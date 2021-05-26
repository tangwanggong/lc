package medium.tree;

import structure.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @date 2021/5/26
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return new ArrayList<>(result);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.addFirst(list);
        }
        return new ArrayList<>(result);
    }
}
