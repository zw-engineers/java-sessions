package com.newmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapNewMethods {
    public List<Person> retrievePeople() {
        Map<Integer, Person> personMap = new HashMap<>();
        List<Person> people = new ArrayList<>();

        personMap.put(1, new Person("Artemas", "Muzanenhamo"));
        personMap.put(2, new Person("John", "Smith"));

        personMap.forEach((key, person) -> people.add(person));

        return people;
    }
}
