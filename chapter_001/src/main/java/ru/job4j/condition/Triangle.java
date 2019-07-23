package ru.job4j.condition;

public class Triangle {

    private Point x;
    private Point y;
    private Point z;

    public Triangle(Point x, Point y, Point z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double period() {
        double a = this.x.distance(this.y);
        double b = this.y.distance(this.z);
        double c = this.z.distance(this.x);
        return (a + b + c) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return
     */
    private boolean exist(double a, double c, double b) {
        return (a < b + c && b < a + c && c < a + b);

    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - a) * (p - b) * (p - c)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = this.x.distance(this.y);
        double b = this.y.distance(this.z);
        double c = this.z.distance(this.x);
        double p = period();
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }
}