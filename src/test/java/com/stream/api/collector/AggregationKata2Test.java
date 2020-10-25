package com.stream.api.collector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.stream.api.collector.AggregationKata2.getNumberOfStudentsByDepartment;
import static org.junit.Assert.assertEquals;

class AggregationKata2Test {

    private Student[] students;

    @BeforeEach
    void setUp() {

        //Generate a basic array of students:
        Student galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
        Student anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
        Student jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
        Student mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
        Student jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);

        students = new Student[]{galina, anton, jack, mike, jane};

    }

    @Test
    @DisplayName("Should get number of students by department")
    void basicTestGetNumberOfStudentsByDepartment() {

        Map<String, Long> actual = getNumberOfStudentsByDepartment(Arrays.stream(students));
        Map<String, Long> expected = new HashMap<>();
        expected.put("CS", 2L);
        expected.put("Philology", 3L);

        assertEquals(expected, actual);
    }

}
