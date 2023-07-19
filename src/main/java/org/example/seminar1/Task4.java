package org.example.seminar1;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(fb(6));
    }

    /**
     * Поиск числа Фибоначчи
     * @param num позиция искомого числа
     * @return значение найденного числа Фибоначчи
     */
    public static int fb(int num) {
        if (num <= 2) {
            return 1;
        } else {
            return fb(num - 1) + fb(num - 2);
        }
    }
}
