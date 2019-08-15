package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    public int calculate(int[] numbers) {
        int result = 0;
        result = Arrays.stream(numbers).filter(e -> e % 2 == 0).map(e -> e*e).reduce(0, Integer::sum);
        return result;
    }
}
