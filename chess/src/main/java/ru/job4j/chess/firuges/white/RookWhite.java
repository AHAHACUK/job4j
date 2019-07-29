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
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (!isStraight(source, dest)) {
            return new Cell[0];
        }
        int deltaX = 0;
        int deltaY = 0;
        if (source.x < dest.x) {
            deltaX = 1;
        } else if (source.x > dest.x) {
            deltaX = -1;
        }
        if (source.y < dest.y) {
            deltaY = 1;
        } else if (source.y > dest.y) {
            deltaY = -1;
        }
        for (int i = 1; i <= (Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y)); i++) {
            steps = Arrays.copyOf(steps, steps.length + 1);
            steps[steps.length - 2] = Cell.findByCoords(source.x + (deltaX * i), source.y + (deltaY * i));
        }
        return new Cell[] { dest };
    }

    private boolean isStraight(Cell source, Cell dest) {
        boolean result = (dest.x - source.x == 0) || (dest.y - source.y == 0);
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
