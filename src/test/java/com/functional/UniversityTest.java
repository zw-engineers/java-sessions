package com.functional;

import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniversityTest {

    private University university;
    private final static Student student1 = new Student("artemas", "muzanenhamo", new Degree("software engineering"), new Tutor("thomas", "jenkins"));
    private final static Student student2 = new Student("sarah", "smith", new Degree("bio chemistry"), new Tutor("lebron", "james"));
    private final static Student student3 = new Student("bode", "ade", new Degree("business management"), new Tutor("kobe", "bryant"));
    private final static Student student4 = new Student("mary", "stevens", new Degree("software engineering"), new Tutor("thomas", "jenkins"));

    @BeforeEach
    void setup() {
        university = new University();
    }

    @Test
    @DisplayName("Should return all students with their degree and tutor")
    void getAllStudents() {
        List<Student> students = List.of(student1, student2, student3, student4);

        List<Student> allStudents = university.getAllStudentsSortedByFirstName(students);

        assertThat(allStudents).isNotEmpty();
        assertThat(allStudents).containsExactly(student1, student3, student4, student2);
    }


}