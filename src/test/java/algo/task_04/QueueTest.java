package algo.task_04;

import algo.task_04.queue.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void queueTest() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Test1");
        queue.enqueue("Test2");
        queue.enqueue("Test3");

        Assert.assertEquals("Test1", queue.dequeue());
        Assert.assertEquals("Test2", queue.dequeue());
        Assert.assertEquals("Test3", queue.dequeue());
    }

    @Test
    public void isEmptyTest() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Test1");
        Assert.assertFalse(queue.isEmpty());

        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }
}
