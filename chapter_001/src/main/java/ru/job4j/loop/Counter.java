package ru.job4j.loop;

public class Counter {
    public static int add(int start, int finish) {
        int sum = 0;
        for (;start<=finish;start++) {
            if (start%2==0) {
                sum += start;
            }
        }
        return sum;
    }
}