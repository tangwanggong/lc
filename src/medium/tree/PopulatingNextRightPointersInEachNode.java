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
}
