import java.util.Arrays;

/*
 * Optimizes for already sorted array O(n) compared to quicksort O(n^2).
 */
public class quicksort2 {
    static <T extends Comparable<T>> void sort(T[] A, int start, int end) {
        if (start < end) {
            int k = partition.byEndKey(A, start, end);  
            if (!is_sorted.scancheck(A, 0, k-1)) sort(A, 0, k-1);
            if (!is_sorted.scancheck(A, k+1, end)) sort(A, k+1, end);   
        }
    }

    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        sort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }
}
