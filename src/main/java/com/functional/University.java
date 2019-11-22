package com.functional;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Objects;
import java.util.function.Function;

class University {

    private static final String SOFTWARE_ENGINEERING = "software engineering";

    List<Student> getAllStudentsSortedByFirstName(List<Student> students) {
        return students
                .sortBy(Student::getName);
    }

    List<Student> getAllSoftwareEngineeringStudents(List<Student> students) {
        return Option.of(students)
                .getOrElse(List::empty)
                .filter(Objects::nonNull)
                .filter(student -> SOFTWARE_ENGINEERING.equals(student.getDegree().getTitle()));
    }

    List<Student> getAllStudentsSortedByTutor(List<Student> students) {
        return students
                .filter(student -> Objects.nonNull(student.getTutor()))
                .filter(student -> Objects.nonNull(student.getTutor().getName()))
                .sortBy(studentTutor());
    }

    private Function<Student, String> studentTutor() {
        return student -> student.getTutor().getName();
    }
}
