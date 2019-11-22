package com.functional;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Objects;

class University {

    private static final String SOFTWARE_ENGINEERING = "software engineering";

    List<Student> getAllStudentsSortedByFirstName(List<Student> students) {
        return students
                .sortBy(Student::getName);
    }

    List<Student> getAllSoftwareEngineeringStudents(List<Student> students) {
        return students
                .filter(student -> SOFTWARE_ENGINEERING.equals(student.getDegree().getTitle()));
    }

    List<Student> getAllNonNullSoftwareEngineeringStudents(List<Student> students) {
        return students
                .filter(Objects::nonNull)
                .filter(student -> SOFTWARE_ENGINEERING.equals(student.getDegree().getTitle()));
    }

    List<Student> getAllStudents(List<Student> students) {
        // no more null checks :D
        return Option.of(students)
                .getOrElse(List::empty);
    }
}
