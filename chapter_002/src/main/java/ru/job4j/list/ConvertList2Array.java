package ru.job4j.list;

import java.util.ArrayList;
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

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] i : list) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }
}