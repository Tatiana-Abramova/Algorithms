package algo.task_04_dynamic_arrays.queue;

public class Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            tail = head = new Node<>(item);
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
