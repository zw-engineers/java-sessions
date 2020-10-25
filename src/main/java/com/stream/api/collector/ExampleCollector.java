package com.stream.api.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ExampleCollector {
    List<String> getNamesList(String[] names) {
        return Arrays.stream(names)
                .collect(Collectors.toList());
    }
}
