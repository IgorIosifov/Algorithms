package Lesson_5;

import org.junit.Assert;
import org.junit.Test;

public class TestsLesson5 {

    @Test
    public void testRecursion() {
        ExponentiationRec exponentiationRec = new ExponentiationRec();
        Assert.assertEquals(1 / 32f, exponentiationRec.exponentiationRec(2, -5), 0.001);
        Assert.assertEquals(1f, exponentiationRec.exponentiationRec(2, 0), 0.001);
        Assert.assertEquals(32f, exponentiationRec.exponentiationRec(2, 5), 0.001);

    }

}
