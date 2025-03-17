package problems.sorting;

public class is_sorted {


    // Divide conquer approach  
    // T(n) = 2T(n/2) + O(1) = O(lgn)
    static <T extends Comparable<T>> boolean dividecheck(T[] A, int start, int end) {
        if (start == end) return true;
    
        int mid = (start + end)/2;
        return dividecheck(A, start, mid) && dividecheck(A, mid + 1, end) && A[mid].compareTo(A[mid+1]) <= 0;
    }

    // Iterative scan - O(n)
    static <T extends Comparable<T>> boolean scancheck(T[] A, int start, int end) {
        if (start == end) return true;
        for (int i = start ; i < end; i++) {
            if (A[i + 1].compareTo(A[i]) < 0) return false;
        }
        return true;
    }
    
    // Incremental approach. Recursive scan.
    //T(n) = T(n-1) + O(1) = O(n)
    static <T extends Comparable<T>> boolean incrementallycheck(T[] A, int start, int end) {
        if (start == end) return true;
    
        // return incrementally(A, start + 1, end) && A[start].compareTo(A[start+1]) <= 0;
        return A[start].compareTo(A[start+1]) <= 0 && incrementallycheck(A, start + 1, end);
    }
}
