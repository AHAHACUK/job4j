package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean isValid = false;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число.");
            } catch (MenuOutException e) {
                System.out.println("Введите число из меню.");
            }
        } while (!isValid);
        return value;
    }
}
