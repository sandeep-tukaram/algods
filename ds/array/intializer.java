package ds.array;

import java.util.Arrays;

public class intializer {

    static void defaultIntArray() {
        //defaults to 0;
        int[] a = new int[10];

        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(a));
    }

    static void defaultIntegerArray() {
        //defaults to null values;
        Integer[] a = new Integer[5];

        // [null, null, null, null, null]
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        defaultIntegerArray();
    }
}
