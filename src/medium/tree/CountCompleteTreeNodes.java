package medium.tree;

import structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *
 * @date 2021/6/3
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1 << left);
        }else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root){
        int level = 0;
        TreeNode node = root;
        while (node != null){
            node = node.left;
            level++;
        }
        return level;
    }
}

