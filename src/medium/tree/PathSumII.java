package medium.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * @date 2021/5/27
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,targetSum,result,new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if (root == null){
            return;
        }
        path.add(root.val);
        int temp = targetSum - root.val;
        if(root.left == null && root.right == null && temp == 0){
            result.add(new ArrayList<>(path));
        }
        dfs(root.left,temp,result,path);
        dfs(root.right,temp,result,path);
        path.remove(path.size()-1);
    }
}
