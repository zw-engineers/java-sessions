package com.streams.map;

import java.util.List;
import java.util.function.ToIntFunction;

public class ExampleMap {
    public int countLists(List<String> list) {
        // Here we create our ToIntFunction which can take a String and parse it into an Integer.
        ToIntFunction<String> mapper = Integer::parseInt;

        return list.stream() // Here we declare our Stream.
                .mapToInt(mapper) // Here we
                .sum();
    }
}
