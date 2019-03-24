package medium.array;

/**
 * @author: Tang
 * @create: 2019/3/24 22:10
 **/
public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     * Example:
     *
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * @param height
     * @return
     * 设 r > l 面积为(长*宽)
     * maxArea = Math.min(a[l],a[r])*(r-l)
     * 需要保证 l 左边没有比它高的线 r 右边没有比它高的线 这样可以保证宽度最大化,高度也最大化
     * 于是从头和尾进行比较,移动下标是为了找到更大的高度
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1 ;
        int max = 0;
        while (left<right){
            int size = (right - left) * Math.min(height[left],height[right]);
            max = Math.max(size,max);
            if(height[right]>height[left]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

}