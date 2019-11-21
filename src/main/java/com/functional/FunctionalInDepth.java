package com.functional;

import io.vavr.collection.List;
import io.vavr.control.Option;


class FunctionalInDepth {

    List<String> getNamesCapitalised(List<String> names) {
        // In Java 8 streams...
//        names.stream().map(String::toUpperCase).collect(Collectors.toList());

//        Option.of(names)
//                .getOrElse(List::empty)
//                .map(Option::of)
//                .map(Value::getOrNull)
//                .filter(Objects::nonNull)
//                .map(String::toUpperCase)
//                .collect(List.collector());

        return Option.of(names)
                .getOrElse(List::empty)
                .map(Option::of)
                .flatMap(name -> name)
                .map(String::toUpperCase)
                .collect(List.collector());
    }
}
