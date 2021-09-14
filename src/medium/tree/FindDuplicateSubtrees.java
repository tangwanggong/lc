package medium.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * @date 2021/9/14
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        helper(root,map,result);
        return result;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if(root == null){
            return "#";
        }
        String left = helper(root.left, map, result);
        String right = helper(root.right, map, result);
        String s = root.val + "," + left + "," + right;
        Integer orDefault = map.getOrDefault(s, 0);
        if(orDefault == 1){
            result.add(root);
        }
        map.put(s,orDefault+1);
        return s;
    }
}
