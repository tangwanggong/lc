package algorithm.sort;

public class SelectionSort {

    public void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length-1 ; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            if(minIndex!=i){
                swap(arr,i,minIndex);
            }
        }
    }


    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
