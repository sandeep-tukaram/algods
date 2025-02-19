import java.util.Arrays;

public class quicksort {

    static <T extends Comparable<T>> void sort(T[] A, int start, int end) {
        if (start < end) {
            int k = partition.endkey (A, start, end);  
            sort(A, 0, k-1);
            sort(A, k+1, end);    
        }
    }

    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        sort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }


}
