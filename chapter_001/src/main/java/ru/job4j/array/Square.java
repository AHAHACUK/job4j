package ru.job4j.array;

public class Square {
    /**
     * Метод заполняет массив квадратами чисел от 1 до определенного числа
     * @param bound Граница чисел, возводимых в квадарт
     * @return Массив с квадаратами чисел
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}