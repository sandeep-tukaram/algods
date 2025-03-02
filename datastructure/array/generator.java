package datastructure.array;
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

    static void defaultIntArray(int size) {
        //values defaults to 0;
        int[] a = new int[size];

        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0...]
        System.out.println(Arrays.toString(a));
    }

    static void defaultIntegerArray(int size) {
        //defaults to null values;
        Integer[] a = new Integer[size];

        // [null, null, null, null, null....]
        System.out.println(Arrays.toString(a));
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomIntegers(20)));
    }
}
