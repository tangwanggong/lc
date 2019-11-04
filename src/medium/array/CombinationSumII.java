package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        help(candidates,target,0,new ArrayList<>());
        return result;
    }

    private void help(int[] candidates, int target,int index,List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            //大于0,视为还可以进行排列组合
        }else {
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) { // to avoid duplicates skip all equal numbers except the first
                    continue;
                }
                //添加一位，进行搜索
                list.add(candidates[i]);
                //进入递归
                help(candidates,target-candidates[i],i+1,list);
                //跳出递归，说明最后一位可能性都已被使用，删除它
                list.remove(list.size()-1);
            }
        }
    }

}
