package org.example.seminar1;

import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        test();
    }

    /**
     * Линейная сложность поиска числа Фибоначчи
     * @param num позиция числа
     * @return значение числа
     */
    public static int fbLine(int num) {
        if (num <= 2) {
            return 1;
        } else {
            final int[] numbers = new int[num];
            numbers[0] = 1;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[num - 1];
        }
    }

    /**
     * Экспоненциальная сложность поиска числа Фибоначчи
     * @param num позиция числа
     * @return значение числа
     */
    public static int fbRecursive(int num) {
        if (num <= 2) {
            return 1;
        } else {
            return fbRecursive(num - 1) + fbRecursive(num - 2);
        }
    }

    /**
     * Сравнение скорости работы двух алгоритмов Фибоначчи
     */
    public static void test() {
        for (int i = 10; i <= 100; i = i+ 10) {
            Date startDate = new Date();
            fbLine(i);
            Date endDate = new Date();
            long lineDuration = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            fbRecursive(i);
            endDate = new Date();
            long recursiveDuration = endDate.getTime() - startDate.getTime();
            System.out.println("i: " + i + ", line duration: " + lineDuration + ", recursive duration: " + recursiveDuration);
        }
    }
}
