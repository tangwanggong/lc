package medium.array;

import java.util.*;

/**
 *
 * @date 2020/1/18
 */
public class ThreeSum {
    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[left] + nums[right] + nums[i] ;
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    while (left<right && nums[left]== nums[left+1]){
                        left++;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int base = nums[i];
            int l = i + 1,r = nums.length-1;
            while (l<r){
                int lv = nums[l],rv = nums[r];
                int sum = base + lv + rv;
                if(sum == 0){
                    result.add(Arrays.asList(base,lv,rv));
                    l++;
                    r--;
                    while (l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while (l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(sum < 0){
                    l++;
                    while (l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                }else if(sum > 0){
                    r--;
                    while (l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }
            }
        }
        return result;
    }

}
