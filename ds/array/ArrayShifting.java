package ds.array;

import java.util.Arrays;

public class ArrayShifting {
    
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

    // incrementatl recursion   O(n)
    static <T> void incremental(T[] A, int i, int j, int k) {

        if (i == j) {
            A[j + k] = A[j];
            A[j] = null;
            return;
        }

        incremental(A, i+1, j, k);
        A[i + k] = A[i];
        A[i] = null;
    }


    // division recursion
    // T(n) = 2T(n/2)   O(lgn)
    static <T> void division(T[] A, int i, int j, int k) {

        if (i == j) {
            A[j + k] = A[j];
            A[j] = null;
            return;
        }

        int m= (i+j)/2;

        division(A, m+1, j, k);
        division(A, i, m, k);

    }

    public static void main(String[] args) {
        Integer[] A = arraygenerator.reverseSortedIntegers(10);
        division(A, 0, 4, 3);
        System.out.println(Arrays.toString(A));
    }
}
