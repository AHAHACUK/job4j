package ru.job4j.chess.firuges.black;

import ru.job4j.chess.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws OccupiedWayException{
        Cell[] steps = new Cell[0];
        if (!isStraight(source, dest)) {
            throw new OccupiedWayException();
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
        steps = new Cell[Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y)];
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.findByCoords(source.x + (deltaX * i), source.y + (deltaY * i));
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = Math.abs(source.x - source.y) == Math.abs(dest.x - dest.y);
        return result;
    }

    private boolean isStraight(Cell source, Cell dest) {
        boolean result = (dest.x - source.x == 0) || (dest.y - source.y == 0);
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
