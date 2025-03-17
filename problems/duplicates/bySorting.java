package problems.duplicates;

import java.util.Arrays;

import datastructure.array.generator;
import problems.sorting.quicksort;

public class bySorting {
    
    // T(n) = O(nlgn) + O(n) = O(nlgn) worst case
    // S(n) = O(1)
    static <T extends Comparable<T>>  boolean quicksort_check(T[] arr) {
        // T(n) = O(nlgn), S(n) = O(1)
        quicksort.sort(arr, 0, arr.length-1);

        // Scan O(n)
        for (int i =1; i< arr.length; i++) {
            if (arr[i] == arr[i-1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = generator.randomIntegers(10, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println(quicksort_check(arr));
    }

}
