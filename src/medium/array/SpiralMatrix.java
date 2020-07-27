package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @date 2020/5/25
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length==0){
            return result;
        }
        int[] dm = new int[]{0,1,0,-1};
        int[] dn = new int[]{1,0,-1,0};
        int m = matrix.length;
        int n = matrix[0].length;
        int op = 0;
        boolean[][] flagArr = new boolean[m][n];
        int mIndex = 0,nIndex= 0;
        for (int i = 0; i < m*n ; i++) {
            result.add(matrix[mIndex][nIndex]);
            flagArr[mIndex][nIndex] = true;
            int mTemp = mIndex+dm[op];
            int nTemp = nIndex+dn[op];
            if(mTemp>=0 && mTemp<m && nTemp>=0 && nTemp<n && !flagArr[mTemp][nTemp]){
                mIndex = mTemp;
                nIndex = nTemp;
            }else {
                op = (op+1) % 4;
                mIndex += dm[op];
                nIndex += dn[op];
            }
        }
        return result;
    }
}
