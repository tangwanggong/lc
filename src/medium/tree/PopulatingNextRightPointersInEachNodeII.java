package medium.tree;

import structure.Node;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @date 2021/5/28
 */
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        Node cur = root;
        while (cur != null){
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

}
