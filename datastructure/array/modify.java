package datastructure.array;

import java.util.Arrays;

public class modify<T> {

    T[] A; 

    void insert(T e, int i) {
        shifter.division(A, i, 1);  // O(n)
        A[i] = e;
    }

    void delet(int i) {
        shifter.division(A, i, -1);     // O(n)
    }
}

class Correctness_API {
    public static void main(String[] args) {
        modify<Integer> a1 = new modify<Integer>();
        a1.A = generator.reverseSortedIntegers(10);
        a1.insert(1, 3);
        System.out.println(Arrays.toString(a1.A));

        a1.delet(0);
        System.out.println(Arrays.toString(a1.A));
    }
}
 
