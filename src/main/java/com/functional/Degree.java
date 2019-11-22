package com.functional;

import java.util.Objects;

public class Degree {
    private String title;
    private Student student;
    private Tutor tutor;

    public Degree(String title, Student student, Tutor tutor) {
        this.title = title;
        this.student = student;
        this.tutor = tutor;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return Objects.equals(title, degree.title) &&
                Objects.equals(student, degree.student) &&
                Objects.equals(tutor, degree.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, student, tutor);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "title='" + title + '\'' +
                ", student=" + student +
                ", tutor=" + tutor +
                '}';
    }
}
