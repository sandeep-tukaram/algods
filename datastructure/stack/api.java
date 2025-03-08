package datastructure.stack;

public interface api<E> {


    void push(E e);
    E pop();
    boolean isEmpty();
    // boolean isFull();    // ideally a stack has no concept of full. Array implementation of it does. So full is implementation concept.
    E top();
}
