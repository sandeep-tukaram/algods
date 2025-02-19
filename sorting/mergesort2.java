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
    static <T extends Comparable<T>> void sort(T[] A, int start, int end) {
        // base
        if (start == end) {
            return;
        }


        int mid = (start + end)/2;
        
        // subproblems - O(lgn) best; O(nlgn) worst
        if (!is_sorted.dividecheck(A, start, mid)) sort(A, start, mid);
        if (!is_sorted.dividecheck(A, mid+1, end)) sort(A, mid + 1, end);

        merge.sortedArrays(A, start, mid, end);
    }

    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        sort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }
}
