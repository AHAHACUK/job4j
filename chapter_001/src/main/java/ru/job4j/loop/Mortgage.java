package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int months = 0;
        for (;amount>0;amount-=monthly) {
            amount*=1.00+percent/100;
            months++;
        }
        return (int)Math.ceil((double)months/12);
    }
}