package algorithm.sort;

public class BubbleSort {


    public void sort(int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
