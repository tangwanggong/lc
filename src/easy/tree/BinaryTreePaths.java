package easy.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @date 2021/6/3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root,result,new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, List<String> result,List<String> list) {
        if(root == null){
            return;
        }
        list.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            result.add(String.join("->",list));
        }else {
            dfs(root.left,result,list);
            dfs(root.right,result,list);
        }
        list.remove(list.size()-1);
    }
}
