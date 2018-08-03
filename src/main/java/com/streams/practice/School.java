package com.streams.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class School {

    public static void main(String[] args) {
        List<String> s1Subjects = Arrays.asList("Maths", "Science", "English");
        List<String> s2Subjects = Arrays.asList("History", "Music", "English");
        List<String> s3Subjects = Arrays.asList("Content", "Geography", "Maths");
        Student st1 = new Student(1234, "Artemas", "Muzanenhamo", s1Subjects, 24);
        Student st2 = new Student(1234, "Thomas", "Jenkins", s2Subjects, 30);
        Student st3 = new Student(1234, "Kate", "Johnson", s3Subjects, 20);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);

        // sort by age
        System.out.println(
                students
                        .stream()
                        .sorted(Comparator.comparing(Student::getAge).reversed())
                        .collect(Collectors.toList()));

        // get all subjects as unique
        System.out.println(
                students
                        .stream()
                        .flatMap(student -> student.getSubjects().stream())
                        .distinct()
                        .collect(Collectors.toList()));

        // get all Students studying English
        System.out.println(
                students
                        .stream()
                        .filter(student -> student.getSubjects().contains("English"))
                        .collect(Collectors.toList()));
    }

}
