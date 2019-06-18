package Lesson_3.Dequeue;

import org.junit.Assert;
import org.junit.Test;

public class TestDequeue {

    @Test
    public void test1() {
        DequeueImpl <Integer> dequeue = new DequeueImpl<>(5);
        dequeue.insert(1);
        dequeue.insert(2);
        dequeue.insert(3);
        dequeue.insert(4);
        dequeue.insert(5);

        //checking removeRight method
        dequeue.removeRight();
        Assert.assertEquals(4, dequeue.size);

        //checking insertLeft method
        dequeue.insertLeft(7);
        dequeue.remove();
        dequeue.remove();
        dequeue.remove();
        dequeue.remove();
        Assert.assertEquals(7, (int) dequeue.peek());

    }


}
