package com.newmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListNewMethod {
    public List<String> sortedList() {
        // Removes an element on a predicate
        List<String> strings = Arrays.asList("one", "two", "three", "four");

        // will not work if list is unmodifiable
        List<String> list = new ArrayList<>(strings);

        // Doesn't return anything
        list.sort(Comparator.naturalOrder());

        return list;
    }
}
