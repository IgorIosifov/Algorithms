package Lesson_3.Dequeue;

import Lesson_3.Queue.QueueImpl;

public class DequeueImpl<E> extends QueueImpl<E> implements Dequeue<E> {


    public DequeueImpl(int maxSize) {
        super(maxSize);
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (head - 1 < 0) {
            head = data.length;
        }

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }


    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail < 0) {
            tail = data.length - 1;
        }
        size--;
        return data[tail--];
    }
}



