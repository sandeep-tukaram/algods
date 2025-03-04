package datastructure.stack;

public interface api<E> {


    void push(E e);
    E pop();
    boolean isEmpty();
    boolean isFull();    // TODO Full() is implementation limitation should be transparent to the Client actually. 
    E top();
}
