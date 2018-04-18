package com.streams.collector;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class AggregationKata3 {

    public static Map<String, List<String>> getStudentNamesByDepartment(Stream<Student> students) {
        return students.collect(
                groupingBy(
                        Student::getDepartment,
                        mapping(Student::getName, toList())
                )
        );
    }

}