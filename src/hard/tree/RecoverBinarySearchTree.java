package hard.tree;

import structure.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode x = null,y = null,pre = null;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        while (!arrayDeque.isEmpty() || root!=null){
            while (root!=null){
                arrayDeque.add(root);
                root = root.left;
            }
            TreeNode treeNode = arrayDeque.removeLast();
            if(pre!=null && treeNode.val<=pre.val){
                y = treeNode;
                if(x==null){
                    x = pre;
                }else {
                    break;
                }
            }
            pre = treeNode;
            root = treeNode.right;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
