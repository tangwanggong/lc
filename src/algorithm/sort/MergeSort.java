package algorithm.sort;

public class MergeSort {

    public void sort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int mid = l - (r-l)>>1;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while (p1<=mid&&p2<=r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
    }

}
