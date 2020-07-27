package medium.array;


import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,6,10,20,15,7]
 * 中序遍历 inorder = [6,9,10,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *  /\  /\
 *6  10 15  7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
          map.put(inorder[i],i);
        }
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    private TreeNode help(int[] preorder, int pl, int pr, int[] inorder, int il, int ir, Map<Integer,Integer> indexMap) {
        if(pl>pr){
            return null;
        }
        int mid = preorder[pl];
        TreeNode treeNode = new TreeNode(mid);
        Integer inorderMid = indexMap.get(mid);
        int leftLen = inorderMid-il;
        treeNode.left = help(preorder,pl+1,pl+leftLen,inorder,il,inorderMid-1,indexMap);
        treeNode.right = help(preorder,pl+leftLen+1,pr,inorder,inorderMid+1,ir,indexMap);
        return treeNode;
    }
}
