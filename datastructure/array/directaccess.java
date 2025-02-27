package datastructure.array;

public class directaccess<T> {

    T[] A; 

    // O(1)
    T get(int i) {
        return A[i];
    }

    // O(1)
    void set(int i, T e) {
        A[i] = e;
    }
    
}
