package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (!isDiagonal(source, dest)) {
            return new Cell[0];
        }
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 1; i <= Math.abs(dest.x - source.x); i++) {
            steps = Arrays.copyOf(steps, steps.length + 1);
            steps[steps.length - 2] = Cell.findByCoords(source.x + (deltaX * i), source.y + (deltaY * i));
        }
        return new Cell[] { dest };
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = Math.abs(source.x - source.y) == Math.abs(dest.x - dest.y);
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
