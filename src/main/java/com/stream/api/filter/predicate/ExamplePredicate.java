package com.stream.api.filter.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamplePredicate {

    public List<String> filter(List<String> list) {
        Predicate<String> predicate = Predicate.isEqual("two");
        list = list.stream().filter(predicate).collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {

        // Given a Stream of Strings
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        // Given a Predicate of string length > 3
        Predicate<String> predicate = s -> s.length() > 3;

        // Given a Predicate that is EQUAL to "two"
        Predicate<String> predicate1 = Predicate.isEqual("two");

        // Given a Predicate that is EQUAL to "three"
        Predicate<String> predicate2 = Predicate.isEqual("three");

        // Print strings given the passed in predicate
        stream
                .filter(predicate1.or(predicate2))
                .forEach(System.out::println);

    }

}
