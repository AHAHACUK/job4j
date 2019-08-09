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
