package com.functional;

import java.util.List;
import java.util.stream.Collectors;

class University {
    List<Degree> assignToCompScienceDegree(List<Student> students) {
        return students
                .stream()
                .map(e -> new Degree("computer science", e, new Tutor("thomas", "jenkins")))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
