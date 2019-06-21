package Lesson_4;

import Lesson_3.Queue.Queue;
import Lesson_3.Stack.Stack;
import org.junit.Assert;
import org.junit.Test;

public class TestsLinkedLists {


    @Test
    public void testSimpleLinkedList() {
        LinkedList <Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);

        linkedList.display();

        Assert.assertTrue(linkedList.contains(4));
        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(5));
        Assert.assertFalse(linkedList.contains(6));

        Assert.assertEquals(5,(int)linkedList.removeFirst());
        Assert.assertTrue(linkedList.remove(3));
        Assert.assertFalse(linkedList.remove(5));
        linkedList.display();
    }

    @Test
    public void testTwoSideLinkedList() {
        TwoSideLinkedList <Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertLast(6);

        linkedList.display();

        Assert.assertTrue(linkedList.contains(4));
        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(5));
        Assert.assertFalse(linkedList.contains(7));

        Assert.assertEquals(5,(int)linkedList.removeFirst());
        Assert.assertTrue(linkedList.remove(3));
        Assert.assertFalse(linkedList.remove(5));
        linkedList.display();
    }

    @Test
    public void testLinkedStack() {
        Stack<Integer> stack = new LinkedStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);



        //checking peek method
        Assert.assertEquals(5, (int) stack.peek());

        //checking pop method
        stack.pop();
        Assert.assertEquals(4, (int) stack.peek());

        //checking push method
        stack.push(6);
        Assert.assertEquals(6, (int) stack.peek());
    }

    @Test

    public void testLinkedQueue() {
        Queue<Integer> queue = new LinkedQueueImpl<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

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
