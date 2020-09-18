import java.util.*;

public class SortedArray{
    int[] arr;
    public SortedArray(int[] arr){
        this.arr = arr;
    }

    public void sort(String sortingAlgorithm){
        if(sortingAlgorithm.toLowerCase().equals("bubblesort")){
            bubbleSort();
        }
        else if(sortingAlgorithm.toLowerCase().equals("selectionsort")){
            selectionSort();
        }
        else if(sortingAlgorithm.toLowerCase().equals("insertionsort")){
            insertionSort();
        }
        else if(sortingAlgorithm.toLowerCase().equals("bucketsort")){
            buckeSort();
        }
        else if(sortingAlgorithm.toLowerCase().equals("mergesort")){
            mergeSortInterface();
        }
        else if(sortingAlgorithm.toLowerCase().equals("quicksort")){
            quickSortInterface();
        }
    }

    private void swap(int ia, int ib){
        int temp = arr[ia];
        arr[ia] = arr[ib];
        arr[ib] = temp;
    }

    public void printArray(){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + ", " );
        }
        System.out.println();
    }

    private void bubbleSort(){
        for(int i = 0; i < arr.length ; i++){
            for(int j = 0; j < arr.length - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }

    private void selectionSort(){
        for (int i = 0 ; i < arr.length ; i++){
            int minIndex = i;

            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    private void insertionSort(){
        for(int i = 0 ; i < arr.length ; i++){
            int val = arr[i];
            int j;
            for(j = i ; j > 0 && val < arr[j-1] ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = val;
        }
    }

    private void buckeSort(){
        Map<Integer, List<Integer>> bucketMap = new HashMap<>(); // buckets are arraylists
        int nbuckets = (int) (Math.sqrt(arr.length));
        int maxValue = Arrays.stream(arr).max().getAsInt();

        for(int i = 0 ; i < nbuckets ; i++){
            bucketMap.put(i, new ArrayList<Integer>());
        }

        for(int val : arr){
            int iBucket = val * nbuckets / (maxValue + 1); // maxValue stays in the ast bucket
            List<Integer> list = bucketMap.get(iBucket);
            list.add(val);
        }

        for(List<Integer> l : bucketMap.values()){
            Collections.sort(l);
        }

        int i = 0;
        for(List<Integer> l : bucketMap.values()){
            for(Integer val : l){
                arr[i] = val;
                i++;
            }
        }
    }

    private void mergeSortInterface(){
        int min = 0;
        int max = arr.length-1;
        mergeSort(min, max);
    }

    private void mergeSort(int l, int r){
        if(l < r){
            int m = (l + r)/2;
            mergeSort(l, m);
            mergeSort(m+1, r);
            merge(l, r, m);
        }
    }

    private void merge(int l, int r, int m) {
        int L[] = Arrays.copyOfRange(arr, l, m + 1);
        int R[] = Arrays.copyOfRange(arr, m + 1, r + 1);
        int li = 0;
        int ri = 0;
        for (int i = l; i <= r; i++)
            if (ri >= R.length || (li < L.length && L[li] <= R[ri])) {
                arr[i] = L[li];
                li++;
            } else{
                arr[i] = R[ri];
                ri++;
            }
    }

    private void quickSortInterface(){
        quickSort(0, arr.length-1);
    }

    private void quickSort(int l, int r){ // min index and max index
        if(l<r) {
            int p = partition(l, r);
            quickSort(l, p - 1);
            quickSort(p + 1, r);
        }
    }

    private int partition(int l, int r){
        int pValue = arr[r];
        int j = l; // index for searching min values
        int i = l-1; // last number less than arr[pivot] during ieterations

        while(j<=r){
            if(arr[j] <= pValue){
                swap(++i, j);
            }
            j++;
        }

        return i;
    }

}
