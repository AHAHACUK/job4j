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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws OccupiedWayException {
        Cell[] steps = new Cell[0];
        if (!isDiagonal(source, dest)) {
            throw new OccupiedWayException();
        }
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        steps = new Cell[Math.abs(source.x - source.y)];
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.findByCoords(source.x + (deltaX * i), source.y + (deltaY * i));
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = Math.abs(source.x - source.y) == Math.abs(dest.x - dest.y);
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
