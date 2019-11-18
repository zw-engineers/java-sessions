package com.functional;

import com.google.common.collect.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FunctionalProgramming {

    // Using Java 8 IntStream
    static List<String> mapNamesToAgesWithJavaStreams(List<String> names, List<Integer> ages) {
        return IntStream
                .range(0, Math.min(names.size(), ages.size()))
                .mapToObj(index -> names.get(index) + ":" + ages.get(index))
                .collect(Collectors.toList());
    }

    // Using Guava Streams
    static List<String> mapNamesToAgesWithGuavaStreams(List<String> names, List<Integer> ages) {
        return Streams
                .zip(names.stream(), ages.stream(), (name, age) -> name + ":" + age)
                .collect(Collectors.toList());
    }

}