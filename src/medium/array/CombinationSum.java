package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2019/5/28
 */
public class CombinationSum {
    /**
     *  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        help(candidates,target,0,new ArrayList<>());
        return result;
    }

    private void help(int[] candidates, int target,int index,List<Integer> list){
        //如果目标小于0,则视为组合超过目标大小
        if(target<0){
            return;
        //等于0，视为组合等于目标大小,添加
        }else if(target == 0){
            List<Integer> t = new ArrayList<>(list);
            result.add(t);
        //大于0,视为还可以进行排列组合
        }else {
            for (int i = index; i < candidates.length; i++) {
                //添加一位，进行搜索
                list.add(candidates[i]);
                //进入递归
                help(candidates,target-candidates[i],i,list);
                //跳出递归，说明最后一位可能性都已被使用，删除它
                list.remove(list.size()-1);
            }
        }
    }
}
