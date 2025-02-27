package datastructure.array;

import java.util.Arrays;

public class shifter {

    // incrementatl recursion  
    // T(n) = T(n-1) + O(1) = O(n)
    static <T> void incremental(T[] A, int i, int k) {
        if (i + k >= A.length) return;
        incremental(A, i+1, k);
        A[i + k] = A[i];
        A[i] = null;
    }

    static <T> void division (T[] A, int i, int k) {
        division(A, i, A.length-1, k);
    }

    // T(n) = 2T(n/2) = O(n)
    static <T> void division(T[] A, int i, int j, int k) {
        if (i == j) {
            if (i+k < A.length) A[i + k] = A[i];
            A[i] = null;
            return;
        }

        int m = (j + i)/2;

        division(A, m+1, j, k);
        division(A, i, m, k);
    }

}

// test correctness
class Correctness {
    public static void main(String[] args) {
        Integer[] A = generator.reverseSortedIntegers(10);
        shifter.division(A, 0, 4);
        System.out.println(Arrays.toString(A));
    }
}


// test efficiency
class Benchmark {

    public static void main(String[] args) {
        // Test different array sizes
        int[] sizes = {100, 1000, 6000, 30000};
        
        System.out.println("\n\n***** Testing for generated sorted array *****");
        for (int size : sizes) {
            Integer[] arr = generator.sortedIntegers(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for randomly generated array *****");
        for (int size : sizes) {
            Integer[] arr = generator.randomIntegers(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for generated reverse sorted array *****");
        for (int size : sizes) {
            Integer[] arr = generator.reverseSortedIntegers(size);
            test(arr);
        }
    }

    private static void test(Integer[] arr) {        
        // Benchmark - incremental
        Integer[] arr2 = arr.clone();     
        long startTime2 = System.nanoTime();
        shifter.incremental(arr2, 0, arr.length/10);
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / 1_000_000.0;       
        
        
        // Benchmark - division approach
        Integer[] arr3 = arr.clone();     
        long startTime3 = System.nanoTime();
        shifter.division(arr3, 0, arr.length/10);
        long endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3) / 1_000_000.0;        
        

        System.out.printf("Array size: %d\n", arr.length);
        System.out.printf("Shift incrementally, time: %.2f ms\n", duration2);
        System.out.printf("Shift by division, time: %.2f ms\n", duration3);
        System.out.println("--------------------");
    }

}
