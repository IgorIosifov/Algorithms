package Lesson_3;

public class QueueImpl <E> implements Queue<E> {
    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;
    private E[] data;

    private int size;

    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
        
    }

    @Override
    public boolean insert(E value) {

        if (isFull()){
            return false;
        }
        if(tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    private int lastIndex() {
        return data.length-1;
    }

    @Override
    public E remove() {
        if (isEmpty()){
            return null;
        }
        if (head == data.length){
            head = DEFAULT_HEAD;
        }
        E removedValue = data[head++];
        size--;
        return removedValue;
    }

    @Override
    public E peek() {
        return data [head];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
