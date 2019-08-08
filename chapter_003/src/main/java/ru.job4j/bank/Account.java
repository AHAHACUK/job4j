package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {
        value = value < 0 ? 0 : value;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (amount > 0 && this.value >= amount) {
            this.setValue(this.value - amount);
            dest.setValue(dest.getValue() + amount);
            result = true;
        }
        return result;
    }
}
