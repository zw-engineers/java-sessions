package com.functional;

import com.functional.domain.Degree;
import com.functional.domain.Student;
import com.functional.domain.Tutor;
import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniversityTest {

    private University university;
    private final static Student student1 = new Student("artemas", "muzanenhamo", new Degree("software engineering"), new Tutor("thomas", "jenkins"));
    private final static Student student2 = new Student("sarah", "smith", new Degree("bio chemistry"), new Tutor("lebron", "james"));
    private final static Student student3 = new Student("bode", null, new Degree("business management"), new Tutor("kobe", "bryant"));
    private final static Student student4 = new Student("mary", "stevens", new Degree("software engineering"), new Tutor(null, "jenkins"));
    private final static Student student5 = new Student(null, "johnson", new Degree("pure mathematics"), null);
    private final static Student student6 = new Student("john-bosco", "adetoula", null, new Tutor("carmelo", "anthony"));

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

    @Test
    @DisplayName("Should return all students studying Software Engineering")
    void getAllSoftwareEngineeringStudents() {
        List<Student> students = List.of(student1, student2, student3, student4);

        List<Student> allStudents = university.getAllSoftwareEngineeringStudents(students);

        assertThat(allStudents).isNotEmpty();
        assertThat(allStudents).hasSize(2);
        assertThat(allStudents).containsExactly(student1, student4);
    }

    @Test
    @DisplayName("Should return all non null students studying Software Engineering")
    void getAllNonNullSoftwareStudents() {
        List<Student> students = List.of(student1, student2, student3, null);

        List<Student> allStudents = university.getAllSoftwareEngineeringStudents(students);

        assertThat(allStudents).isNotEmpty();
        assertThat(allStudents).hasSize(1);
        assertThat(allStudents).containsExactly(student1);
    }

    @Test
    @DisplayName("Should return an empty list of students when the list of students is null")
    void returnEmptyListWhenStudentsListIsNull() {
        List<Student> allStudents = university.getAllSoftwareEngineeringStudents(null);

        assertThat(allStudents).isEmpty();
    }

    @Test
    @DisplayName("Should return all students with a valid tutor")
    void returnAllStudentsWithOrderedByTutor() {
        List<Student> students = List.of(student1, student2, student3, student4, student5, student6);

        List<Student> allStudents = university.getAllStudentsSortedByTutor(students);

        assertThat(allStudents).isNotEmpty();
        assertThat(allStudents).hasSize(4);
        assertThat(allStudents).containsExactly(student6, student3, student2, student1);
    }
}