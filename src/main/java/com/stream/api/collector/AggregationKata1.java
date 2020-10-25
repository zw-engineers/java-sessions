package com.stream.api.collector;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AggregationKata1 {

    static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
        return students.collect(
                Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.averagingDouble(Student::getGrade)
                )
        );
    }

}
