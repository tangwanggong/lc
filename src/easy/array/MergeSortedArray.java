package easy.array;

/**
 * @author: Tang
 * @create: 2018/10/8 14:59
 **/
public class MergeSortedArray {


    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * 归并排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m ; i++) {
            temp[i] = nums1[i];
        }
        int x = 0,y=0;
        for (int i = 0; i < m+n-1 ; i++) {
            if(x>=m){
                nums1[i] = nums2[y];
                y++;
            }else if(y>=n){
                nums1[i] = temp[x];
                x++;
            }else if(temp[x]<=nums2[y]){
                nums1[i] = temp[x];
                x++;
            }else {
                nums1[i] = nums2[y];
                y++;
            }
        }
    }
}