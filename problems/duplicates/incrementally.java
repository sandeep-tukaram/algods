package problems.duplicates;

import java.util.Arrays;

import datastructure.array.generator;

public class incrementally {

    // T(n) = T(n-1) + O(n) = O(n^2) quadratic worst case 
    // S(n) = O(1), constant space.
    static <T> boolean check(T[] arr, int n) {
        // base
        if (n == 0) return false;

        // recursive
        if(check(arr, n-1)) return true;

        // check whether the nth element is a duplicate
        for (int k = n-1; k >= 0; k--) {
            if (arr[k] == arr[n]) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Integer[] arr = generator.randomIntegers(10, 20);
        System.out.println(Arrays.toString(arr));
        System.out.println(check(arr, arr.length-1));
    }

}
