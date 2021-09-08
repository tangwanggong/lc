package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
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

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] + nums[1] + nums[2] +nums[3] >target || nums[n-4] + nums[n-3] + nums[n-2] + nums[n-1] < target){
            return result;
        }
        for (int i = 0; i <= n-4; i++) {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){
                break;
            }
            if(nums[i]+ nums[n-3] + nums[n-2] + nums[n-1] < target){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j <= n-3; j++) {
                if(nums[i] + nums[j] + nums[j+1]+nums[j+2] > target){
                    break;
                }
                if(nums[i]+ nums[j] + nums[n-2] + nums[n-1] < target){
                    continue;
                }
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j+1,r = n-1;
                while (l<r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                        while (l<r && nums[l] == nums[l-1]){
                            l++;
                        }
                        while (l<r && nums[r] == nums[r+1]){
                            r--;
                        }
                    }else if(sum < target){
                        l++;
                        while (l<r && nums[l] == nums[l-1]){
                            l++;
                        }
                    }else if(sum > target){
                        r--;
                        while (l<r && nums[r] == nums[r+1]){
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
