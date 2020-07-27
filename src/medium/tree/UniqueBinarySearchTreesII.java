package medium.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for (int j = start; j <= end; j++) {
            List<TreeNode> left = helper(start,j-1);
            List<TreeNode> right = helper(j+1,end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode rootNode = new TreeNode(j);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    res.add(rootNode);
                }
            }
        }
        return res;
    }
}
