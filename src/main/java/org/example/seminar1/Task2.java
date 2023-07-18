package org.example.seminar1;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(findSimpleNumbers(1000));
    }

    /**
     * Поиск простых чисел от 1 до lastNumber
     * простые числа делятся на себя и на 1
     * @param lastNumbers число
     * @return список простых чисел
     */
    public static List<Integer> findSimpleNumbers(int lastNumbers) {
        List<Integer> result = new ArrayList<>();
        boolean simple;
        for (int i = 1; i <= lastNumbers; i++) {
            simple = true;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }
}
