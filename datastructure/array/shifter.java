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
            // shift right
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
            A[j + k] = A[j];
            A[j] = null;
            return;
        }

        incremental(A, i+1, j, k);
        A[i + k] = A[i];
        A[i] = null;
    }


    // division recursion
    // T(n) = 2T(n/2)  = O(n)
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
        Integer[] A = generator.reverseSortedIntegers(10);
        iteratively_improved(A, 0, 4, 3);
        System.out.println(Arrays.toString(A));
    }
}
