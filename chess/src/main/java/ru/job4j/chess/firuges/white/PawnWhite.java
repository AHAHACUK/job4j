package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.y - source.y <= 2 && source.x == dest.x) {
            for (int i = 1; i <= dest.y - source.y; i++) {
                steps = Arrays.copyOf(steps, steps.length + 1);
                steps[steps.length - 2] = Cell.findByCoords(source.x, source.y + i);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
