package ru.job4j.array;

public class Sort {

    public int[] merge(int[] a, int[] b) {
        int[] small = a.length < b.length ? a : b;
        int[] big = a.length < b.length ? b : a;
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < small.length; i++) {
            if (small[i] < big[i]) {
                result[i * 2] = small[i];
                result[i * 2 + 1] = big[i];
            } else {
                result[i * 2] = big[i];
                result[i * 2 + 1] = small[i];
            }
        }
        for (int i = 0; i < big.length - small.length; i++) {
            result[small.length * 2 + i] = big[small.length + i];
        }
        return result;
    }
}
