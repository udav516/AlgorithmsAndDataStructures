package org.example.seminar1;

public class Task1 {
    public static void main(String[] args) {
        System.out.print(sum(3));
    }

    /**
     * Сумма чисел от 1 до lastNumber
     * @param lastNumber число
     * @return сумма
     */
    public static int sum(int lastNumber) {
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++) {
            sum += i;
        }
        return sum;
    }
}
