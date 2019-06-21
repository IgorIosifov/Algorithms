package Lesson_4.LinkedLists;

import Lesson_3.Queue.Queue;


public class LinkedQueueImpl<E> implements Queue<E> {

    private TwoSideLinkedList <E> data = new TwoSideLinkedListImpl<>();

    @Override
    public boolean insert(E value) {
         data.insertLast(value);
         return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
