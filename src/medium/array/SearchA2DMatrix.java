package medium.array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int l = 0,r=matrix.length*matrix[0].length-1;
        while (l<=r){
            int mid = (l+r)/2;
            int m = mid/matrix.length;
            int n = mid%matrix.length;
            if(matrix[m][n] == target){
                return true;
            }else if(matrix[m][n] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return false;
    }
}
