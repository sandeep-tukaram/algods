import java.util.Arrays;

public class mergesort {
        /* 
        Design technique -  split by division.
            Divide an input into two equally sized subproblems. Reuse their solutions.
        
        This is a recursive approach. Recursion equation 
        T(n) = 2T(n/2)               //  mergeSort(A, start, mid) and mergeSort(A, mid + 1, end)
                    + O(n);          //  merge(A, start, mid, end); 

        T(n) = O(nlgn);
     */ 
    static <T extends Comparable<T>> void mergeSort(T[] A, int start, int end) {
        // base
        if (start == end) {
            return;
        }


        int mid = (start + end)/2;
        
        // subproblems
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        // merge 
        merge(A, start, mid, end);
    }


    // A[start, mid] is sorted
    // A[mid + 1, end] is sorted
    // merge the two sorted arrays into A using two-pointer approach O(n) time and Left, Right array O(n) space
    static <T extends Comparable<T>> void merge(T[] A, int start, int mid, int end) {

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

    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        mergeSort(A, 0, A.length-1);            // O(nlgn), O(n) space
        System.out.println(Arrays.toString(A));
    }

}
