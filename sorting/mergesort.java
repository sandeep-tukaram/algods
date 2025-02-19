import java.util.Arrays;

public class mergesort {
        /* 
        Design technique -  split by division.
            Divide an input into two equally sized subproblems. Reuse their solutions.
            Also popularly known as Divide and Conquer.
        
        This is a recursive approach. Recursion equation 
        T(n) = 2T(n/2)               //  mergeSort(A, start, mid) and mergeSort(A, mid + 1, end)
                    + O(n);          //  merge(A, start, mid, end); 

        T(n) = O(nlgn);
     */ 
    static <T extends Comparable<T>> void sort(T[] A, int start, int end) {
        // base
        if (start == end) {
            return;
        }


        int mid = (start + end)/2;
        
        // subproblems
        sort(A, start, mid);
        sort(A, mid + 1, end);

        merge.sortedArrays(A, start, mid, end);
    }


    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        sort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }

}
