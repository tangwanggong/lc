package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        help(1,k,n,result,new ArrayList<>());
        return result;
    }

    private void help(int start, int k, int n, List<List<Integer>> result, ArrayList<Integer> path) {
        if(k<0||n<0){
            return;
        }
        if(k==0 && n==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < 10; i++) {
            path.add(i);
            help(i+1,k-1,n-i,result,path);
            path.remove(path.size()-1);
        }

    }


}
