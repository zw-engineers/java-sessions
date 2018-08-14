package com.collectionapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionNewMethod {
    public Collection<String> removeElement() {
        // Removes an element on a Predicate.
        Collection<String> strings = Arrays.asList("one", "two", "three", "four");

        // Will not work if list in unmodifiable
        Collection<String> list = new ArrayList<>(strings);

        // Returns true if list has been modified.
        boolean b = list.removeIf(s -> s.equals("three"));

        // Return modified list.
        return list;
    }

    public List<String> toUpperCase(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }
}
