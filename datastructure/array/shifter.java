package datastructure.array;

import java.util.Arrays;

public class shifter {
    
    // shift i..j  k places O(n+k)
    static <T> void iteratively(T[] A, int i, int j, int k) {
        if ( k > 0 && j + k < A.length ) {
            // shift right
            for (int n = j; n >= i; n--) {
                A[n+k] = A[n];
            }

            // clear residual
            for (int n = i+k-1; n >=i; n--) {
                A[n] = null;
            }
        }
    }

    // shift i..j  k places O(n)
    static <T> void iteratively_improved(T[] A, int i, int j, int k) {
        if ( k > 0 && j + k < A.length ) {
            // shift right and clear residual
            for (int n = j; n >= i; n--) {
                A[n+k] = A[n];
                A[n] = null;
            }
        }
    }

    // incrementatl recursion  
    // T(n) = T(n-1) + O(1) = O(n)
    static <T> void incremental(T[] A, int i, int j, int k) {
        if (i == j) {
            if ((j+k) < A.length - 1 ) A[j + k] = A[j];
            A[j] = null;
            return;
        }

        incremental(A, i+1, j, k);
        A[i + k] = A[i];
        A[i] = null;
    }


    // TODO - buggy residual cleaning step
    // division recursion
    // T(n) = 2T(n/2)  = O(n)
    static <T> void division(T[] A, int i, int j, int k) {
        if (i == j) {
            if ((j+k) <= A.length - 1 ) A[j + k] = A[j];
            A[j] = null;
            return;
        }

        int m= (i+j)/2;

        division(A, m+1, j, k);
        division(A, i, m, k);
    }

}

// test correctness
class Correctness {
    public static void main(String[] args) {
        Integer[] A = generator.reverseSortedIntegers(10);
        shifter.division(A, 0, 3, 6);
        System.out.println(Arrays.toString(A));
    }
}


// test efficiency
class Benchmark {

    public static void main(String[] args) {
        // Test different array sizes
        int[] sizes = {1000, 10000, 100000};
        
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

        // Benhcmark1
        Integer[] arr1 = arr.clone();
        long startTime = System.nanoTime();
        shifter.iteratively_improved(arr1, 0, arr.length/10, arr.length/10);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        
        // Benchmark2
        Integer[] arr2 = arr.clone();     
        long startTime2 = System.nanoTime();
        shifter.incremental(arr2, 0, arr.length/10, arr.length/10);
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / 1_000_000.0;
        

        // Benchmark
        Integer[] arr3 = arr.clone();     
        long startTime3 = System.nanoTime();
        shifter.division(arr3, 0, arr.length/10, arr.length/10);
        long endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3) / 1_000_000.0;


        System.out.printf("Array size: %d\n", arr.length);
        System.out.printf("Shift iteratively time: %.2f ms\n", duration);
        System.out.printf("Shift incrementally time: %.2f ms\n", duration2);
        System.out.printf("Shift by division : %.2f ms\n", duration3);
        System.out.println("--------------------");
    }

}
