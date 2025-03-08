package datastructure.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements api<E> {

    E[] arr; 
    int top = -1;

    ArrayStack(E[] ar) {
        this.arr = ar;
    }

    @Override
    public void push(E e) {
        if (isFull()) {
            throw new IndexOutOfBoundsException ("Stack full");
        }
        top++;
        arr[top] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        return arr[top + 1];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) throw new EmptyStackException();
        return arr[top];
    }


    // Array is preallocated and fixed size. Because of which, full() is a behavior exhibited
    //  by the array implementation of the list.
    public boolean isFull() {
        return top == arr.length - 1;
    }

}
