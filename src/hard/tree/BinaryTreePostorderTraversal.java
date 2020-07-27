package hard.tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if(root==null){
            return res;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()){
            TreeNode treeNode = arrayDeque.removeLast();
            res.addFirst(treeNode.val);
            if(treeNode.left!=null){
                arrayDeque.add(root.left);
            }
            if(treeNode.right!=null){
                arrayDeque.add(root.right);
            }
        }
        return res;
    }
}
