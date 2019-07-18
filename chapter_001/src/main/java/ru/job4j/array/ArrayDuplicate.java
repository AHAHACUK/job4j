package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length-count; i++) {
            for (int j = i+1; j < array.length-count; j++) {
                if (array[i].equals(array[j])) {
                    String temp = array[j];
                    array[j] = array[array.length-1-count];
                    array[array.length-1-count] = temp;
                    count++;
                }
            }
        }
        return Arrays.copyOf(array,array.length-count);
    }
}
