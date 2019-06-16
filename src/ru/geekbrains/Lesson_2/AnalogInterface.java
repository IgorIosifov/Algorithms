package ru.geekbrains.Lesson_2;

public interface AnalogInterface<E> {

    void add(E value);

    E get(int index);

    boolean remove(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int indexOf(E value);

    int size();

    boolean isEmpty();

}
