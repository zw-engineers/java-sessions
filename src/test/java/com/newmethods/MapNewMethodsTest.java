package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapNewMethodsTest {
    private MapNewMethods mapNewMethods;

    @BeforeEach
    void setUp() {
        mapNewMethods = new MapNewMethods();
    }

    @Test
    void shouldReturnListOfPersons(){
        List<Person> expectedPeople = Arrays.asList(
                new Person("Artemas", "Muzanenhamo"),
                new Person("John", "Smith")
        );

        assertEquals(expectedPeople, mapNewMethods.retrievePeople());
    }

    @Test
    void shouldReturnADefaultPerson(){
        Person expectedPerson = new Person("Artemas", "Muzanenhamo");
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person("Thomas", "Jefferson"));

        assertEquals(expectedPerson, mapNewMethods.getPerson(personMap));
    }

    @Test
    void shouldReturnAMapOfTwoPeople(){
        Person expectedPerson1 = new Person("Artemas", "Muzanenhamo");
        Person expectedPerson2 = new Person("Jimmy", "Butler");
        Map<Integer, Person> expectedMap = new HashMap<>();
        expectedMap.put(1, expectedPerson1);
        expectedMap.put(2, expectedPerson2);

        assertEquals(expectedMap, mapNewMethods.getPeople());
    }

    @Test
    void shouldReturnAMapWithANewPerson(){
        Person person = new Person("Artemas", "Muzanenhamo");
        Map<Integer, Person> expectedPerson = new HashMap<>();
        expectedPerson.put(1, person);

        Person person1 = new Person("Thomas", "Jefferson");
        Map<Integer, Person> replacedPerson = new HashMap<>();
        replacedPerson.put(1, person1);

        assertEquals(expectedPerson, mapNewMethods.replacePerson(replacedPerson));
    }

    @Test
    void shouldReturnAMapWithANewPerson2(){
        Person person = new Person("Artemas", "Muzanenhamo");
        Map<Integer, Person> expectedPerson = new HashMap<>();
        expectedPerson.put(1, person);

        Person person1 = new Person("Thomas", "Jefferson");
        Map<Integer, Person> replacedPerson = new HashMap<>();
        replacedPerson.put(1, person1);

        assertEquals(expectedPerson, mapNewMethods.replaceOldPersonWithNewPerson(replacedPerson));
    }

    @Test
    void shouldReplaceAllPeopleInTheMap(){
        Person person = new Person("Artemas", "Muzanenhamo");
        Map<Integer, Person> expectedPerson = new HashMap<>();
        expectedPerson.put(1, person);
        expectedPerson.put(2, person);
        expectedPerson.put(3, person);

        Person person1 = new Person("Thomas", "Jefferson");
        Person person2 = new Person("Will", "Smith");
        Person person3 = new Person("John", "Doe");
        Map<Integer, Person> replacedPerson = new HashMap<>();
        replacedPerson.put(1, person1);
        replacedPerson.put(2, person2);
        replacedPerson.put(3, person3);

        assertEquals(expectedPerson, mapNewMethods.replaceAllPeople(replacedPerson));
    }

    @Test
    void shouldReturnAMapWithAPersonRemoved(){
        Person person1 = new Person("Thomas", "Jefferson");
        Person person2 = new Person("Will", "Smith");
        Person person3 = new Person("John", "Doe");
        Map<Integer, Person> people = new HashMap<>();
        people.put(1, person1);
        people.put(2, person2);
        people.put(3, person3);

        Map<Integer, Person> expectedPeople = new HashMap<>();
        expectedPeople.put(1, person1);
        expectedPeople.put(3, person3);

        assertEquals(expectedPeople, mapNewMethods.removeAPerson(2, people));
    }

    @Test
    void shouldReturnMapWithAPersonRemoved(){
        Person person1 = new Person("Thomas", "Jefferson");
        Person person2 = new Person("Will", "Smith");
        Person person3 = new Person("John", "Doe");
        Map<Integer, Person> people = new HashMap<>();
        people.put(1, person1);
        people.put(2, person2);
        people.put(3, person3);

        Map<Integer, Person> expectedPeople = new HashMap<>();
        expectedPeople.put(1, person1);
        expectedPeople.put(3, person3);

        assertEquals(expectedPeople, mapNewMethods.removeAPersonWithValue(2, people));
    }

    @Test
    void shouldReturnAMergedMap(){
        Person person1 = new Person("Thomas", "Jefferson");
        Person person2 = new Person("Will", "Smith");
        Person person3 = new Person(null, null);
        Map<Integer, Person> people = new HashMap<>();
        people.put(1, person1);
        people.put(2, person2);
        people.put(3, person3);

        Map<Integer, Person> expectedPeople = new HashMap<>();
        expectedPeople.put(1, person1);
        expectedPeople.put(2, person2);
        expectedPeople.put(3, new Person("John", "Doe"));
        expectedPeople.put(4, new Person("Lebron", "James"));

        assertEquals(expectedPeople, mapNewMethods.mergePeople(people));
    }

}