package job4j.tictactoe;

import ru.job4j.chess.firuges.Figure;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean chechFields(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0) ||
                this.fillBy(predicate, 0, 0, 0, 1) ||
                this.fillBy(predicate, 0, 1, 1, 0) ||
                this.fillBy(predicate, 0, 2, 1, 0) ||
                this.fillBy(predicate, 1, 0, 0, 1) ||
                this.fillBy(predicate, 2, 0, 0, 1) ||
                this.fillBy(predicate, 0,0, 1, 1) ||
                this.fillBy(predicate, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerX() {
        return chechFields(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return chechFields(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean result = false;
        for (Figure3T[] line : table) {
            for (Figure3T el : line) {
                if (!el.hasMarkO() && !el.hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return true;
    }
}
