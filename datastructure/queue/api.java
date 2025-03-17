package datastructure.queue;

public interface api<E> {    
    void enqueue(E e);
    E dequeue();
    boolean empty();

    // NOTES - ideally a queue has no concept of full. Array implementation fills up but not LinkedList.
    // So full() is and implementation concept.  
    // Not deleted for reference purposes.
    // boolean isFull();    
}
