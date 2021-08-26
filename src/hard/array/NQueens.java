package hard.array;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @date 2021/8/26
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        int[] queens = new int[n];
        Arrays.fill(queens,-1);

        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();

        helper(result,0,n,queens,columns,diagonals1,diagonals2);
        return result;
    }

    private void helper(List<List<String>> result, int row, int n, int[] queens, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row == n){
            List<String> generate = generate(queens,n);
            result.add(generate);
        }else {
            for (int j = 0; j < n; j++) {
                if(columns.contains(j)){
                    continue;
                }
                int s1 = row-j;
                if(diagonals1.contains(s1)){
                    continue;
                }
                int s2 = row+j;
                if(diagonals2.contains(s2)){
                    continue;
                }
                columns.add(j);
                diagonals1.add(s1);
                diagonals2.add(s2);
                queens[row] = j;
                helper(result,row+1,n,queens,columns,diagonals1,diagonals2);
                queens[row] = -1;
                columns.remove(j);
                diagonals1.remove(s1);
                diagonals2.remove(s2);
            }
        }
    }

    private List<String> generate(int[] queens, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            result.add(new String(chars));
        }
        return result;
    }

}
