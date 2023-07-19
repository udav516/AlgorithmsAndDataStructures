package org.example.seminar2;

public class Task5 {
    /**
     * Пирамидальная сортировка(сортировка кучей)
     * @param array неотсортированный массив
     */
    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    /**
     *Реализация двоичной кучи
     * @param array неотсортированный массив
     * @param heapSize размер пирамиды(кучи)
     * @param rootIndex индекс корневого элемента поддерева для кучи
     */
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            heapify(array, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 11, 13, 5, 6, 7, 3};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
