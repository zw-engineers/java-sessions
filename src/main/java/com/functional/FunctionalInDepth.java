package com.functional;

import io.vavr.collection.List;


class FunctionalInDepth {

    List<String> getNamesCapitalised(List<String> names) {
        // In Java 8 streams...
//        names.stream().map(String::toUpperCase).collect(Collectors.toList());
        return names
                .map(String::toUpperCase)
                .collect(List.collector());
    }
}
