package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int shorter = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < shorter; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}