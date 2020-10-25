package com.stream.api.practice;

import java.util.List;
import java.util.Objects;

public class Student {

    private final int id;
    private final String name;
    private final String surname;
    private final List<String> subjects;
    private final int age;


    public Student(int id, String name, String surname, List<String> subjects, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, subjects, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subjects=" + subjects +
                ", age=" + age +
                '}';
    }
}
