package com.newmethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListNewMethod {
    List<String> sortedList(List<String> strings) {
        // Removes an element on a predicate
//        List<String> strings = Arrays.asList("one", "two", "three", "four");

        // will not work if list is unmodifiable
        List<String> list = new ArrayList<>(strings);

        // Doesn't return anything
        list.sort(Comparator.naturalOrder());

        return list;
    }
}
