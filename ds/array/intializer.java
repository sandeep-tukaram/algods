package ds.array;

import java.util.Arrays;

public class intializer {

    static void defaultArray() {
        // int defaults to 0;
        int[] a = new int[10];

        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        defaultArray();
    }
}
