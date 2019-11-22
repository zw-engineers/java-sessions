package com.functional;

import io.vavr.collection.List;

class University {

    public List<Student> getAllStudentsSortedByFirstName(List<Student> students) {
        return students
                .sortBy(Student::getName);
    }
}
