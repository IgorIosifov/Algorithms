package ru.geekbrains.Lesson_2;

import java.util.Arrays;

public class ArrayListAnalog<E> implements AnalogInterface<E> {

    private static final int INITIAL_CAPACITY = 16;

    private E[] data;
    private int size;

    public ArrayListAnalog() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayListAnalog(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkGrow();
        data[size++] = value;
    }

    private void checkGrow() {
        if (size == data.length) {
            data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new InvalidArrayStateException(index, size);
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayListAnalog<Integer> array = new ArrayListAnalog<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(7);

        array.display();

        System.out.println("Size is:" + array.size());
        System.out.println(array.contains(1));
        System.out.println("Find index of 7:" + array.indexOf(7));
        array.remove(7);

        array.display();
    }
}
