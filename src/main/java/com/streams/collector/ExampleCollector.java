package com.streams.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleCollector {
    public List<String> getNamesList(String[] names) {
        return Arrays.stream(names)
                .collect(Collectors.toList());
    }
}
