import java.util.Arrays;

// Improved mergesort - O(n) best case, already sorted array.
/*
    Merge sort is nlgn for the best case, i.e. when array is already sorted. 

    This is an attempt to improve this aspect by first checking whether a subproblem is already sorted. 
    If not, perform merge sort else use the sorted subproblem as it is. 
 */
public class mergesort2 {
    /* 
     */ 
    static <T extends Comparable<T>> void mergeSort(T[] A, int start, int end) {
        // base
        if (start == end) {
            return;
        }


        int mid = (start + end)/2;
        
        // subproblems - O(lgn) best; O(nlgn) worst
        if (!isSorted(A, start, mid)) mergeSort(A, start, mid);
        if (!isSorted(A, mid+1, end)) mergeSort(A, mid + 1, end);

        // merge - O(n)
        mergesort.merge(A, start, mid, end);
    }

    /*
        Approaches: 
            1. Scan - return false if A[i + 1] < A[i];  O(n)
            2. Incremental approach. T(n) = T(n-1) + O(1) = O(n)
            3. Divide conquer approach  T(n) = 2T(n/2) + O(1) = O(lgn)
        
        any of the above approach is better than nlgn for mergesort.
    */
    static <T extends Comparable<T>> boolean isSorted(T[] A, int start, int end) {
        if (start == end) return true;

        int mid = (start + end)/2;
        return isSorted(A, start, mid) && isSorted(A, mid + 1, end) && A[mid].compareTo(A[mid+1]) <= 0;
    }


    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        mergeSort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }


}
