package algorithm.sort;

public class InsertionSort {

    public void sort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i-1; j>0&&arr[j]>arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
