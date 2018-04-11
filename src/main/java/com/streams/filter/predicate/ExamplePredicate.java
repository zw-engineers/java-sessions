package com.streams.filter.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExamplePredicate {

    public List<String> filter(List<String> list) {
        Predicate<String> predicate = Predicate.isEqual("two");
        list = list.stream().filter(predicate).collect(Collectors.toList());
        return list;
    }

}
