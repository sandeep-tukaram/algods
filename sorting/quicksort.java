import java.util.Arrays;

public class quicksort {

    static <T extends Comparable<T>> void sort(T[] A, int start, int end) {
        if (start < end) {
            int k = partition (A, start, end);  
            sort(A, 0, k-1);
            sort(A, k+1, end);    
        }
    }

    // Design technique -> two pointer, one pivot.
    static <T extends Comparable<T>> int partition(T[] A, int start, int end) {
        // pivot
        T key = A[end];

        // pointer1 represents elements < key
        int i = start - 1;

        // pointer2 represents elements > key
        int j =  start;
        while (j < end) {
            if (A[j].compareTo(key) <= 0) {
                i++;
                
                //swap A[i] with A[j]
                T temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
            j++;
        }

        // swap A[i+1] and A[end]
        A[end] = A[i+1];
        A[i+ 1] = key;
        return i + 1;
    }


    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        sort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }


}
