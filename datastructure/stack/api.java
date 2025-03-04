package datastructure.stack;

public interface api<E> {

    void push(E e);
    E pop();
    boolean isEmpty();
    boolean isFull();
    E top();
}
