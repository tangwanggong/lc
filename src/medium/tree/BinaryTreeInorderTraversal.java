package medium.tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        while (!arrayDeque.isEmpty() || root!=null){
            while (root!=null){
                arrayDeque.add(root);
                root = root.left;
            }
            TreeNode treeNode = arrayDeque.removeLast();
            res.add(treeNode.val);
            root = treeNode.right;
        }
        return res;
    }
}
