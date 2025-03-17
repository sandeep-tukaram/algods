package problems.duplicates;

import java.util.Arrays;

import datastructure.array.generator;

public class byDivision {

    // T(n) = 2 T(n/2) + O((n/2)^2) = O(n^2) worst case
    // S(n) = O(1)
    static <T> boolean check(T[] arr, int i, int j) {
        // base
        if (i == j) return false;

        // division  (i,j) -> (i,m) and (m+1, j)
        int m = (i+j)/2;
        if(check(arr, i, m) || check(arr, m+1, j)) return true;

        // check duplicates across the two subproblems.
        // O((n/2)^2) = O(n^2) assuming j-i = n;
        while(i <= m ) {
            int k = m+1;
            while(k <= j) {
                if (arr[i] == arr[k]) return true;
                k++;
            }
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = generator.randomIntegers(10, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println(check(arr, 0, arr.length-1));
    }

}
