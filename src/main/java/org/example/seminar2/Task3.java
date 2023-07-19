package org.example.seminar2;

import java.util.Date;

public class Task3 {

    /**
     * Сортировка вставками
     * @param array неотсортированный массив
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Быстрая сортировка
     * @param array         неотсортированный массив
     * @param startPosition начальная позиция диапазона
     * @param endPosition   конечная позиция диапазона
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i = i + 10000) {
            int[] array = new int[i];
            for (int j = 0; j < args.length; j++) {
                array[j] = (int) (Math.random() * 10000);
            }
            int[] array2 = array;
            Date startDate = new Date();
            insertSort(array);
            Date endDate = new Date();
            long insertSort = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            quickSort(array2, 0, array.length - 1);
            endDate = new Date();
            long quickSort = endDate.getTime() - startDate.getTime();
            System.out.println("i: " + i + ", insertSort duration: " + insertSort + ", quickSort duration: " + quickSort);
        }
    }
}
