package ru.job4j.shapes;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append("+++++++\n");
        return pic.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}