package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int pos = 0;
        for (int i : list) {
            array[pos / rows][pos % rows] = i;
            pos++;
        }
        return array;
    }
}