package com.functional;

import java.util.List;
import java.util.stream.Collectors;

class University {
    List<Degree> assignToCompScienceDegree(List<Student> students) {
        return students
                .stream()
                .map(student -> new Degree("computer science", student, new Tutor("thomas", "jenkins")))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
