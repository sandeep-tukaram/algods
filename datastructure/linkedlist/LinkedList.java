package datastructure.linkedlist;

public class LinkedList<T> {
    Edge<Node<T>> head = new Edge<>();      // single pointer implementation
    int size = 0;

    // O(1)
    boolean isEmpty() {
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

    // O(1)
    void deleteHead() {
        if (isEmpty()) return;
        head.pointsTo = head.pointsTo.next;
        size--;
    }

    // O(n)
    void deleteTail() {
        Node<T> curr = head.pointsTo;

        if (isEmpty()) return;

        Node<T> prev = head.pointsTo;

        //locate tail O(n)
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        size--;
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
            e.val = count;
            ll.append(e);
            count++;
        }

        assert ll.size == 1: "error";
        System.out.println(ll.size);
    }
}
