package medium.array;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int index = -1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        index = postorder.length-1;
        return help(inorder,postorder,0,postorder.length-1,map);
    }

    private TreeNode help(int[] inorder, int[] postorder, int pl, int pr, Map<Integer,Integer> map) {
        if(pl>pr){
            return null;
        }
        int i = postorder[index--];

        TreeNode treeNode = new TreeNode(i);
        int mid = map.get(i);
        treeNode.right = help(inorder,postorder,mid+1,pr,map);
        treeNode.left = help(inorder,postorder,pl,mid-1,map);
        return treeNode;
    }
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if(inorderStart > inorderEnd){
            return null;
        }
        int index = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == postorder[postorderEnd]){
                index = i;
                break;
            }
        }
        int leftLen = index - inorderStart;
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        root.left = helper(inorder,inorderStart,index-1,postorder,postorderStart,postorderStart+leftLen-1);
        root.right = helper(inorder,index+1,inorderEnd,postorder,postorderStart+leftLen,postorderEnd-1);
        return root;
    }
}
