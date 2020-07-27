package medium.array;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @date 2020/5/25
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int l = 0,r=n-1,t=0,b=n-1;
        int pow = n*n;
        while (num<=pow){
            for (int i = l; i <= r; i++) {
                result[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                result[i][r] = num++;
            }
            r--;
            for (int i = r; i >=l ; i--) {
                result[b][i] = num++;
            }
            b--;
            for (int i = b; i >=t ; i--) {
                result[i][l] = num++;
            }
            l++;
        }
        return result;
    }
}
