package org.example.seminar1;

public class Task3 {
    public static void main(String[] args) {
        System.out.print(combinationCount(6) + "\n");
        System.out.print(combinationCount(4,6) + "\n");
        System.out.print(countCombination(4, 6));
    }

    /**
     * Поиск комбинаций для 4х кубиков
     * @param faces количество граней в одном кубике
     * @return количество комбинаций
     */
    public static int combinationCount(int faces) {
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            for (int j = 1; j <= faces; j++) {
                for (int k = 1; k <= faces; k++) {
                    for (int l = 1; l <= faces; l++) {
                        count++;
                    }

                }

            }
        }
        return count;
    }

    /**
     * Поиск комбинаций для кубиков с заданными условиями
     * @param count количество кубиков
     * @param faces количество граней в одном кубике
     * @return количество комбинаций
     */
    public static int combinationCount(int count, int faces) {
        if (count > 0) {
            return recursiveCounter(1, count, faces);
        } else {
            return 0;
        }
    }

    /**
     * Поиск комбинаций с помощью рекурсии
     * сложный вариант
     * @param depth начальный кубик
     * @param maxDepth количество кубиков
     * @param faces количество граней
     * @return количество комбинаций
     */
    public static int recursiveCounter(int depth, int maxDepth, int faces){
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            if (depth == maxDepth) {
                count++;
            } else {
                count += recursiveCounter(depth + 1, maxDepth, faces);
            }
        }
        return count;
    }

    /**
     * Поиск комбинаций через рекурсию
     * базовый вариант
     * @param k количество кубиков
     * @param n количество граней
     * @return количество комбинаций
     */
    public static int countCombination(int k, int n){
        if (k == 1){
            return n;
        }
        int combinations = 0;
        for (int i = 1; i <= n; i++) {
            combinations += countCombination(k - 1, n);
        }
        return combinations;
    }
}

