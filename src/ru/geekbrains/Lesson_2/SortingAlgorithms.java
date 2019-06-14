package ru.geekbrains.Lesson_2;

import java.util.Arrays;

public class SortingAlgorithms {

    private static int ARRAY_SIZE = 10000;
    private static int[] testArray = new int[ARRAY_SIZE];

    public static void main(String[] args) {

        arrayRandomFilling();
        int[] bubbleArray = Arrays.copyOf(testArray, ARRAY_SIZE);
        int[] selectArray = Arrays.copyOf(testArray, ARRAY_SIZE);
        int[] insertArray = Arrays.copyOf(testArray, ARRAY_SIZE);
        sortBubble(bubbleArray);
        sortSelect(selectArray);
        sortInsert(insertArray);

    }

    private static void arrayRandomFilling() {
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * Math.random() * Math.random() * ARRAY_SIZE);
        }
    }

    private static void sortBubble(int[] bubbleArray) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            for (int j = 0; j < ARRAY_SIZE - 1; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    swap(j, j + 1, bubbleArray);
                }
            }
        }
        System.out.println("sortBubble have finished in: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void sortSelect(int[] selectArray) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ARRAY_SIZE; j++) {
                if (selectArray[j] < selectArray[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, selectArray);
        }
        System.out.println("sortSelect have finished in: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void sortInsert(int[] insertArray) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int temp = insertArray[i];
            int index = i;
            while (index > 0 && insertArray[index - 1] >= temp) {
                insertArray[index] = insertArray[index - 1];
                index--;
            }
            insertArray[index] = temp;
        }
        System.out.println("sortInsert have finished in: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void swap(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

