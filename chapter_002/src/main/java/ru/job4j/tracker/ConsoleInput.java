package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range){
        int value = Integer.valueOf(this.ask(question));
        boolean isExist = false;
        for (int v : range) {
            if (v == value) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new MenuOutException("Выход за границы меню.");
        }
        return value;
    }
}
