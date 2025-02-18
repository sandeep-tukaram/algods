import java.util.Random;

public class MergeSortBenchmark {
    public static void main(String[] args) {
        // Test different array sizes
        int[] sizes = {1000, 10000, 100000, 1000000};
        
        System.out.println("\n\n***** Testing for generated sorted array *****");
        for (int size : sizes) {
            // Generate random array
            Integer[] arr = generateSortedArray(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for randomly generated array *****");
        for (int size : sizes) {
            // Generate random array
            Integer[] arr = generateRandomArray(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for generated reverse sorted array *****");
        for (int size : sizes) {
            // Generate random array
            Integer[] arr = generateReverseSortedArray(size);
            test(arr);
        }
    }

    private static void test(Integer[] arr) {
                    // Benchmark mergesort
                    long startTime = System.nanoTime();
                    mergesort.mergeSort(arr.clone(), 0, arr.length-1);
                    long endTime = System.nanoTime();
                    
                    // Convert to milliseconds for readability
                    double duration = (endTime - startTime) / 1_000_000.0;
                    
                    // Benchmark Java's built-in sort for comparison
                    long startTime2 = System.nanoTime();
                    mergesort2.mergeSort(arr.clone(), 0, arr.length-1);
                    long endTime2 = System.nanoTime();
                    double duration2 = (endTime2 - startTime2) / 1_000_000.0;
                    
                    System.out.printf("Array size: %d\n", arr.length);
                    System.out.printf("MergeSort time: %.2f ms\n", duration);
                    System.out.printf("MergeSort2 time: %.2f ms\n", duration2);
                    System.out.println("--------------------");
    }
    
    private static Integer[] generateRandomArray(int size) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }


    private static Integer[] generateSortedArray(int size) {
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = i+1;
        }
        return arr;
    }


    private static Integer[] generateReverseSortedArray(int size) {
        Integer[] arr = new Integer[size];
        for (Integer i = 0; i < size; i++) {
            arr[i] = size-i;
        }
        return arr;
    }
}