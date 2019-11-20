package com.functional;

import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.control.Option;


class FunctionalInDepth {

    List<String> getNamesCapitalised(List<String> names) {
//        names.stream().map(String::toUpperCase).collect(Collectors.toList());
        return Option.of(names)
                .map(Value::getOrNull)
                .map(String::toUpperCase)
                .toList();
    }
}
