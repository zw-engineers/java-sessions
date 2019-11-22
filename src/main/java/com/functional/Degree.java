package com.functional;

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
    public String toString() {
        return "Degree{" +
                "title='" + title + '\'' +
                ", student=" + student +
                ", tutor=" + tutor +
                '}';
    }
}
