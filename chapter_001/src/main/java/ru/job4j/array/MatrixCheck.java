package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int len = data.length;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][len - i - 1] != data[i + 1][len - i - 2]) {
                result = false;
                break;
            }
        }
        return result;
    }
}