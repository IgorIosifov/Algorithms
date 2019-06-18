package Lesson_3.Stack;

public interface Stack<E> {


    void push(E value);

    E pop();

    E peek();

    int size();

    boolean isEmpty();

    boolean isFull();


}
