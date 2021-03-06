package easy.tree;

import structure.TreeNode;

/**

 * @create: 2018/9/14 9:02
 **/
public class MaximumDepthOfBinaryTree {

    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its depth = 3
     * 利用递归计算最大层数,先找到左子树最大深度,然后右子树,如无子节点返回0,如有则逐层+1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
