package ru.job4j.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UnitsSort {
    public String[] sort(String[] units) {
        String[] result = fillMissing(Arrays.copyOf(units, units.length));
        Arrays.sort(result);
        return result;
    }

    public String[] sortDescending(String[] units) {
        String[] result = fillMissing(Arrays.copyOf(units, units.length));
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                String[] p1 = o1.split("\\\\");
                String[] p2 = o2.split("\\\\");
                String[] shorter = p1.length < p2.length ? p1 : p2;
                for (int i = 0; i < shorter.length; i++) {
                    result = -(p1[i].compareTo(p2[i]));
                    if (result != 0) {
                        break;
                    }
                }
                return result != 0 ? result : Integer.compare(p1.length, p2.length);
            }
        });
        return result;
    }

    private String[] fillMissing(String[] list) {
        List<String> result = new ArrayList<>(Arrays.asList(list));
        for (int i = 0; i < result.size(); i++) {
            String[] parts = result.get(i).split("\\\\");
            String unit = "";
            for (int j = 0; j < parts.length; j++) {
                unit += (j != 0 ? "\\" : "") + parts[j];
                if (!result.contains(unit)) {
                    result.add(unit);
                }
            }
        }
        return Arrays.copyOf(result.toArray(), result.toArray().length, String[].class);
    }
}
