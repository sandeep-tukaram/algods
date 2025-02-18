import java.util.Arrays;

public class insertionsort {

    /* 
        Design technique - incremntal splitting.
            Incrementally split an input into subproblem. Reuse the solution to the subproblem.
        
        This is a recursive approach. Recursion equation 
        T(n) = T(n-1)               //  incrementallySort(A, n - 1);
                    + O(n);         //  while (..) {} 

        T(n) = O(n^2);
     */ 
    static <T extends Comparable<T>> void incrementallySort(T[] A, int n) {
        // base
        if (n == 0) {
            return;
        }

        // recursive
        incrementallySort(A, n - 1);
        int i = n - 1;
        T key = A[n];
        while (i >= 0 && A[i].compareTo(key) > 0) {
            A[i + 1] = A[i]; 
            i--;
        }
        A[i + 1] = key;
    }

    public static void main(String[] args) {
        Integer[] A = {2, 3, 1, 4};
        incrementallySort(A, A.length - 1);        // O(n^2), in-place
        System.out.println(Arrays.toString(A));
    }
}
