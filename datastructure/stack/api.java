package datastructure.stack;

public interface api<E> {


    void push(E e);
    E pop();
    boolean isEmpty();
    E top();


    // NOTES - ideally a stack has no concept of full. Array implementation of it does. So full is implementation concept.
    // Because its a implementation concept, have commented out the method. Not deleted for reference purposes.
    // boolean isFull();    
}
