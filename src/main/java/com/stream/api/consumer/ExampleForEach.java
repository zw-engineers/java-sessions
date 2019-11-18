package com.stream.api.consumer;

import com.stream.api.Person;

import java.util.ArrayList;
import java.util.List;

public class ExampleForEach {
    public List<Person> getOver20(List<Person> people) {
        List<Person> over20s = new ArrayList<>();

        people.stream() // Here we open a Stream
                .filter(person -> person.getAge() >= 18) // Here we use our Predicate to filter people aged >= 18
                .forEach(over20s::add); // We perform an operation on each person to be added to the over20s List

        return over20s;
    }
}
