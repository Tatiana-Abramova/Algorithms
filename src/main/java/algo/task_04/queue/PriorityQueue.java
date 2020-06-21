package algo.task_04.queue;

public class PriorityQueue<T> {
    private Queue<T>[] array;

    public PriorityQueue(int prioritiesNum) {
        array = new Queue[prioritiesNum];
    }

    public void enqueue(int priority, T item) {
        if (array.length - 1 < priority) {
            throw new IllegalArgumentException("No such priority: " + priority);
        } else if (array[priority] == null) {
            Queue<T> queue = new Queue<>();
            queue.enqueue(item);
            array[priority] = queue;
        } else {
            array[priority].enqueue(item);
        }
    }

    public T dequeue() {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null && !array[i].isEmpty()) {
                return array[i].dequeue();
            }
        }
        return null;
    }
}
