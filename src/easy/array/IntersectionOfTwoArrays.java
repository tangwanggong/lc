package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }
        }
        int[] arr = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arr[k] = result.get(k);
        }
        return arr;
    }
}
