package medium.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @date 2021/6/1
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int height = 0;
        helper(root,result,height);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result,int height) {
        if(root == null){
            return;
        }
        if(height == result.size()){
            result.add(root.val);
        }
        helper(root.right,result,height+1);
        helper(root.left,result,height+1);
    }
}
