package Lesson_3.Queue;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {

    @Test

    public void test1() {
        QueueImpl<Integer> queue = new QueueImpl<>(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);


        //checking incorrect insert
        Assert.assertFalse(queue.insert(6));

        //checking remove method
        queue.remove();
        Assert.assertEquals(2,(int)queue.peek());

        //checking insert method
        queue.insert(6);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        Assert.assertEquals(6, (int) queue.peek());

    }


    }


