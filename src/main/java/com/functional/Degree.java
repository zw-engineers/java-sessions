package com.functional;

import java.util.Objects;

public class Degree {
    private String title;

    public Degree(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return Objects.equals(title, degree.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "title='" + title + '\'' +
                '}';
    }
}
