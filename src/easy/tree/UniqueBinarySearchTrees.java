package easy.tree;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * @date 2021/12/28
 */
public class UniqueBinarySearchTrees {
    int[][] cache = null;
    public int numTrees(int n) {
        cache = new int[n+1][n+1];
        return helper(1,n);
    }

    private int helper(int l, int r) {
        int result = 0;
        if(l>r){
            return 1;
        }
        if(cache[l][r]!=0){
            return cache[l][r];
        }
        for (int i = l; i <= r; i++) {
            int left = helper(l,i-1);
            int right = helper(i+1,r);
            result += left * right;
        }
        cache[l][r] = result;
        return result;
    }
}
