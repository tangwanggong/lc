package algorithm.sort;

import java.util.Random;

/**
 * 随机快排
 */
public class QuickSort {

    private void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if(l<r){
            //取随机数,与末尾数交换
            swap(arr,l+new Random().nextInt(r-l),r);
            //记录与末尾数相等的数组
            int[] e = partition(arr,l,r);
            quickSort(arr,l,e[0]-1);
            quickSort(arr,e[1]+1,r);
        }
    }

    /**
     * 荷兰旗问题解法
     * @param arr
     * @param L
     * @param R
     * @return 返回与末尾数字相等的数组
     */
    private int[] partition(int[] arr, int L, int R) {
        int less = L-1;
        int more = R;
        while (L<more){
            if(arr[L]<arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,R,more);
        return new int[]{less+1,more};
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
