package medium.tree;

import structure.Node;

/**
 * @author tanghao
 * @date 2021/5/28
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        if(root.left != null){
            root.left.next = root.right;
            root.right.next = root.next == null? null:root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }

    public Node connect2(Node root) {
        if(root == null){
            return null;
        }
        helper(root.left,root.right);
        return root;
    }

    private void helper(Node left, Node right) {
        if(left == null || right == null){
            return;
        }
        left.next = right;
        helper(left.left,left.right);
        helper(right.left,right.right);
        helper(left.right,right.left);
    }
}
