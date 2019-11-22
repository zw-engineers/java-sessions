package com.functional;

import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class UniversityTest {

    private University university;
    private static final Degree degree1 = new Degree("computer science", new Student("artemas", "muzanenhamo"), new Tutor("thomas", "jenkins"));
    private static final Degree degree2 = new Degree("computer science", new Student("kevin", "hart"), new Tutor("thomas", "jenkins"));
    private static final Degree degree3 = new Degree("computer science", new Student("lebron", "james"), new Tutor("thomas", "jenkins"));
    private static final Degree degree4 = new Degree("computer science", new Student("kobe", "bryant"), new Tutor("thomas", "jenkins"));

    @BeforeEach
    void setup() {
        university = new University();
    }

    @Test
    @DisplayName("Should return Students assigned to a degree")
    void getAllStudents() {
        List<Student> students = List.of(
                new Student("artemas", "muzanenhamo"),
                new Student("kevin", "hart"),
                new Student("lebron", "james"),
                new Student("kobe", "bryant")
        );

        List<Degree> degrees = university.assignToCompScienceDegree(students);

        assertThat(degrees).isNotEmpty();
        assertThat(degrees).hasSize(4);
        assertThat(degrees).containsExactly(degree1, degree2, degree3, degree4);
    }
}