package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        if (second > result) {
            result = second;
        } else if (third > result) {
            result = third;
        }
        return result;
    }
}