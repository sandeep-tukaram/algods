package datastructure.stack;

import datastructure.linkedlist.LinkedList;

public class LLStack<E> implements api<E> {

    private LinkedList<E> ll = new LinkedList<>();

    // top at head. O(1)
    @Override
    public void push(E e) {
        ll.prepend(e);
    }

    // O(1)
    @Override
    public E pop() {
        return ll.deleteHead();
    }


    // O(1)
    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    // Dynamic node allocation. Unlike array implementation there is no concept of maximum.
    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    // O(1)
    @Override
    public E top() {
        E e = ll.deleteHead();
        ll.prepend(e);
        return e;
    }
}
