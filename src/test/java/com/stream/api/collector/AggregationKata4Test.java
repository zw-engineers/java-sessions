package com.stream.api.collector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.stream.api.collector.AggregationKata4.getTheNumberOfStudentsByGenderForEachDepartment;
import static org.junit.Assert.assertEquals;

class AggregationKata4Test {

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
    @DisplayName("Should get the number of students by gender for each department")
    void basicTestGetTheNumberOfStudentsByGenderForEachDepartment() {

        Map<String, Map<Student.Gender, Long>> actual = getTheNumberOfStudentsByGenderForEachDepartment(Arrays.stream(students));
        Map<String, Map<Student.Gender, Long>> expected = new HashMap<>();
        Map<Student.Gender, Long> map1 = new HashMap<>();
        Map<Student.Gender, Long> map2 = new HashMap<>();
        map1.put(Student.Gender.MALE, 1L);
        map1.put(Student.Gender.FEMALE, 1L);
        map2.put(Student.Gender.MALE, 2L);
        map2.put(Student.Gender.FEMALE, 1L);
        expected.put("CS", map1);
        expected.put("Philology", map2);

        assertEquals(expected, actual);

    }

}
