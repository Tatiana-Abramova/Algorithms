package algo.task_04_dynamic_arrays;

import algo.task_04_dynamic_arrays.queue.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void queueTest() {
        PriorityQueue<String> queue = new PriorityQueue<>(6);
        queue.enqueue(1, "Test11");
        queue.enqueue(1, "Test12");
        queue.enqueue(2, "Test21");
        queue.enqueue(3, "Test31");
        queue.enqueue(3, "Test32");
        queue.enqueue(3, "Test33");
        queue.enqueue(5, "Test51");

        Assert.assertEquals("Test51", queue.dequeue());
        Assert.assertEquals("Test31", queue.dequeue());
        Assert.assertEquals("Test32", queue.dequeue());
        Assert.assertEquals("Test33", queue.dequeue());
        Assert.assertEquals("Test21", queue.dequeue());
        Assert.assertEquals("Test11", queue.dequeue());
        Assert.assertEquals("Test12", queue.dequeue());
    }
}
