package ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Ex2_1 {
    public static void main(String[] args) throws Exception {
        int size = 100000;
        int min = 0;
        int max = 100;
        Date date = new Date();
        int[] array = Ex1.getRandomArr(size, min, max);
        long start = new Date().getTime();
     //   Ex1.bubbleSort(array.clone());
        long end = new Date().getTime();
        System.out.println(end-start);
        long start2 = new Date().getTime();
        quickSort(array.clone());
        long end2 = new Date().getTime();
        System.out.println(end2-start2);
        long start3 = new Date().getTime();
        Arrays.sort(array);
        long end3 = new Date().getTime();
        System.out.println(end3-start3);



    }

    /**
     * apiNote Перегрузка быстрой сортировки
     *
     * @param array - исходный массив
     */

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);

    }

    /**
     * apiNote Метод реализующий быструю сортировку, принимающий на вход три аргумента
     *
     * @param array         - исходный массив
     * @param startPosition - начало массива
     * @param endPosition   - конец массива
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int pivot = array[(startPosition + endPosition) / 2];
        int i = startPosition, j = endPosition;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;

            }
        }
        if (i < endPosition) {
            quickSort(array, i, endPosition);
        }
        if (j > startPosition) {
            quickSort(array, startPosition, j);
        }
    }
}


