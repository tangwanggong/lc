package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangh
 * @date 2020/1/17
 */
public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        help(nums,lists,new ArrayList<>(),0);
        return lists;
    }


    private void help(int[] nums,List<List<Integer>> lists, List<Integer> con,int index) {
        lists.add(new ArrayList<>(con));
        for (int i = index; i < nums.length; i++) {
            if (con.contains(nums[i])){
                continue;
            }
            con.add(nums[i]);
            help(nums,lists,con,i+1);
            con.remove(con.size()-1);
        }
    }

}
