package Lesson_4.LinkedLists;

public interface LinkedList <E>{

    void insertFirst (E value);

    E removeFirst();

    boolean remove (E value);

    boolean contains (E value);

    boolean isEmpty();

    int size();

    void display();

    E getFirstElement();



}
