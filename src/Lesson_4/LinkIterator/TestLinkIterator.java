package Lesson_4.LinkIterator;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkIterator {

    @Test
    public void test () {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);


        itr.insertAfter("Artem", 20);
        Assert.assertEquals("Artem", list.getFirst().name);
        itr.insertBefore("Sergey", 10);
        Assert.assertEquals("Sergey", list.getFirst().name);
        itr.deleteCurrent();
        Assert.assertEquals("Artem", list.getFirst().name);
        list.display();
    }

}
