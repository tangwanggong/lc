package medium.array;

import java.util.*;

/**
 * @author tangh
 * @date 2020/1/18
 */
public class FourSum {
    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     *
     * Note:
     *
     * The solution set must not contain duplicate quadruplets.
     *
     * Example:
     *
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     *
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        find(lists,nums,target,new ArrayList<Integer>(),0);
        return lists;
    }

    private void find(List<List<Integer>> lists, int[] nums, int target, ArrayList<Integer> integers, int index ) {
        if(target==0 && integers.size()==4 ){
            lists.add(new ArrayList<>(integers));
            return;
        }
        if(integers.size()==4 || index == nums.length || nums[nums.length-1] * (4-integers.size())< target){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i] * (4-integers.size())>target){
                break;
            }
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            integers.add(nums[i]);
            find(lists,nums,target-nums[i],integers,i+1);
            integers.remove(integers.size()-1);
        }
    }
}
