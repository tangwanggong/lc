package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Tang
 * @create: 2018/9/19 11:39
 **/
public class IntersectionOfTwoArraysII {

    /**
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * 排序后,比较双方的值,相等则添加到list,不等则根据大小进行指针挪动
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0,j=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] a = new int[list.size()];
        for (int z = 0; z < a.length; z++) {
            a[z] = list.get(z);
        }
        return a;
    }

}