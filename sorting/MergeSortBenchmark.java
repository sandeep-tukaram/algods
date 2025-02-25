import ds.array.arraygenerator;

public class MergeSortBenchmark {
    public static void main(String[] args) {
        // Test different array sizes
        int[] sizes = {1000, 10000, 100000, 1000000};
        
        System.out.println("\n\n***** Testing for generated sorted array *****");
        for (int size : sizes) {
            Integer[] arr = arraygenerator.sortedIntegers(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for randomly generated array *****");
        for (int size : sizes) {
            Integer[] arr = arraygenerator.randomIntegers(size);
            test(arr);
        }

        System.out.println("\n\n***** Testing for generated reverse sorted array *****");
        for (int size : sizes) {
            Integer[] arr = arraygenerator.reverseSortedIntegers(size);
            test(arr);
        }
    }

    private static void test(Integer[] arr) {
        // Benchmark mergesort
        Integer[] arr1 = arr.clone();
        long startTime = System.nanoTime();
        mergesort.sort(arr1, 0, arr.length-1);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        
        // Benchmark mergesort2
        Integer[] arr2 = arr.clone();     
        long startTime2 = System.nanoTime();
        mergesort2.sort(arr2, 0, arr.length-1);
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / 1_000_000.0;
        

        // Benchmark quicksort
        Integer[] arr3 = arr.clone();     
        long startTime3 = System.nanoTime();
        mergesort2.sort(arr3, 0, arr.length-1);
        long endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3) / 1_000_000.0;

        // Benchmark quicksort
        Integer[] arr4 = arr.clone();     
        long startTime4 = System.nanoTime();
        mergesort2.sort(arr4, 0, arr.length-1);
        long endTime4 = System.nanoTime();
        double duration4 = (endTime4 - startTime4) / 1_000_000.0;



        // Benchmarking insertionsort using recursion throws Stackoverflow error.

        System.out.printf("Array size: %d\n", arr.length);
        System.out.printf("MergeSort time: %.2f ms\n", duration);
        System.out.printf("MergeSort2 time: %.2f ms\n", duration2);
        System.out.printf("quicksort time: %.2f ms\n", duration3);
        System.out.printf("quicksort2 time: %.2f ms\n", duration4);
        System.out.println("--------------------");
    }
}