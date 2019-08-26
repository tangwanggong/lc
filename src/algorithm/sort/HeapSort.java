package algorithm.sort;

public class HeapSort {

    private void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int more = arr.length-1;
        swap(arr,more,0);
        while (more>0){
            heapify(arr,0,more);
            swap(arr,--more,0);
        }
    }

    /**
     * 上浮
     * @param arr
     * @param index
     */
    private void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;;
        }
    }

    /**
     * 下沉
     * @param arr
     * @param index
     * @param heapSize
     */
    private void heapify(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            int largest = left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if(largest==index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;
        }
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
