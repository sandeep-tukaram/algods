package ds.array;
import java.util.Arrays;
import java.util.Random;

public class generator {

    public static Integer[] randomIntegers(int size) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    public static Integer[] sortedIntegers(int size) {
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    public static Integer[] reverseSortedIntegers(int size) {
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = size-i;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomIntegers(20)));
    }
}
