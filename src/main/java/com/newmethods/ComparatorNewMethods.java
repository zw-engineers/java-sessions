package com.newmethods;

import java.util.Comparator;
import java.util.List;

public class ComparatorNewMethods {
    public List<Person> namesInOrder(List<Person> people) {
        people.sort(Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getName));

        return people;
    }
}
