package Lesson_3.Stack;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestStack {

    @Test
    public void test1() {
        StackImpl<Integer> stack = new StackImpl<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //checking out of bounds exception
        exception.expect(ArrayIndexOutOfBoundsException.class);
        stack.push (6);

        //checking peek method
        Assert.assertEquals(5, (int) stack.peek());

        //checking pop method
        stack.pop();
        Assert.assertEquals(4, (int) stack.peek());

        //checking push method
        stack.push(6);
        Assert.assertEquals(6, (int) stack.peek());
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

}
