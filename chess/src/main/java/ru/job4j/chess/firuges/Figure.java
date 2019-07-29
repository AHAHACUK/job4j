package ru.job4j.chess.firuges;

import ru.job4j.chess.OccupiedWayException;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws OccupiedWayException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
