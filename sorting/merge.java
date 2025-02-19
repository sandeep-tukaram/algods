import java.util.Arrays;

public class merge {

    // Design technique -> two-pointer approach.
    // Assumes A[start, mid] and A[mid + 1, end] are two contiguous sorted arrays.
    // O(n) time.
    // Left + Right array  = O(n) space.
    static <T extends Comparable<T>> void sortedArrays(T[] A, int start, int mid, int end) {
    
        // copy A[start, mid] into Left
        T[] Left = Arrays.copyOfRange(A, start, mid + 1);
    
        // copy A[mid + 1, end] into Right
        T[] Right = Arrays.copyOfRange(A, mid + 1, end + 1);
    
        int i = 0;
        int j = 0;
        int k = start;
        while (i < Left.length && j < Right.length) {
            if (Left[i].compareTo(Right[j]) <= 0) {
                A[k] = Left[i];
                i++;
            } else {
                A[k] = Right[j];
                j++;
            }
            k++;
        }
    
        while(i < Left.length) {
            A[k] = Left[i];
            k++;
            i++;
        }
    
        while (j < Right.length) {
            A[k] = Right[j];
            k++;
            j++;
        }
    }


    
}
