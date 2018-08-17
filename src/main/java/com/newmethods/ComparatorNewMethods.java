package com.newmethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorNewMethods {
    public List<Person> namesInOrder() {
        List<Person> people = Arrays.asList(
                new Person("Lemuel", "Muzanenhamo"),
                new Person("Thomas", "Jefferson"),
                new Person("Artemas", "Muzanenhamo")
        );

        people.sort(Comparator.comparing(Person::getLastName)
                .thenComparing(Comparator.comparing(Person::getName)));

        return people;
    }
}
