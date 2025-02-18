import java.util.Arrays;

// Improved mergesort - O(n) best case, already sorted array.
public class mergesort2 {
    /* 
        Merge sort is nlgn for best case, i.e. when array is already sorted. 
        This is an attempt to improve this aspect by first checking whether a 
        subproblem is already sorted and if not perform merge sort else use it as it is.
     */ 
    static <T extends Comparable<T>> void mergeSort(T[] A, int start, int end) {
        // base
        if (start == end) {
            return;
        }


        int mid = (start + end)/2;
        
        // subproblems
        if (!isSorted(A, start, mid)) mergeSort(A, start, mid);
        if (!isSorted(A, mid+1, end)) mergeSort(A, mid + 1, end);

        // merge 
        merge(A, start, mid, end);
    }

    /*
        Approaches: 
            1. Scan - return false if A[i + 1] < A[i];  O(n)
            2. Incremental approach. T(n) = T(n-1) + O(1) = O(n)
            3. Divide conquer approach  T(n) = 2T(n/2) + O(1) = O(lgn)
        
        any of the approach is less than nlgn requied for mergeSort.
    */
    static <T extends Comparable<T>> boolean isSorted(T[] A, int start, int end) {
        if (start == end) return true;

        int mid = (start + end)/2;
        return isSorted(A, start, mid) && isSorted(A, mid + 1, end) && A[mid].compareTo(A[mid+1]) <= 0;
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
