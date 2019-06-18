package Lesson_3.Dequeue;

import Lesson_3.Queue.QueueImpl;

public class DequeueImpl<E> extends QueueImpl<E> implements Dequeue<E>{
    private static final int DEFAULT_TAIL = -1;


    public DequeueImpl(int maxSize) {
        super(maxSize);
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        data[++tail] = value;
        size++;
        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }

        return true;
    }


    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail == size) {
            tail = DEFAULT_TAIL;
        }
        E removedValue = data[tail--];
        size--;
        return removedValue;
    }
}



