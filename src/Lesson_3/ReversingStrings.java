package Lesson_3;

import Lesson_3.Stack.StackImpl;

public class ReversingStrings {


    public static void main(String[] args) {
        System.out.println(reverse("Hello, world!"));
    }

    private static StringBuilder reverse (String source) {

        StackImpl<Character> sourceStack = new StackImpl<>(source.length());
        StringBuilder target = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            sourceStack.push(source.charAt(i));
        }
        for (int i = 0; i < source.length(); i++) {
            target.append(sourceStack.pop());

        }
        return target;
    }

}
