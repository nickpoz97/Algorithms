import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[] array = generateArray(10);
        int val = processInput();

        int index = findValueIndex(array, val, 0, array.length-1);
        System.out.println(index);
    }

    private static int findValueIndex(Integer[] array, int val, int start, int stop) {
        if (start == stop){ // 1 cell, base case
            if(val == array[start]){
                return start;
            }
            else{
                return -1;
            }
        }

        int mid = start + (stop - start) / 2; // round to lowest integer

        if (array[mid] == val){
            return mid; // value found
        }
        else if(array[mid] > val){ // go to left (mid value is greater) and subtract 1 to avoid overlapping
            return findValueIndex(array, val, start, mid-1);
        }
        else { // go to right (mid value is smaller) and sum 1 to avoid overlapping
            return findValueIndex(array, val, mid+1, stop);
        }
    }

    private static int processInput() {
        int n;

        try(Scanner keyboard = new Scanner(System.in)){
            n = keyboard.nextInt();
        }
        return n;
    }

    private static Integer[] generateArray(int size) {
        Set<Integer> set = new HashSet<>();
        randomlyFilSet(set, size);
        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
        return array;
    }

    private static void randomlyFilSet(Set<Integer> set, int maxValues){
        Random generator = new Random();

        for(int i = 0; i < maxValues ; i++){
            set.add(generator.nextInt(100));
        }
    }
}
