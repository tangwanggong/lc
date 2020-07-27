package medium.array;

/**
 * https://leetcode-cn.com/problems/word-search/
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class WordSearch {
    // move top bottom left right
    int[][] op = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(help(0,flag,board,word,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean help(int size, boolean[][] flag, char[][] board,String word,int m,int n) {
        if(size==word.length()-1){
            return word.charAt(size) == board[m][n];
        }
        if(board[m][n] == word.charAt(size)){
            flag[m][n] = true;
            for (int i = 0; i < op.length; i++) {
                int newM = m+op[i][0];
                int newN = n+op[i][1];
                if(newM<0 || newN<0 || newM>board.length || newN>board[0].length || flag[newM][newN]){
                    continue;
                }

                if(help(size+1,flag,board,word,newM,newN)){
                    return true;
                }
            }
            flag[m][n] = false;
        }
        return false;
    }
}
