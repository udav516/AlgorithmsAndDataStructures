package org.example.seminar2;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(find(array, 4));
        System.out.println(binarySearch(array, 4, 0, array.length - 1));
    }

    /**
     * Простой поиск перебором
     * @param array заданный массив
     * @param value искомое число
     * @return индекс искомого числа
     */
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Бинарный поиск
     * @param array заданный массив
     * @param value искомое число
     * @param min минимальный диапозон поиска
     * @param max максимальный диапозон поиска
     * @return индекс искомого числа
     */
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        } else if (array[midpoint] > value) {
            return binarySearch(array, value, min, midpoint - 1);
        } else {
            return midpoint;
        }
    }
}
