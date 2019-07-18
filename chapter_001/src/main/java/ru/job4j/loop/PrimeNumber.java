package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int numToCheck = finish; numToCheck > 1; numToCheck--) {
            boolean isPrime = true;
            for (int divider = 2; divider < numToCheck; divider++) {
                if (numToCheck % divider == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }
}