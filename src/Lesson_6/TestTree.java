package Lesson_6;

import org.junit.Assert;
import org.junit.Test;

public class TestTree {


    @Test
    public void test1() {

        Tree<Integer> tree = new TreeImpl<>(4);
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);
        Assert.assertTrue(tree.find(60));
        Assert.assertTrue(tree.find(70));
        Assert.assertTrue(tree.find(31));
        Assert.assertFalse(tree.find(555));
        tree.traverse(Tree.TraverseMode.IN_ORDER);
    }
    @Test
    public void test2() {

        Tree<Integer> tree = new TreeImpl<>(4);
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);
        tree.display();

        tree.remove(5);
        tree.display();
//        tree.remove(30);
//        tree.display();
        tree.remove(25);
        tree.display();
    }
}
