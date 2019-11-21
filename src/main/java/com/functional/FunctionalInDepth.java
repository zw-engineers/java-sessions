package com.functional;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Objects;


class FunctionalInDepth {

    List<String> getNamesCapitalised(List<String> names) {
        // In Java 8 streams...
//        names.stream().map(String::toUpperCase).collect(Collectors.toList());

        return Option.of(names)
                .getOrElse(List::empty)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(List.collector());
    }
}
