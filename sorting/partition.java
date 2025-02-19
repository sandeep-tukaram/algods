public class partition {

    // Design technique -> two pointer, one pivot.
    // O(n)
    static <T extends Comparable<T>> int byEndKey(T[] A, int start, int end) {
        // pivot
        T key = A[end];
    
        // pointer 1
        // 0..i represents partition i
        // where each element in the partition is < key.
        int i = start - 1;
    
    
        // pointer2 
        // i+1 .. j represents partition j
        // where each element in the partition is < key.
        int j =  start;
    
        // linear scan. O(n)
        while (j < end) {
            if (A[j].compareTo(key) <= 0) {
                //A[j] is less than key, hence belongs to partition i 
                // and not partition j
                i++;
                T temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
            j++;
        }
    
        // place key at i+1, it's right position in a sorted order.
        // for each m < i+1, A[m] < key, and
        // for each m > i+1, A[m] > key.
        A[end] = A[i+1];
        A[i+ 1] = key;
        return i + 1;
    }
    
}
