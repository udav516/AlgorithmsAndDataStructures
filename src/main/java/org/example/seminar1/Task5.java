package org.example.seminar1;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(fb(6));
    }

    /**
     * Поиск числа Фибоначчи
     * @param num позиция числа
     * @return значение числа
     */
    public static int fb(int num) {
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
}
