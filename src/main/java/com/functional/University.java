package com.functional;

import io.vavr.collection.List;

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
}
