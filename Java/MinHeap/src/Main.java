import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap(40);
        Random random = new Random();

        for(int i = 0; i < 40 ; i++)
            minHeap.insert(random.nextInt());

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
    }
}
