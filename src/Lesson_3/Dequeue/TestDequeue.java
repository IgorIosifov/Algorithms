package Lesson_3.Dequeue;

import org.junit.Assert;
import org.junit.Test;

public class TestDequeue {

    @Test
    public void test1() {
        DequeueImpl <Integer> dequeue = new DequeueImpl<>(5);
        dequeue.insertRight(1);
        dequeue.insertRight(2);
        dequeue.insertRight(3);
        dequeue.insertRight(4);
        dequeue.insertRight(5);

        //checking removeRight method
        dequeue.removeRight();
        Assert.assertEquals(4, dequeue.size);


        //checking insertLeft method
        dequeue.removeLeft();
        dequeue.insertLeft(7);
        Assert.assertEquals(7, (int) dequeue.peek());

    }


}
