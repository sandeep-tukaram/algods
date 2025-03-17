package datastructure.linkedlist;

public class LinkedList<T> {
    Pointer<Node<T>> head = new Pointer<>();      // single pointer implementation
    int size = 0;

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(n)
    void append(Node<T> e) {
        Node<T> curr = head.pointsTo;

        if (isEmpty()) {
            head.pointsTo = e;
            size++;
            return;
        }

        //locate tail O(n)
        while(curr.next != null) {
            curr = curr.next;
        }
        
        curr.next = e;
        size++;
    }

    // O(1)
    void prepend(Node<T> e) {
        Node<T> curr = head.pointsTo;
        head.pointsTo=e;
        e.next=curr;
        size++;
    }

    public void prepend(T e) {
        Node<T> n = new Node<>();
        n.key = e;
        prepend(n);
    }


    // O(1)
    public T deleteHead() {
        if (isEmpty()) return null;
        T e = head.pointsTo.key;
        head.pointsTo = head.pointsTo.next;
        size--;
        return e;
    }

    // O(n)
    public T deleteTail() {
        Node<T> curr = head.pointsTo;

        if (isEmpty()) return null;

        Node<T> prev = head.pointsTo;

        //locate tail O(n)
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        T e = curr.key;
        prev.next = null;
        size--;
        return e;
    }


}

class Correctness_LL {
    public static void main(String[] args) {
        testAppend();
    }

    static void testAppend() {
        LinkedList<Integer> ll = new LinkedList<>();
        int count = 0;
        while(count<10) {
            Node<Integer> e = new Node<>();
            e.key = count;
            ll.append(e);
            count++;
        }

        assert ll.size == 1: "error";
        System.out.println(ll.size);
    }
}
