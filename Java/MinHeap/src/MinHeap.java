public class MinHeap {
    int[] array;
    int lastUsedIndex; // also size

    public MinHeap(int size){
        array = new int[size+1]; // index 0 is not used
        lastUsedIndex = 0;
    }

    public int getSize() {
        return lastUsedIndex;
    }

    public int peek() throws Exception {
        if(lastUsedIndex == 0){
            throw new Exception("Empty heap");
        }
        return array[1];
    }

    public void insert(int value){
        lastUsedIndex++;
        array[lastUsedIndex] = value;
        heapifyBottomToTop(lastUsedIndex);
    }

    private void heapifyBottomToTop(int nodeIndex){
        if(nodeIndex == 1){
            return; // top reached
        }
        else if(array[nodeIndex] < array[nodeIndex / 2]){ // child smaller than father
            int father = nodeIndex/2;
            int son = nodeIndex;

            swap(father, son);
            heapifyBottomToTop(father);
        }
    }

    public int extractMin() throws Exception {
        if(lastUsedIndex == 0){
            throw new Exception("Empty heap");
        }

        int val = array[1];
        array[1] =  array[lastUsedIndex]; // last value is the new root
        lastUsedIndex--; // decrease size
        heapifyTopToBottom(1);
        return  val;
    }

    private void heapifyTopToBottom(int nodeIndex) {
        int left = nodeIndex * 2;
        int right = nodeIndex * 2 + 1;

        if(left > lastUsedIndex){
            return; // last node reached
        }
        else if(left == lastUsedIndex){ // only one child
            if(array[nodeIndex] > array[left]){
                swap(nodeIndex, left);
            }
        }
        else { // 2 children
            int smallestChildIndex = (array[left] < array[right]) ? left : right;
            swap(nodeIndex, smallestChildIndex);
            heapifyTopToBottom(smallestChildIndex);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void deleteHeap(){
        array = null;
    }
}
