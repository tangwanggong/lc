package easy.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Tang
 * @create: 2018/9/21 9:49
 **/
public class SymmetricTree {


    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * But the following [1,2,2,null,3,null,3] is not:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     * 比较左右子树的值是否相等,左的左==右的右 左的右==右的左
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left,root.right);
    }


    public boolean isSymmetricHelp(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left == right;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSymmetricHelp(left.left,right.right)&&isSymmetricHelp(left.right,right.left);
    }

}