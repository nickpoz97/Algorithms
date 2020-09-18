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

}
