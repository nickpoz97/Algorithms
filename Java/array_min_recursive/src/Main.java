import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String args[]){
        int[] array = new int[10];
        randomFill(array);
        int min = recursiveMinInArray(array);
        System.out.println("finish");
    }

    private static void randomFill(int a[]){
        Random random = new Random();

        for (int i = 0 ; i < a.length ; i++){
            a[i] = random.nextInt(100);
        }
    }

    private static int recursiveMinInArray(int[] a){
        return tailRecMinArray(a, a.length-1, Integer.MAX_VALUE);
    }

    private static int tailRecMinArray(int arr[], int index, int min){
        if(index == -1){
            return min;
        }

        else{
            if(arr[index] < min){
                min = arr[index];;
            }

            return tailRecMinArray(arr, index-1, min);
        }
    }
}
