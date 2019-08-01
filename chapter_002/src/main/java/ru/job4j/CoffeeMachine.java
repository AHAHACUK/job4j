package ru.job4j;

import java.util.Arrays;

public class CoffeeMachine {

    private final int[] coins = new int[] {10, 5, 2, 1};

    public int[] change(int value, int price) {
        int position = 0;
        int changeValue = value - price;
        if (changeValue <= 0) {
            return new int[0];
        }
        int[] change = new int[changeValue];
        for (int i = 0; i < coins.length; i++) {
            while (changeValue / coins[i] > 0) {
                changeValue %= coins[i];
                change[position++] = coins[i];
            }
        }
        return Arrays.copyOf(change, position);
    }
}
