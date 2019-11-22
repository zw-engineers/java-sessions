package com.functional;

import io.vavr.collection.List;

class University {
    List<Degree> assignToCompScienceDegree(List<Student> students) {
        return students
                .map(student -> new Degree("computer science", student, new Tutor("thomas", "jenkins")))
                .collect(List.collector());
    }
}
