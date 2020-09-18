import java.util.Random;

public class SortMain {
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[20];

        for(int i = 0 ; i < a.length ; i++){
            a[i] = random.nextInt(100 + 1);
        }

        SortedArray sa = new SortedArray(a);
        sa.printArray();
        sa.sort("quicksort");
        sa.printArray();
    }
}
